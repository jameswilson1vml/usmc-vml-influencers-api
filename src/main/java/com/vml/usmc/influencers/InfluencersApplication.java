package com.vml.usmc.influencers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InfluencersApplication {
    public static void main(String[] args) {
        SpringApplication.run(InfluencersApplication.class, args);
    }
}
