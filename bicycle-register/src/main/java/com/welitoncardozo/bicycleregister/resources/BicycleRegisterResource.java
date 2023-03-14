package com.welitoncardozo.bicycleregister.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BicycleRegisterResource {
    @GetMapping
    public String hello() {
        return "Hello bicycle register!";
    }
}
