package com.welitoncardozo.bicycleallocation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "bicycle-register", path = "bicycle-register-api")
public interface BicycleRegisterRestClient {
    @GetMapping
    String hello();
}
