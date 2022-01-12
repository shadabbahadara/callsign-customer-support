package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.delivery.CustomerType;
import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.model.ticket.Ticket;
import com.callsign.customer.support.model.ticket.TicketPriority;
import com.callsign.customer.support.model.ticket.TicketStatus;
import com.callsign.customer.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
public class LoyalCustomerRule implements Rule{
    private final TicketRepository ticketRepository;
    @Override
    public boolean condition(Delivery delivery) {
        return CustomerType.LOYAL.equals(delivery.getCustomerType());
    }

    @Override
    public void action(Delivery delivery) {
        Ticket ticket = Ticket.builder()
                .priority(TicketPriority.HIGH)
                .status(TicketStatus.OPEN)
                .delivery(delivery)
                .build();
        ticketRepository.save(ticket);
    }
}
