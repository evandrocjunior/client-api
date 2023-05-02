package com.app.client.model;

import com.app.client.utils.ValidationCustom;
import jakarta.validation.constraints.Pattern;

public record Address(
        String street,
        String neighborhood,
        String state,
        Integer houseNumber,
        String complement,
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "cep invalid, must be format xxxxx-xxx")
        String cep
) {
    public Address(String street, String neighborhood, String state, Integer houseNumber, String complement,
    String cep) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.cep = cep;
        ValidationCustom.validator(this);
    }
}
