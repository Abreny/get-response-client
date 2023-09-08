package fr.hadeen.getresponse.services.contact;

import fr.hadeen.getresponse.domain.Contact;
import fr.hadeen.getresponse.domain.dto.CampaignRequest;
import fr.hadeen.getresponse.domain.dto.ContactRequest;

import java.net.URISyntaxException;
import java.util.List;

public interface ContactService {
    public Contact createContact(ContactRequest contactRequest) throws URISyntaxException;
    public Contact updateContact(String contactId, ContactRequest contactRequest) throws URISyntaxException;
    public void deleteContactById(String contactId) throws URISyntaxException;
    public void unsubscribeFromMessage(String contactId, String messageId) throws URISyntaxException;
    public List<Contact> getAllContacts() throws URISyntaxException;
}
