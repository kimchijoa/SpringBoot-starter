package com.kkh.spingboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpingBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootApplication.class, args);
    }

}
