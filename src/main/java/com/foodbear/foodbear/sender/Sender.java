package com.foodbear.foodbear.sender;

import com.foodbear.foodbear.entities.FoodOrder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    public static final String FOODBEAR_QUEUE = "foodbear-queue";
    public static String message = "New order placed";

    private static JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        Sender.jmsTemplate = jmsTemplate;
    }

    public static void sendMessage(FoodOrder foodBearOrder){
        jmsTemplate.convertAndSend(FOODBEAR_QUEUE, foodBearOrder);
    }
}
