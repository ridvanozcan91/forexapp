package com.example.forexapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ForexappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForexappApplication.class, args);
    }

}
