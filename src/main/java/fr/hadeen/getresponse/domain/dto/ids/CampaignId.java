package fr.hadeen.getresponse.domain.dto.ids;

import java.util.Objects;

public class CampaignId {
    private String campaignId;

    public String getCampaignId() {
        return campaignId;
    }

    public CampaignId setCampaignId(String campaignId) {
        this.campaignId = campaignId;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignId)) return false;
        CampaignId that = (CampaignId) o;
        return Objects.equals(campaignId, that.campaignId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignId);
    }
}
