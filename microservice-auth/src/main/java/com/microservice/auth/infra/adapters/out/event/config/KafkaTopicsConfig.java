package com.microservice.auth.infra.adapters.out.event.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.topic")
@Getter
@Setter
public class KafkaTopicsConfig {

    private String userCreated = "user-created-topic";
    private String userUpdate = "user-update-topic";
    private String userDelete = "user-delete-topic";

}
