package com.app.client.presentation.dto;


import java.time.LocalDate;

public record ClientDto(
        String name,
        String cpf,
        LocalDate birthdate,
        AddressDto address
) {

    public record AddressDto(Integer houseNumber, String complement, String cep) {
    }
}
