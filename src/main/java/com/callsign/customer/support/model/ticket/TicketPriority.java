package com.callsign.customer.support.model.ticket;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public enum TicketPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");
    private final String value;

    TicketPriority(final String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
