package com.vml.usmc.influencers.model;

import java.util.Date;

import lombok.Data;

//use camel casing
//acronyms should be all caps
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String county;
    private String state;
    private String zipCode;
    private String type;
    private boolean isArchived;
    private String isPrimary;
    private boolean optedOut;
    private Date optedOutDate;
}
