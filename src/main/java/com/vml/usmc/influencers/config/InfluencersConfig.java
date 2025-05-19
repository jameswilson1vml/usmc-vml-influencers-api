package com.vml.usmc.influencers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vml.usmc.influencers.service.InfluencerService;

@Configuration
public class InfluencersConfig {
    
    @Bean
    public InfluencerService setupInfluencerService() {
        return new InfluencerService();
    }

}
