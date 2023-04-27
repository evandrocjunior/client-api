package com.app.client.presentation.mapper;

import com.app.client.applicationservice.domain.entity.Client;
import com.app.client.presentation.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client from(ClientDto clientDto);
}
