package com.callsign.customer.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CallsignCustomerSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallsignCustomerSupportApplication.class, args);
    }

}
