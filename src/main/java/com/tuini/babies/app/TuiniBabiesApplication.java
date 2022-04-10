package com.tuini.babies.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TuiniBabiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuiniBabiesApplication.class, args);
    }

}
