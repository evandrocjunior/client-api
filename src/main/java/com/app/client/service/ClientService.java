package com.app.client.service;

import com.app.client.apiclient.ViaCepApiClient;
import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.exception.AddressNotFound;
import com.app.client.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ViaCepApiClient viaCepApiClient;

    public Client create(Client client) {
        final String cep = client.address().cep();
        final AddressViaCep addressViaCep = viaCepApiClient.getAddress(cep);
        if (addressViaCep.cep() == null) {
            throw new AddressNotFound("Address not exist to cep %s".formatted(cep));
        }
        final Client clientAddressUpdated = client.updateAddressFrom(addressViaCep);


        return null;
    }
}
