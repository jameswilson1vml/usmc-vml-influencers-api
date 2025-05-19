package com.vml.usmc.influencers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.vml.usmc.influencers.model.Influencer;

@SpringBootTest
public class InfluencerServiceTest {
    
    @InjectMocks
    private InfluencerService service;

    @Test
    void createSampleInfluencer_ShouldReturnSampleInfluencer() throws Exception {
        Influencer influencer = service.createSampleInfluencer();

        assertNotNull(influencer);
        assertEquals(influencer.getFirstName(), "John");
        assertEquals(influencer.getLastName(), "Doe");
    }
}
