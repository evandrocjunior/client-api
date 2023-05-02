package com.app.client.controller.request;

import java.time.LocalDate;

public record ClientRequest(
        String name,
        String cpf,
        LocalDate birthdate,
        AddressRequest address
) {

    public record AddressRequest(Integer houseNumber, String complement, String cep) {
    }
}
