package com.app.client.controller.request;


import java.time.LocalDate;

public record ClientRequest(
        String name,
        String cpf,
        LocalDate birthdate,
        AddressDto address
) {

    public record AddressDto(Integer houseNumber, String complement, String cep) {
    }
}
