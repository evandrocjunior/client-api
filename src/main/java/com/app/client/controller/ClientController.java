package com.app.client.controller;

import com.app.client.controller.response.ClientResponse;
import com.app.client.model.Client;
import com.app.client.service.ClientService;
import com.app.client.controller.request.ClientRequest;
import com.app.client.mapper.ClientMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1.0/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        final Client client = clientMapper.from(clientRequest);
        final Client clientCreated = clientService.create(client);
        return clientMapper.from(clientCreated);
    }
}
