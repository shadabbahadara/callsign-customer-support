package com.callsign.customer.support.monitor;

import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.rule.ExpectedDeliveryTimeRule;
import com.callsign.customer.support.rule.ExpiredDeliveryTimeRule;
import com.callsign.customer.support.rule.LoyalCustomerRule;
import com.callsign.customer.support.rule.Rule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryAnalyzer {
    private final RuleService ruleService;
//    @JmsListener(destination = "${callsign.delivery.queue}")
    public void consumeMessage(String message) {
        log.info("Message received from activemq queue---"+message);
        try {
            Delivery delivery = new ObjectMapper().readValue(message, Delivery.class);
            log.info("parsed json {}",delivery.toString());
            ruleService.analyze(delivery);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}