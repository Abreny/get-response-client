package fr.hadeen.getresponse.domain.dto;

public class CampaignRequest {
    private String name;

    public CampaignRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
