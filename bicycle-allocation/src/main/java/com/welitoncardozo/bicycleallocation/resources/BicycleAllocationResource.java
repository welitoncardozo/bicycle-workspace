package com.welitoncardozo.bicycleallocation.resources;

import com.welitoncardozo.bicycleallocation.clients.BicycleRegisterRestClient;
import com.welitoncardozo.bicycleallocation.clients.ClientRegisterRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class BicycleAllocationResource {
    private final BicycleRegisterRestClient bicycleRegisterRestClient;
    private final ClientRegisterRestClient clientRegisterRestClient;

    @GetMapping
    public String hello() {
        final String bicycleRegister = bicycleRegisterRestClient.hello();
        final String clientRegister = clientRegisterRestClient.hello();
        return "Hello bicycle allocation! " + bicycleRegister + " " + clientRegister;
    }
}
