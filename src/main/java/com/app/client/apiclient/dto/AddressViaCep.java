package com.app.client.apiclient.dto;

public record AddressViaCep(
        String cep,
          String logradouro,
          String complemento,
          String bairro,
          String uf,
          Integer ibge,
          Integer gia,
          Integer ddd,
          Integer siafi
) {
}
