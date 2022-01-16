package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Ticket;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public interface TicketService {
    List<Ticket> findAllTickets();

    Ticket findTicket(long id);

    Ticket createTicket(Ticket ticket);
}
