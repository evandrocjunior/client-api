package com.app.client.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.app.client.apiclient.ViaCepApiClient;
import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.controller.request.ClientRequest;
import com.app.client.controller.response.ClientResponse;
import com.app.client.exception.AddressNotFoundException;
import com.app.client.exception.CPFAlreadyExistException;
import com.app.client.mapper.ClientEntityMapper;
import com.app.client.mapper.ClientEntityMapperImpl;
import com.app.client.mapper.ClientMapper;
import com.app.client.mapper.ClientMapperImpl;
import com.app.client.mapper.ClientResponseMapper;
import com.app.client.mapper.ClientResponseMapperImpl;
import com.app.client.repository.ClientRepository;
import com.app.client.repository.entity.AddressEntity;
import com.app.client.repository.entity.ClientEntity;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ClientServiceTest {
    @Mock
    private ViaCepApiClient viaCepApiClient;
    @Mock
    private ClientRepository clientRepository;
    @Spy
    private ClientEntityMapper clientEntityMapper = new ClientEntityMapperImpl();
    @Spy
    private ClientResponseMapper clientResponseMapper = new ClientResponseMapperImpl();
    @Spy
    private ClientMapper clientMapper = new ClientMapperImpl();

    @InjectMocks
    private ClientService clientService;

    @Captor
    private ArgumentCaptor<String> cepArgumentCaptor;

    @Captor
    private ArgumentCaptor<ClientEntity> clientEntityArgumentCaptor;

    @Test
    void should_create_client() {
        final AddressViaCep addressViaCep = addressViaCepFactory();
        when(viaCepApiClient.getAddress(cepArgumentCaptor.capture())).thenReturn(addressViaCep);
        when(clientRepository.save(clientEntityArgumentCaptor.capture())).thenReturn(clientEntityFactory());

        final ClientRequest clientRequest = clientRequestFactory();
        final ClientResponse clientResponse = clientService.create(clientRequest);

        assertNotNull(clientResponse);
        assertNotNull(clientResponse.id());

        assertEquals(clientRequest.address().cep(), cepArgumentCaptor.getValue());
        assertEquals(clientRequest.cpf(), clientResponse.cpf());
        assertEquals(clientRequest.name(), clientResponse.name());

        final ClientEntity clientEntity = clientEntityArgumentCaptor.getValue();
        assertEquals(clientRequest.cpf(), clientEntity.getCpf());
        assertEquals(clientRequest.name(), clientEntity.getName());
        assertEquals(clientRequest.birthdate(), clientEntity.getBirthdate());
    }

    @Test
    void should_throw_addressNotFoundException_when_return_cep_from_via_cep_api_is_null() {
        final AddressViaCep addressViaCep = addressViaCepFactory().toBuilder().cep(null).build();
        when(viaCepApiClient.getAddress(cepArgumentCaptor.capture())).thenReturn(addressViaCep);

        final ClientRequest clientRequest = clientRequestFactory();
        AddressNotFoundException addressNotFound = assertThrows(AddressNotFoundException.class, () -> clientService.create(clientRequest));

        assertEquals(addressNotFound.getMessage(), "Address not exist to cep 01001-000");
    }

    @Test
    void should_throw_cpf_already_exist_exception_when_cpf_already_registered() {
        final AddressViaCep addressViaCep = addressViaCepFactory();
        when(viaCepApiClient.getAddress(cepArgumentCaptor.capture())).thenReturn(addressViaCep);
        when(clientRepository.save(clientEntityArgumentCaptor.capture())).thenThrow(DuplicateKeyException.class);

        final ClientRequest clientRequest = clientRequestFactory();
        CPFAlreadyExistException cpfAlreadyExistException = assertThrows(CPFAlreadyExistException.class, () -> clientService.create(clientRequest));

        assertEquals(cpfAlreadyExistException.getMessage(), "Cpf already exist 60279437005");
    }
    // TODO fazer os testes para o caso de uso de consulta

    public static ClientRequest clientRequestFactory() {
        return ClientRequest.builder()
                .cpf("60279437005")
                .name("Elin Williams")
                .birthdate(LocalDate.now().minusYears(20))
                .address(ClientRequest.AddressRequest.builder()
                        .houseNumber(101)
                        .cep("01001-000")
                        .complement("complement")
                        .build())
                .build();
    }

    public static AddressViaCep addressViaCepFactory() {
        return AddressViaCep.builder()
                .cep("01001-000")
                .logradouro("Praça da Sé")
                .complemento("lado ímpar")
                .bairro("Sé")
                .localidade("São Paulo")
                .uf("SP")
                .ibge(3550308)
                .gia(1004)
                .ddd(11)
                .siafi(7107)
                .build();
    }

    public static ClientEntity clientEntityFactory() {
        return ClientEntity.builder()
                .name("Elin Williams")
                .cpf("60279437005")
                .birthdate(LocalDate.now().minusYears(20))
                .address(AddressEntity.builder()
                        .state("SP")
                        .cep("01001-000")
                        .neighborhood("Sé")
                        .complement("complement")
                        .street("Praça da Sé")
                        .city("São Paulo")
                        .build())
                .build();
    }
}