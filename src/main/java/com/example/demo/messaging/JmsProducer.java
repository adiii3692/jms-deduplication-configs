package com.example.demo.messaging;

import com.example.demo.messaging.model.MessageModel;
import jakarta.jms.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer{
    private final JmsTemplate jmsTemplate;
    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, MessageModel modelMessage){
        jmsTemplate.convertAndSend(destination, modelMessage, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setStringProperty(org.apache.activemq.artemis.api.core.Message.HDR_DUPLICATE_DETECTION_ID.toString(), modelMessage.getId().toString());
                return message;
            }
        });
    }
}
