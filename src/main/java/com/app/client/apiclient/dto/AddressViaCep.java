package com.app.client.apiclient.dto;

import lombok.Builder;

public record AddressViaCep(
        String cep,
        String logradouro,
        String localidade,
        String complemento,
        String bairro,
        String uf,
        Integer ibge,
        Integer gia,
        Integer ddd,
        Integer siafi
) {
    @Builder(toBuilder = true)
    public AddressViaCep(String cep, String logradouro, String localidade, String complemento, String bairro, String uf, Integer ibge, Integer gia,
                         Integer ddd, Integer siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
