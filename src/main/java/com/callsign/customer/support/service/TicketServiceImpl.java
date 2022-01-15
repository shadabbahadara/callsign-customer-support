package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Ticket;
import com.callsign.customer.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAllTickets() {
        log.info("finding all tickets...");
        return ticketRepository.findAll();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
