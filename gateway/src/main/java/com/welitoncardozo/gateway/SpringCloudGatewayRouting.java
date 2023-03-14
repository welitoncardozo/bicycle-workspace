package com.welitoncardozo.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "bicycle-register",
                        it -> it.path("/bicycle-register-api/**").uri("lb://bicycle-register")
                )
                .route(
                        "client-register",
                        it -> it.path("/client-register-api/**").uri("lb://client-register")
                )
                .route(
                        "bicycle-allocation",
                        it -> it.path("/bicycle-allocation-api/**").uri("lb://bicycle-allocation")
                )
                .build();
    }
}
