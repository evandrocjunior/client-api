package com.app.client.mapper;

import com.app.client.model.Address;
import com.app.client.model.Client;
import com.app.client.repository.entity.AddressEntity;
import com.app.client.repository.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntity from(Client client);

    AddressEntity from(Address address);
}
