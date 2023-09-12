package fr.hadeen.getresponse.domain.dto;

public class CampaignOptinTypes {
    private String api;

    public CampaignOptinTypes(String api) {
        if (api == null){api = "single";}
        this.api = api;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
