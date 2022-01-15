package com.callsign.customer.support.monitor;

import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.service.RuleServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryQueueAnalyzer {
    private final RuleServiceImpl ruleServiceImpl;
//    @JmsListener(destination = "${callsign.delivery.queue}")
    public void consumeMessage(String message) {
        log.info("Message received from activemq queue---"+message);
        try {
            Delivery delivery = new ObjectMapper().readValue(message, Delivery.class);
            log.info("delivery under analysis {}",delivery.toString());
            ruleServiceImpl.analyze(delivery);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}