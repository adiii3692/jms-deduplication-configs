package com.example.demo.runner;

import com.example.demo.messaging.JmsProducer;
import com.example.demo.messaging.model.MessageModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageRunner implements CommandLineRunner {
    private final JmsProducer jmsProducer;

    public MessageRunner(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting MessageRunner");

        // Send duplicate messages
        for(int i=0;i<5;i++){
            String msgContent = "Message #"+i;
            MessageModel message = new MessageModel();
            message.setServiceName(msgContent);
            jmsProducer.sendMessage("json-queue",message);
        }
    }
}
