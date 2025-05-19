package com.vml.usmc.influencers.model;

import java.util.Date;

//use camel casing
//acronyms should be all caps
import lombok.Data;

@Data
public class PhoneNumber {
    private int countryCode;
    private String extenstion;
    private String number;
    private boolean isArchived;
    private boolean isPrimary;
    private Date archivedDate;
    private boolean optedOut;
    private Date optedOutDate;
    private boolean optedOutSMS;
    private Date optedOutSMSDate;
    private String type;
}
