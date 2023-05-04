package com.app.client.controller;

import com.app.client.controller.request.ClientRequest;
import com.app.client.controller.response.ClientResponse;
import com.app.client.service.ClientService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/{id}")
    public ClientResponse getClient(@PathVariable(value = "id") UUID id) {
        return clientService.getClientById(id);
    }

    @GetMapping
    public List<ClientResponse> getClientBy(@RequestParam(value = "cpf", required = false) String cpf) {
        return clientService.getClientBy(cpf);
    }
}
