package com.welitoncardozo.bicycleregister.resources;

import com.welitoncardozo.bicycleregister.service.BicycleService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BicycleRegisterListener {
    private final BicycleService service;

    @RabbitListener(queues = "bicycle_register_api_rent")
    @RabbitHandler
    public void rent(final Long id) {
        System.out.println("Rentttttttt");
        service.rent(id, true);
    }

    @RabbitListener(queues = "bicycle_register_api_give_it_back")
    @RabbitHandler
    public void giveItBack(final Long id) {
        System.out.println("giveItBackkkkkkkkkkk");
        service.rent(id, false);
    }
}
