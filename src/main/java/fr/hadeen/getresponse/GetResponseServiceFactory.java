package fr.hadeen.getresponse;

import fr.hadeen.getresponse.config.GetResponseProperties;
import fr.hadeen.getresponse.services.GetResponseClient;
import fr.hadeen.getresponse.services.GetResponseClientInteface;
import fr.hadeen.getresponse.services.campaign.CampaignService;
import fr.hadeen.getresponse.services.campaign.CampaignServiceImpl;
import fr.hadeen.getresponse.services.contact.ContactService;
import fr.hadeen.getresponse.services.contact.ContactServiceImpl;
import fr.hadeen.getresponse.services.contact.TransferContactService;
import fr.hadeen.getresponse.services.contact.TransferContactServiceImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetResponseServiceFactory implements GetResponseServiceFactoryInterface {
    private final GetResponseClientInteface responseClient;

    public GetResponseServiceFactory(RestTemplate restTemplate, UriComponentsBuilder builder, String key) {
        this.responseClient = new GetResponseClient(GetResponseProperties.forKey(key), restTemplate, builder);
    }

    public GetResponseServiceFactory(GetResponseClientInteface responseClient) {
        this.responseClient = responseClient;
    }

    @Override
    public GetResponseClientInteface getClient() {
        return responseClient;
    }

    @Override
    public CampaignService getCampaignService() {
        return new CampaignServiceImpl(responseClient);
    }

    @Override
    public ContactService getContactService() {
        return new ContactServiceImpl(responseClient);
    }

    @Override
    public TransferContactService getTransferContactService() {
        return new TransferContactServiceImpl(this);
    }
}
