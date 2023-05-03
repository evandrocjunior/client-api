package com.app.client.controller;

import com.app.client.controller.request.ClientRequest;
import com.app.client.controller.response.ClientResponse;
import com.app.client.service.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1.0/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.create(clientRequest);
    }
}
