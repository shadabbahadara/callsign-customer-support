package com.callsign.customer.support.repository;

import com.callsign.customer.support.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByMonitored(@Param("monitored") boolean isMonitored);
}
