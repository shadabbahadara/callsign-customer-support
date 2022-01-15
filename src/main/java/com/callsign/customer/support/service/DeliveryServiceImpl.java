package com.callsign.customer.support.service;

import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> findByMonitored(boolean isMonitored) {
        return deliveryRepository.findByMonitored(isMonitored);
    }
}
