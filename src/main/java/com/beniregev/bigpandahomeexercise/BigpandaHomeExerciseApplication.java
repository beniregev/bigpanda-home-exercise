package com.beniregev.bigpandahomeexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.beniregev.bigpandahomeexercise"})
public class BigpandaHomeExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigpandaHomeExerciseApplication.class, args);
    }

}
