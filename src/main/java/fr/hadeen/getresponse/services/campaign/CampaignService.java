package fr.hadeen.getresponse.services.campaign;

import fr.hadeen.getresponse.domain.Campaign;
import fr.hadeen.getresponse.domain.dto.CampaignRequest;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

public interface CampaignService {
    public Campaign createCampaign(CampaignRequest campaignRequest) throws URISyntaxException;
    public Campaign updateCampaign(String campaignId, CampaignRequest campaignRequest) throws URISyntaxException;
    public List<Campaign> getAllCampaigns() throws URISyntaxException;
}
