package com.callsign.customer.support.monitor;

import com.callsign.customer.support.service.RuleServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This class is responsible to monitor delivery at a fixed interval and create the tickets.
 * @author Shadab Khan
 * @since 11/01/2022
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DeliveryScheduledAnalyzer {
    private final RuleServiceImpl ruleServiceImpl;

    @Scheduled(initialDelayString = "${delivery.monitor.initial.delay}", fixedDelayString = "${delivery.monitor.interval}" )
    public void monitor(){
        log.info("monitoring delivery started");
        ruleServiceImpl.analyze();
        log.info("monitoring delivery finished");
    }
}
