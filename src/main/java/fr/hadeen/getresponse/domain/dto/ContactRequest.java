package fr.hadeen.getresponse.domain.dto;

import fr.hadeen.getresponse.domain.dto.ids.CampaignId;
import fr.hadeen.getresponse.domain.dto.ids.NewContactTagId;

import java.util.ArrayList;
import java.util.List;

public class ContactRequest {
    private String name;
    private CampaignId campaign;
    private String email;

    private String dayOfCycle;

    private Double scoring;

    private String ipAddress;

    private List<NewContactTagId> tags = new ArrayList<>();

    private List<CustomFieldWithValue> customFieldValues = new ArrayList<>();

    public ContactRequest() {

    }

    public ContactRequest(String email, CampaignId campaign) {
        this.email = email;
        this.campaign = campaign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CampaignId getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignId campaign) {
        this.campaign = campaign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDayOfCycle() {
        return dayOfCycle;
    }

    public void setDayOfCycle(String dayOfCycle) {
        this.dayOfCycle = dayOfCycle;
    }

    public Double getScoring() {
        return scoring;
    }

    public void setScoring(Double scoring) {
        this.scoring = scoring;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<NewContactTagId> getTags() {
        return tags;
    }

    public void setTags(List<NewContactTagId> tags) {
        this.tags = tags;
    }

    public List<CustomFieldWithValue> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldValues(List<CustomFieldWithValue> customFieldValues) {
        this.customFieldValues = customFieldValues;
    }
}
