package com.example.anticshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AnticShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnticShopApplication.class, args);
    }

}
