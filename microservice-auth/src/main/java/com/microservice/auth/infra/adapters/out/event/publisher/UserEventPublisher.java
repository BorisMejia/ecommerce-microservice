package com.microservice.auth.infra.adapters.out.event.publisher;

import com.microservice.auth.domain.model.User;
import com.microservice.auth.infra.adapters.out.event.config.KafkaTopicsConfig;
import com.microservice.auth.infra.adapters.out.event.dto.UserCreatedEvent;
import com.microservice.auth.infra.adapters.out.event.dto.UserUpdateEvent;
import com.microservice.auth.infra.adapters.out.event.mapper.UserEventMapper;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserEventPublisher {

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
    private final UserEventMapper userEventMapper;
    private final KafkaTopicsConfig kafkaTopicsConfig;

    public void publishUserCreated(User user) {
        UserCreatedEvent event = userEventMapper.toUserCreatedEvent(user);
        kafkaTemplate.send(kafkaTopicsConfig.getUserCreated(), event);
    }
    public void publishUserUpdate(User user){
        UserUpdateEvent event = userEventMapper.toUserUpdateEvent(user);
    }
}
