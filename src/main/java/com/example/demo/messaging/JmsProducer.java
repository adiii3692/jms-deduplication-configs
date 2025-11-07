package com.example.demo.messaging;

import com.example.demo.messaging.model.MessageModel;
import jakarta.jms.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer{
    private final JmsTemplate jmsTemplate;
    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, MessageModel message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
