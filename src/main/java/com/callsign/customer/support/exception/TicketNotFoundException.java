package com.callsign.customer.support.exception;

/**
 * @author Shadab Khan
 * @since 16/01/2022
 */
public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
