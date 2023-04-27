package com.app.client.presentation.controller;

import com.app.client.presentation.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1.0/clients")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        LOGGER.info(clientDto.toString());
        return clientDto;
    }
}
