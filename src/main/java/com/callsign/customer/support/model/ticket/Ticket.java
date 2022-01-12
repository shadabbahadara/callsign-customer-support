package com.callsign.customer.support.model.ticket;

import com.callsign.customer.support.model.delivery.Delivery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TicketPriority priority;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    private String resolution;
    @ManyToOne
    private Delivery delivery;
}
