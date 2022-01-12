package com.callsign.customer.support.monitor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This class is responsible to monitor delivery at a fixed interval and create the tickets.
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
public class DeliveryMonitor {

    @Scheduled(fixedDelayString = "${delivery.monitor.interval}" )
    public void monitor(){
        System.out.println("monitoring delivery started");
        // TODO: 1/11/22 create tickets after analysing the delivery record.
//        fetch data from delivery repository and analyse them
        System.out.println("monitoring delivery finished");
    }
}
