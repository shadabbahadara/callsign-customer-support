package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Delivery;

/**
 * @author Shadab Khan
 * @since 15/01/2022
 */
public interface RuleService {
    void analyze();

    void analyze(Delivery delivery);
}
