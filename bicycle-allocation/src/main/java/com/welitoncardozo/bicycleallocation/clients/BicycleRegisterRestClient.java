package com.welitoncardozo.bicycleallocation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "bicycle-register", path = "bicycle-register-api")
public interface BicycleRegisterRestClient {
    @PutMapping("/rent/{id}")
    void rent(@PathVariable final Long id);

    @PutMapping("/give-it-back/{id}")
    void giveItBack(@PathVariable final Long id);
}
