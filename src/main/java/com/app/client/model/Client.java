package com.app.client.model;

import com.app.client.apiclient.dto.AddressViaCep;
import com.app.client.utils.ValidationCustom;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;


public record Client(
        @NotBlank(message = "name is mandatory")
        String name,
        @CPF(message = "cpf invalid.")
        String cpf,
        LocalDate birthdate,
        Address address
) {
    @Builder(toBuilder = true)
    public Client(String name, String cpf, LocalDate birthdate, Address address) {
        this.name = name;
        this.cpf = formatCpf(cpf);
        this.birthdate = birthdate;
        this.address = address;
        ValidationCustom.validator(this);
    }

    private static String formatCpf(String cpf) {
        return cpf.replaceAll("[-.]", "");
    }


    public Client updateAddressFrom(AddressViaCep addressViaCep) {
        return this.toBuilder()
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
