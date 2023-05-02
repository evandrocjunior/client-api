package com.app.client.model;

import com.app.client.utils.ValidationCustom;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record Client(
        @NotBlank(message = "name is mandatory")
        String name,
        @CPF(message = "cpf invalid.")
        String cpf,
        LocalDate birthdate,
        Address address
) {
    public Client(String name, String cpf, LocalDate birthdate, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.address = address;
        ValidationCustom.validator(this);
    }
}
