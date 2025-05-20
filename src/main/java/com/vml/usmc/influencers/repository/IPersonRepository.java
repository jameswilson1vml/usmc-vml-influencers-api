package com.vml.usmc.influencers.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vml.usmc.influencers.entity.PersonEntity;

@Repository
public interface IPersonRepository extends JpaRepository<PersonEntity, UUID> {
    //custom queries can go here
    //crud supported by id inherited
}
