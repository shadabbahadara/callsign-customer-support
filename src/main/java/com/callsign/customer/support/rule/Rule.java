package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.Delivery;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
public interface Rule {
    boolean condition(Delivery delivery);
    void action(Delivery delivery);
}
