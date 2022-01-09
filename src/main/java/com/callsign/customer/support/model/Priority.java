package com.callsign.customer.support.model;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public enum Priority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");
    private final String value;

    Priority(final String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
