package com.example.marksmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:META-INF/beans.xml")
public class MarksManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarksManagementApplication.class, args);
    }
} 