package fr.hadeen.getresponse;

import fr.hadeen.getresponse.services.GetResponseClientInteface;
import fr.hadeen.getresponse.services.campaign.CampaignService;
import fr.hadeen.getresponse.services.contact.ContactService;

public interface GetResponseServiceFactoryInterface {
    public GetResponseClientInteface getClient();

    public  CampaignService getCampaignService();

    public ContactService getContactService();
}
