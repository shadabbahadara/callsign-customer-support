package com.callsign.customer.support;

import com.callsign.customer.support.model.CustomerType;
import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.model.DeliveryStatus;
import com.callsign.customer.support.repository.DeliveryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CallsignCustomerSupportApplication {
    public static void main(String[] args) {
        SpringApplication.run(CallsignCustomerSupportApplication.class, args);
/*        ConfigurableApplicationContext context = SpringApplication.run(CallsignCustomerSupportApplication.class, args);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        try {
            jmsTemplate.convertAndSend("QUEUE.CALLSIGN.DELIVERY", new ObjectMapper().writeValueAsString(new Delivery()));
            jmsTemplate.convertAndSend("QUEUE.CALLSIGN.DELIVERY", new ObjectMapper().writeValueAsString(new Delivery()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }

    @Bean
    CommandLineRunner run(DeliveryRepository deliveryRepository) {
        return args -> {
            deliveryRepository.save(Delivery.builder()
                    .customerType(CustomerType.VIP)
                    .deliveryStatus(DeliveryStatus.ORDER_RECEIVED)
                    .expectedDeliveryTime(Timestamp.valueOf(LocalDateTime.now().plusMinutes(80)))
                    .distanceFromDestination(100)
                    .riderRating(5)
                    .timeToPrepareFood(30*60*1000)
                    .timeToReachDestination(30*60*1000)
                    .build());
            deliveryRepository.save(Delivery.builder()
                    .customerType(CustomerType.NEW)
                    .deliveryStatus(DeliveryStatus.ORDER_RECEIVED)
                    .expectedDeliveryTime(Timestamp.valueOf(LocalDateTime.now().plusMinutes(50)))
                    .distanceFromDestination(100)
                    .riderRating(5)
                    .timeToPrepareFood(30*60*1000)
                    .timeToReachDestination(30*60*1000)
                    .build());
            deliveryRepository.save(Delivery.builder()
                    .customerType(CustomerType.LOYAL)
                    .deliveryStatus(DeliveryStatus.ORDER_PICKEDUP)
                    .expectedDeliveryTime(Timestamp.valueOf(LocalDateTime.now().minusMinutes(50)))
                    .distanceFromDestination(100)
                    .riderRating(5)
                    .timeToPrepareFood(30*60*1000)
                    .timeToReachDestination(30*60*1000)
                    .build());
        };
    }

}
