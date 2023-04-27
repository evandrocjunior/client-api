package com.app.client.mapper;

import com.app.client.controller.request.ClientRequest;
import com.app.client.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client from(ClientRequest clientRequest);
}
