package com.welitoncardozo.bicycleallocation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client-register", path = "client-register-api")
public interface ClientRegisterRestClient {
    @GetMapping
    String hello();
}
