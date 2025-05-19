package com.vml.usmc.influencers.model;

import java.util.Date;

import lombok.Data;

//use camel casing
//acronyms should be all caps
@Data
public class SocialMedia {
    private String value;
    private boolean isArchived;
    private Date archivedDate;
}
