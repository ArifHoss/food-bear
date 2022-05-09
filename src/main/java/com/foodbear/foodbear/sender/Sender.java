package com.foodbear.foodbear.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    public static final String FOODBEAR_QUEUE = "foodbear-queue";

    private static JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        Sender.jmsTemplate = jmsTemplate;
    }

    public static void sendMessage(Long price){
        jmsTemplate.convertAndSend(FOODBEAR_QUEUE, price);
    }
}
