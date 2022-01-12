package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.model.ticket.Ticket;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
public interface Rule {
    boolean condition(Delivery delivery);
    void action(Delivery delivery);
}
