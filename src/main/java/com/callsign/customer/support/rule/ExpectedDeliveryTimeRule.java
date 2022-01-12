package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.model.ticket.Ticket;
import com.callsign.customer.support.model.ticket.TicketPriority;
import com.callsign.customer.support.model.ticket.TicketStatus;
import com.callsign.customer.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
public class ExpectedDeliveryTimeRule implements Rule{
    private final TicketRepository ticketRepository;

    @Override
    public boolean condition(Delivery delivery) {
        long expected = delivery.getExpectedDeliveryTime().getTime();
        long estimated = delivery.getTimeToReachDestination().getTime() + delivery.getTimeToPrepareFood();
        return estimated < expected;
    }

    @Override
    public void action(Delivery delivery) {
        Ticket ticket = Ticket.builder()
                .priority(TicketPriority.MEDIUM)
                .status(TicketStatus.OPEN)
                .delivery(delivery)
                .build();
        ticketRepository.save(ticket);
    }
}
