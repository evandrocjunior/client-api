package com.app.client.service;

import com.app.client.apiclient.ViaCepApiClient;
import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.model.Client;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ViaCepApiClient viaCepApiClient;

    public Client create(Client client) {
        final AddressViaCep addressViaCep = viaCepApiClient.getAddress(client.address().cep());
        return null;
    }
}
