package com.callsign.customer.support;

import com.callsign.customer.support.model.delivery.CustomerType;
import com.callsign.customer.support.model.delivery.Delivery;
import com.callsign.customer.support.model.delivery.DeliveryStatus;
import com.callsign.customer.support.repository.delivery.DeliveryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Time;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CallsignCustomerSupportApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CallsignCustomerSupportApplication.class, args);
//        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//        try {
//            jmsTemplate.convertAndSend("QUEUE.CALLSIGN.DELIVERY", new ObjectMapper().writeValueAsString(new Delivery()));
//            jmsTemplate.convertAndSend("QUEUE.CALLSIGN.DELIVERY", new ObjectMapper().writeValueAsString(new Delivery()));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }

    @Bean
    CommandLineRunner run(DeliveryRepository deliveryRepository) {
        return args -> {
            deliveryRepository.save(Delivery.builder()
                    .customerType(CustomerType.LOYAL)
                    .deliveryStatus(DeliveryStatus.ORDER_RECEIVED)
                    .expectedDeliveryTime(Timestamp.valueOf(LocalDateTime.now()))
                            .distanceFromDestination(100)
                            .riderRating(5)
                            .timeToPrepareFood(30*60*1000)
                            .timeToReachDestination(Timestamp.valueOf(LocalDateTime.now().plusMinutes(30)))
                    .build());
        };
    }

}
