package com.vml.usmc.influencers.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class InfluencerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInfluencers_ShouldReturnInfluencersList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/influencers"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"))
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Doe"))
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(25));
    }

    // @Test
    // void getEvent_ShouldReturnEvent() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/events/018b2f19-e79e-7d6a-a56d-29feb6211b04"))
    //            .andExpect(MockMvcResultMatchers.status().isOk())
    //            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sample event"))
    //            .andExpect(MockMvcResultMatchers.jsonPath("$.includesBattlePositions").value(false))
    //            .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("NATIONAL_PARTNERSHIP"));
    // }
}