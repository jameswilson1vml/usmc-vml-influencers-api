package com.vml.usmc.influencers.model;

import java.util.Date;

import lombok.Data;

//use camel casing
//acronyms should be all caps
@Data
public class PriorService {
    private Date endOfContractDate;
    private String MOS;
    private MCRCRank rank;
}
