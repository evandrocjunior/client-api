package com.app.client.service;

import com.app.client.apiclient.MockApiTest;
import com.app.client.apiclient.ViaCepApiClient;
import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.exception.AddressNotFound;
import com.app.client.mapper.ClientEntityMapper;
import com.app.client.model.Client;
import com.app.client.repository.ClientRepository;
import com.app.client.repository.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ViaCepApiClient viaCepApiClient;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;
    private final MockApiTest mockApiTest;

    public Client create(Client client) {
//        mockApiTest.test();

        final String cep = client.address().cep();
        final AddressViaCep addressViaCep = viaCepApiClient.getAddress(cep);
        if (addressViaCep.cep() == null) {
            throw new AddressNotFound("Address not exist to cep %s".formatted(cep));
        }
        final Client clientAddressUpdated = client.updateAddressFrom(addressViaCep);
        ClientEntity clientSaved = clientRepository.save(clientEntityMapper.from(clientAddressUpdated));
        return null;
    }
}
