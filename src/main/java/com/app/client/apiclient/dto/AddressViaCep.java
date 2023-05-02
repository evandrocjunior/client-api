package com.app.client.apiclient.dto;

import java.util.Objects;

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
    public AddressViaCep(String cep, String logradouro, String complemento, String bairro, String uf, Integer ibge, Integer gia, Integer ddd, Integer siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
