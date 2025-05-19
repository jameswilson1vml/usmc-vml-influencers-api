package com.vml.usmc.influencers.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Data;

//use camel casing
//acronyms should be all caps
@Schema(description = "Influencer contains (CUI)")
@Data
public class Influencer {
    private UUID id;
    @Positive
    @Schema(minimum = "1")
    private int age;
    private List<Address> addresses;
    private List<Email> emailAddresses;
    private List<PhoneNumber> phoneNumbers;
    private List<SocialMedia> socialMediaProfiles;
    private ContractMethodPreference contactMethodPreference;
    @Schema(description = "(CUI)")
    private String firstName;
    private String lastName;
    private String mostRecentAttributedVanityCode;
    private PriorService priorService;
    private String relationToUSMC;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Influencer myObject = (Influencer) obj;
        return id.equals(myObject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
