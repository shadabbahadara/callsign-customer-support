package com.callsign.customer.support.monitor;

import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.rule.ExpectedDeliveryTimeRule;
import com.callsign.customer.support.rule.ExpiredDeliveryTimeRule;
import com.callsign.customer.support.rule.LoyalCustomerRule;
import com.callsign.customer.support.rule.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Service
@RequiredArgsConstructor
public class RuleService {
    private final LoyalCustomerRule loyalCustomerRule;
    private final ExpectedDeliveryTimeRule expectedDeliveryTimeRule;
    private final ExpiredDeliveryTimeRule expiredDeliveryTimeRule;

    public void analyze(Delivery delivery) {
        List<Rule> rules = Arrays.asList(loyalCustomerRule, expectedDeliveryTimeRule, expiredDeliveryTimeRule);
        rules.stream()
                .filter(rule -> rule.condition(delivery))
                .forEach(rule -> rule.action(delivery));
    }
}
