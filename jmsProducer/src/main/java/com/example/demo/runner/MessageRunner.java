package com.example.demo.runner;

import com.example.demo.messaging.JmsProducer;
import com.example.demo.messaging.model.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

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

        // Send 3 unique messages
        MessageModel messageOne = new MessageModel(null,"credit_transfer");
        MessageModel messageTwo = new MessageModel(null,"payment_recovery");
        MessageModel messageThree = new MessageModel(null,"payment_status_enquiry");

        jmsProducer.sendMessage("test-queue",messageOne);
        logger.info("Message #"+1+" sent to queue");

        jmsProducer.sendMessage("test-queue",messageTwo);
        logger.info("Message #"+2+" sent to queue");

        jmsProducer.sendMessage("test-queue",messageThree);
        logger.info("Message #"+3+" sent to queue");

        // Try sending a duplicate -- Should fail
        jmsProducer.sendMessage("test-queue",messageOne);
        logger.info("Duplicate message sent to queue");

        // Now send another unique one to overwrite the first one
        MessageModel messageFour = new MessageModel(null,"credit_transfer");
        jmsProducer.sendMessage("test-queue",messageFour);
        logger.info("Message #"+4+" sent to queue");

        // Now try sending a duplicate -- Should accept and overwrite #2
        jmsProducer.sendMessage("test-queue",messageOne);
        logger.info("Duplicate of message #1 sent to queue");
    }
}
