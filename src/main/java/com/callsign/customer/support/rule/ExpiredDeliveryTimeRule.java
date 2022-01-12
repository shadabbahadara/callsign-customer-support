package com.callsign.customer.support.rule;

import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.model.delivery.DeliveryStatus;
import com.callsign.customer.support.model.ticket.Ticket;
import com.callsign.customer.support.model.ticket.TicketPriority;
import com.callsign.customer.support.model.ticket.TicketStatus;
import com.callsign.customer.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;

import static java.lang.System.*;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
public class ExpiredDeliveryTimeRule implements Rule{
    private final TicketRepository ticketRepository;

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
                .delivery(delivery)
                .build();
        ticketRepository.save(ticket);
    }
}
