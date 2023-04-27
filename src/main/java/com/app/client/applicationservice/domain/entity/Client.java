package com.app.client.applicationservice.domain.entity;

import com.app.client.presentation.dto.ClientDto;

import java.time.LocalDate;

public record Client(
        String name,
        String cpf,
        LocalDate birthdate,
        Address address
) {
    public record Address(
            String cep,
            String street,
            String neighborhood,
            String state
    ) {

    }
}
