package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.repository.DeliveryRepository;
import com.callsign.customer.support.rule.ExpectedDeliveryTimeRule;
import com.callsign.customer.support.rule.ExpiredDeliveryTimeRule;
import com.callsign.customer.support.rule.VipCustomerRule;
import com.callsign.customer.support.rule.Rule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RuleServiceImpl implements RuleService {
    private final VipCustomerRule loyalCustomerRule;
    private final ExpectedDeliveryTimeRule expectedDeliveryTimeRule;
    private final ExpiredDeliveryTimeRule expiredDeliveryTimeRule;

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public void analyze() {
        List<Delivery> deliveries = deliveryRepository.findByMonitored(false);
        deliveries.forEach(delivery -> {
            analyze(delivery);
        });
        log.info("deliveries analyzed ");
    }

    @Override
    @Transactional
    public void analyze(Delivery delivery) {
        List<Rule> rules = Arrays.asList(loyalCustomerRule, expectedDeliveryTimeRule, expiredDeliveryTimeRule);
        rules.stream()
                .filter(rule -> rule.condition(delivery))
                .forEach(rule -> rule.action(delivery));
    }
}
