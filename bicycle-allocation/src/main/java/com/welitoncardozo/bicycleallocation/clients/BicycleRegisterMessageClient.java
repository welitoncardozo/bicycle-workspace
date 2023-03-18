package com.welitoncardozo.bicycleallocation.clients;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BicycleRegisterMessageClient implements BicycleRegisterHandler {
    private final RabbitTemplate template;

    @Override
    public void rent(final Long id) {
        this.template.convertAndSend("bicycle_register_api_rent", id);
    }

    @Override
    public void giveItBack(final Long id) {
        this.template.convertAndSend("bicycle_register_api_give_it_back", id);
    }
}
