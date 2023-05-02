package com.app.client.apiclient;

import com.app.client.apiclient.dto.AddressViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "${url.viacep.host}")
public interface ViaCepApiClient {

    @GetMapping(path = "/{cep}/json/")
    AddressViaCep getAddress(@PathVariable(value = "cep") String cep);
}
