package fr.hadeen.getresponse.services.contact;

import fr.hadeen.getresponse.domain.dto.ContactRequest;

import java.net.URISyntaxException;

public interface TransferContactService {
    public void transferContact(String campaignId, ContactRequest contactRequest) throws URISyntaxException;
}
