package com.app.client.controller.request;

import java.time.LocalDate;
import lombok.Builder;

public record ClientRequest(
        String name,
        String cpf,
        LocalDate birthdate,
        AddressRequest address
) {

    @Builder
    public ClientRequest {
    }

    public record AddressRequest(Integer houseNumber, String complement, String cep) {
        @Builder
        public AddressRequest {
        }
    }
}
