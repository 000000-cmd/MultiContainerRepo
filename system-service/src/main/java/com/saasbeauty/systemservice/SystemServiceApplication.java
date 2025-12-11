package com.saasbeauty.systemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.saasbeauty.systemservice",
        "com.saasbeauty.saasbeautycommon"
})
@EntityScan(basePackages = {
        "com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity",
        "com.saasbeauty.saasbeautycommon.persistence"
})
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class, args);
    }
}