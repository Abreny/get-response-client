package fr.hadeen.getresponse.services.campaign;

import fr.hadeen.getresponse.domain.Campaign;
import fr.hadeen.getresponse.domain.dto.CampaignRequest;

import fr.hadeen.getresponse.services.GetResponseClientInteface;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class CampaignServiceImpl implements CampaignService {
    private final GetResponseClientInteface responseClient;

    public CampaignServiceImpl(GetResponseClientInteface responseClient) {
        this.responseClient = responseClient;
    }

    @Override
    public Campaign createCampaign(CampaignRequest campaignRequest) throws URISyntaxException {
        return responseClient.post("/campaigns", campaignRequest, Campaign.class);
    }

    @Override
    public List<Campaign> getAllCampaigns() throws URISyntaxException {
        final Campaign[] campaigns =  responseClient.get("/campaigns", Campaign[].class);
        return Arrays.asList(campaigns);
    }

    @Override
    public Campaign updateCampaign(String campaignId, CampaignRequest campaignRequest) throws URISyntaxException {
        return responseClient.put("/campaigns/" + campaignId, campaignRequest, Campaign.class);
    }
}
