package com.callsign.customer.support.repository;

import com.callsign.customer.support.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
