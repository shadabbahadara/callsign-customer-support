package com.callsign.customer.support.model.delivery;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public enum DeliveryStatus {
    ORDER_RECEIVED("Order Received"),
    ORDER_PREPARING("Order Preparing"),
    ORDER_PICKEDUP("Order Pickedup"),
    ORDER_DELIVERED("Order Delivered");
    private final String value;

    DeliveryStatus(final String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
