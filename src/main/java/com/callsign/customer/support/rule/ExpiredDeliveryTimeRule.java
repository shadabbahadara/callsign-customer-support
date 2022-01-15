package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.model.DeliveryStatus;
import com.callsign.customer.support.model.Ticket;
import com.callsign.customer.support.model.TicketPriority;
import com.callsign.customer.support.model.TicketStatus;
import com.callsign.customer.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
public class ExpiredDeliveryTimeRule implements Rule {
    private final TicketService ticketService;

    @Override
    public boolean condition(Delivery delivery) {
        if(DeliveryStatus.ORDER_DELIVERED != delivery.getDeliveryStatus()){
            return delivery.getExpectedDeliveryTime().before(new Timestamp(currentTimeMillis()));
        }
        return false;
    }

    @Override
    public void action(Delivery delivery) {
        Ticket ticket = Ticket.builder()
                .priority(TicketPriority.HIGH)
                .status(TicketStatus.OPEN)
                .description("delivery time has expired")
                .delivery(delivery)
                .build();
        ticketService.createTicket(ticket);
        delivery.setMonitored(true);
    }
}
