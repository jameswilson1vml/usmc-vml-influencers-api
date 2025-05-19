package com.vml.usmc.influencers.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "aitsPerson")
@Data
public class PersonEntity {
    @Id
    private UUID id;
    private String mcrissEthnicCategory;
    private String mcrissSex;
    private boolean sexIsInferred;
    private String mcrissRace;
    private String mcrisRaceOtherDetail;
    private int age;
    private int yearOfBirth;
    private int monthOfBirth;
    private String namePrefix;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nameSuffix;
    private String mostRecentFulfillmentItem;
    private String mostRecentAssignmentCommentsmcrissId;
    private String mcrissAcceptance;
    private String environmentOfRecord;
    private String fk_locMcrcSchoolId;
    private String createdBy;
    private Date createdDateGMT;
    private String updatedBy;
    private Date updatedDateGMT;
}
