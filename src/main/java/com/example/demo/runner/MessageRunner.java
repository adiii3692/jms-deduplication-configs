package com.example.demo.runner;

import com.example.demo.messaging.JmsProducer;
import com.example.demo.messaging.model.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageRunner implements CommandLineRunner {
    private final JmsProducer jmsProducer;

    private static final Logger logger = LoggerFactory.getLogger(MessageRunner.class);

    public MessageRunner(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting MessageRunner");

        // Send duplicate messages
        for(int i=0;i<5;i++){
            MessageModel message = new MessageModel();
            message.setServiceName("testService");
            jmsProducer.sendMessage("unique-queue",message);
            logger.info("Message #"+i+" sent to queue");
        }
    }
}
