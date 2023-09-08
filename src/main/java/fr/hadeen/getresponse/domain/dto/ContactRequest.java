package fr.hadeen.getresponse.domain.dto;

import fr.hadeen.getresponse.domain.dto.ids.CampaignId;
import fr.hadeen.getresponse.domain.dto.ids.NewContactTagId;

import java.util.ArrayList;
import java.util.List;

public class ContactRequest {
    private String name;
    private CampaignId campaign;
    private String email;

    private List<CustomFieldWithValue> customFieldValues = new ArrayList<>();

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

    public List<CustomFieldWithValue> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldValues(List<CustomFieldWithValue> customFieldValues) {
        this.customFieldValues = customFieldValues;
    }
}
