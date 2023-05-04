package com.app.client.mapper;

import com.app.client.controller.response.ClientResponse;
import com.app.client.repository.entity.AddressEntity;
import com.app.client.repository.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientResponseMapper {

    ClientResponse from(ClientEntity client);

    ClientResponse.AddressResponse from(AddressEntity address);
}
