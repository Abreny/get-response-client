package fr.hadeen.getresponse.domain.dto;

public class CampaignRequest {
    private String name;
    private CampaignOptinTypes optinTypes;

    public CampaignRequest(String name, String optinType) {
        this.name = name;
        this.optinTypes = new CampaignOptinTypes(optinType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CampaignOptinTypes getOptinTypes() {
        return optinTypes;
    }

    public void setOptinTypes(CampaignOptinTypes optinTypes) {
        this.optinTypes = optinTypes;
    }
}
