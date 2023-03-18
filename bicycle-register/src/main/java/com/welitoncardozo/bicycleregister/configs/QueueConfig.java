package com.welitoncardozo.bicycleregister.configs;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class QueueConfig {
    private final AmqpAdmin amqpAdmin;

    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue("bicycle_register_api_rent", true));
        amqpAdmin.declareQueue(new Queue("bicycle_register_api_give_it_back", true));
    }
}
