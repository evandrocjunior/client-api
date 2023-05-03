package com.app.client.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mockAPI", url = "http://192.168.100.50:3000")
public interface MockApiTest {

    @GetMapping(path = "/posts")
    String test();
}
