package com.vml.usmc.influencers.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vml.usmc.influencers.entity.InfluencerEntity;
import com.vml.usmc.influencers.entity.PersonEntity;
import com.vml.usmc.influencers.model.Influencer;
import com.vml.usmc.influencers.repository.IInfluencerRepository;
import com.vml.usmc.influencers.repository.IPersonRepository;

@Service
public class InfluencerService {

    @Autowired
    private IInfluencerRepository influencerRepo;

    @Autowired
    private IPersonRepository personRepo;

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

    public UUID addNewInfluencer(Influencer influencer) {
        InfluencerEntity influencerEntity = new InfluencerEntity();
        PersonEntity personEntity = new PersonEntity();
        UUID influencerId = UUID.randomUUID();
        UUID personId = UUID.randomUUID();

        personEntity.setId(personId);
        personEntity.setAge(influencer.getAge());
        personEntity.setFirstName(influencer.getFirstName());
        personEntity.setLastName(influencer.getLastName());

        influencerEntity.setId(influencerId);
        influencerEntity.setFkPersonId(personId);
        influencerEntity.setRelationToUsmc(influencer.getRelationToUSMC());
        

        personRepo.save(personEntity);
        influencerRepo.save(influencerEntity);

        // entity.setAge(influencer.getAge());
        // entity.setFirstName(influencer.getFirstName());
        // entity.setLastName(influencer.getLastName());
        // entity.setMostRecentAttributedVanityCode(influencer.getMostRecentAttributedVanityCode());
        // entity.setPriorService(influencer.getPriorService());

        // entity.setId(id);
        // entity.setF(influencer.get);
        // entity.setFkPromotionId(event.getPromotionId());
        // eventRepo.save(entity);

        // if(influencerRepo.findByEmail(influencer.getEmail()).isPresent()) {
        //     throw new IllegalArgumentException("Email already exists");
        // }

        return influencerId;
    }

    public void updateInfluencer(Influencer influencer) {
        InfluencerEntity influencerEntity = influencerRepo.findById(influencer.getId()).orElse(null);

        influencerEntity.setRelationToUsmc(influencer.getRelationToUSMC() != null ? influencer.getRelationToUSMC() : influencerEntity.getRelationToUsmc());

        influencerRepo.save(influencerEntity);
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