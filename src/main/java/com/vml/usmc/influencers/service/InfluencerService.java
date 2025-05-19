package com.vml.usmc.influencers.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vml.usmc.influencers.entity.InfluencerEntity;
import com.vml.usmc.influencers.model.Influencer;
import com.vml.usmc.influencers.repository.IInfluencerRepository;

@Service
public class InfluencerService {

    @Autowired
    private IInfluencerRepository influencerRepo;

    public Set<Influencer> getAllInfluencers() {
        Set<Influencer> influencers = new HashSet<>();

        influencerRepo.findAll().forEach(influencerEntity -> {
            Influencer influencer = new Influencer();
            influencer.setId(influencerEntity.getId());
            influencer.setRelationToUSMC(influencerEntity.getRelationToUsmc());
            influencers.add(influencer);
        });

        if(influencers.size() < 1) {
            influencers.add(createSampleInfluencer());
        }

        return influencers;
    }

    public Influencer getInfluencerById(UUID id) {
        InfluencerEntity entity;
        Influencer influencer;
        
        if(id == null) {
            influencer = createSampleInfluencer();
        } else {
            entity = influencerRepo.findById(id).orElse(null);
            if(entity != null) {
                influencer = new Influencer();
                influencer.setId(entity.getId());
                influencer.setRelationToUSMC(entity.getRelationToUsmc());
            } else {
                influencer = createSampleInfluencer();
            }
        }
        
        return influencer;
    }

    public Influencer createSampleInfluencer() {
        Influencer influencer = new Influencer();
        influencer.setId(UUID.randomUUID());
        influencer.setAge(25);
        influencer.setFirstName("John");
        influencer.setLastName("Doe");
        influencer.setMostRecentAttributedVanityCode("123456");
        influencer.setRelationToUSMC("Friend");
        return influencer;
    }
}