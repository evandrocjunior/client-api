package com.app.client.model;

import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.utils.ValidationCustom;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
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
    @Builder
    public Client(String name, String cpf, LocalDate birthdate, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.address = address;
        ValidationCustom.validator(this);
    }


    public Client updateAddressFrom(AddressViaCep addressViaCep) {
        return Client.builder()
                .cpf(this.cpf)
                .name(this.name)
                .birthdate(this.birthdate)
                .address(Address.builder()
                        .cep(this.address.cep())
                        .state(addressViaCep.uf())
                        .street(addressViaCep.logradouro())
                        .houseNumber(this.address.houseNumber())
                        .complement(this.address.complement())
                        .neighborhood(addressViaCep.bairro())
                        .build())
                .build();
    }
}
