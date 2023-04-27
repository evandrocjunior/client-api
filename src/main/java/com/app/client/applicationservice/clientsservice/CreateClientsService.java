package com.app.client.applicationservice.clientsservice;

import com.app.client.applicationservice.domain.entity.Client;
import org.springframework.stereotype.Service;

@Service
public class CreateClientsService {
    public void create(Client client) {

       Client.Address getAddressByCep(client.address().cep());

    }

    private Client.Address getAddressByCep(String cep) {

    }
}
