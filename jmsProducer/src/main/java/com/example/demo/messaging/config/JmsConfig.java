package com.example.demo.messaging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Configures the MessageConverter used by JmsTemplate (for sending messages)
 * and JmsListeners (for receiving messages).
 */
@Configuration
public class JmsConfig {
    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();

        // This is crucial: it tells the converter to create a JMS TextMessage
        // with the payload being the JSON string representation of your object.
        messageConverter.setTargetType(MessageType.TEXT);

        // Lets the consumer know what Object to map the received message to
        messageConverter.setTypeIdPropertyName("_type");

        return messageConverter;
    }
}
