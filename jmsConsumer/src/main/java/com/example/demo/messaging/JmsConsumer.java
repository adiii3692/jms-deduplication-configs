package com.example.demo.messaging;

import com.example.demo.messaging.model.MessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "test-queue")
    public void receiveMessage(String messageJson){
        try{
            MessageModel receivedMessage = new ObjectMapper().readValue(messageJson, MessageModel.class);
            logger.info("Received Message from queue: {}",receivedMessage .toString());
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
