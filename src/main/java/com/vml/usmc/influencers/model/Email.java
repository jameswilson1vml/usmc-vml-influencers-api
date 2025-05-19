package com.vml.usmc.influencers.model;

import java.util.Date;

import lombok.Data;

//use camel casing
//acronyms should be all caps
@Data
public class Email {
    private String address;
    private boolean isArchived;
    private Date archivedDate;
    private boolean isPrimary;
    private boolean optedOut;
    private Date optedOutDate;
    private String type;
}
