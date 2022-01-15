package com.callsign.customer.support.model;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public enum CustomerType {
    VIP("VIP"),
    LOYAL("Loyal"),
    NEW("New");
    private final String value;

    CustomerType(final String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
