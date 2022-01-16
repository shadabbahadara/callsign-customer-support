package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.*;
import com.callsign.customer.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
public class VipCustomerRule implements Rule{
    private final TicketService ticketService;

    @Override
    public boolean condition(Delivery delivery) {
        return CustomerType.VIP.equals(delivery.getCustomerType());
    }

    @Override
    public void action(Delivery delivery) {
        Ticket ticket = Ticket.builder()
                .priority(TicketPriority.HIGH)
                .status(TicketStatus.OPEN)
                .description("Customer is VIP")
                .delivery(delivery)
                .build();
        ticketService.createTicket(ticket);
        delivery.setMonitored(true);
    }
}
