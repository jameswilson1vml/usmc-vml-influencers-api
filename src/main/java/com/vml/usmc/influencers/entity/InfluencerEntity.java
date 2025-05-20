package com.vml.usmc.influencers.entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aitsInfluencer")
@Data
public class InfluencerEntity {

    @Id
    private UUID id;
    private String hash;
    @Column(name = "fk_personId")
    private UUID fkPersonId;
    private String occupation;
    private String type;
    private String Interests;
    private String InterestsOtherValue;
    private String referalSource;
    private String relationToUsmc;
    private String relationToUsmcOther;
    private String collegeAttended;
    private String organizationAffilillations;
    private String mostRecentAssignedBilletGroup;
    private String mostRecentAssignmentMethod;
    private String mostRecentAssignmentComments;
    private String mostRecentSource;
    private String mostRecentStatus;
    private Date mostRecenetStatusDateGmt;
    private Date profileCompleteDateGmt;
    private Date firstEmailDateGmt;
    private Date firstDayEmailDateGmt;
    private Date fiveDayEmailDateGmt;
    private Date tenDayEmailDateGmt;
    private int reassignmentCount;
    private Date pendingArchiveEmailDateGmt;
    private String fk_educationId;
    private Date mostRecentAssignmentDateGmt;
    private String homeTownCity;
    private String homeTownState;
    private boolean doNotContract;
    private String aitsBaselineId;
    private String FK_LOC_UNIT_ID;
    private String RANK;
    private String createdBy;
    private Date createdDateGMT;
    private String updatedBy;
    private Date updatedDateGMT;
}
