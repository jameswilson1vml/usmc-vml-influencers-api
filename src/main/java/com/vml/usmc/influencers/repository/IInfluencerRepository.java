package com.vml.usmc.influencers.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vml.usmc.influencers.entity.InfluencerEntity;

@Repository
public interface IInfluencerRepository extends JpaRepository<InfluencerEntity, UUID> {
    //custom queries can go here
    //crud supported by id inherited

    List<InfluencerEntity> findByFkPersonId(String fkPersonId);
}
