package com.app.client.service;

import com.app.client.apiclient.ViaCepApiClient;
import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.controller.request.ClientRequest;
import com.app.client.controller.response.ClientResponse;
import com.app.client.exception.AddressNotFound;
import com.app.client.exception.CPFAlreadyExistException;
import com.app.client.mapper.ClientEntityMapper;
import com.app.client.mapper.ClientMapper;
import com.app.client.mapper.ClientResponseMapper;
import com.app.client.model.Client;
import com.app.client.repository.ClientRepository;
import com.app.client.repository.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ViaCepApiClient viaCepApiClient;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;
    private final ClientResponseMapper clientResponseMapper;
    private final ClientMapper clientMapper;

    public ClientResponse create(ClientRequest clientRequest) {
        final Client client = clientMapper.from(clientRequest);
        final String cep = client.address().cep();
        final AddressViaCep addressViaCep = getAddressViaCep(cep);
        final Client clientAddressUpdated = client.updateAddressFrom(addressViaCep);
        final ClientEntity clientEntity = clientEntityMapper.from(clientAddressUpdated);
        final ClientEntity clientSaved = saveClient(clientEntity);
        return clientResponseMapper.from(clientSaved);
    }

    private ClientEntity saveClient(ClientEntity clientEntity) {
        ClientEntity clientSaved;
        try {
            clientSaved = clientRepository.save(clientEntity);
        } catch (DataIntegrityViolationException exception) {
            throw new CPFAlreadyExistException("Cpf already exist %s".formatted(clientEntity.getCpf()));
        }
        return clientSaved;
    }

    public AddressViaCep getAddressViaCep(String cep) {
        final AddressViaCep addressViaCep = viaCepApiClient.getAddress(cep);
        if (addressViaCep.cep() == null) {
            throw new AddressNotFound("Address not exist to cep %s".formatted(cep));
        }
        return addressViaCep;
    }
}
