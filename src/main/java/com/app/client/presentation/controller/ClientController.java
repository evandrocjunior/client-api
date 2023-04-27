package com.app.client.presentation.controller;

import com.app.client.applicationservice.clientsservice.CreateClientsService;
import com.app.client.applicationservice.domain.entity.Client;
import com.app.client.presentation.dto.ClientDto;
import com.app.client.presentation.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1.0/clients")
@RequiredArgsConstructor
public class ClientController {
    private final CreateClientsService createClientsService;
    private final ClientMapper clientMapper;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        final Client client = clientMapper.from(clientDto);

        createClientsService.create(client);
        return clientDto;
    }
}
