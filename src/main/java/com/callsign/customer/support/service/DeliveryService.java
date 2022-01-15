package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Delivery;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 15/01/2022
 */
public interface DeliveryService {
    List<Delivery> findByMonitored(@Param("monitored") boolean isMonitored);

}
