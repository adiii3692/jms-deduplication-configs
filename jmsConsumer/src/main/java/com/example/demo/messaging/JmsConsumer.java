package com.example.demo.messaging;

import com.example.demo.messaging.model.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "duplicate-queue")
    public void receiveMessage(MessageModel message){
        logger.info("Received Message from queue: {}",message.toString());
    }
}
