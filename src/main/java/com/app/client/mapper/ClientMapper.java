package com.app.client.mapper;

import com.app.client.controller.request.ClientRequest;
import com.app.client.controller.response.ClientResponse;
import com.app.client.model.Address;
import com.app.client.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client from(ClientRequest clientRequest);

    Address from(ClientRequest.AddressRequest addressRequest);
    ClientResponse from(Client client);
}
