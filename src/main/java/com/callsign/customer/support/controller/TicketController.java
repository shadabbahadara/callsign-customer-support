package com.callsign.customer.support.controller;

import com.callsign.customer.support.model.Ticket;
import com.callsign.customer.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> findAllTickets() {
        return ResponseEntity.ok().body(ticketService.findAllTickets());
    }
}
