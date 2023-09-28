package fr.hadeen.getresponse.services.contact;

import fr.hadeen.getresponse.domain.Contact;

import fr.hadeen.getresponse.domain.dto.ContactRequest;
import fr.hadeen.getresponse.domain.dto.SearchRequest;
import fr.hadeen.getresponse.services.GetResponseClientInteface;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;


public class ContactServiceImpl implements ContactService {
    private final GetResponseClientInteface responseClient;

    public ContactServiceImpl(GetResponseClientInteface responseClient) {
        this.responseClient = responseClient;
    }

    @Override
    public void createContact(ContactRequest contactRequest) throws URISyntaxException {
        responseClient.post("/contacts", contactRequest, Contact.class);
    }

    @Override
    public Contact updateContact(String contactId, ContactRequest contactRequest) throws URISyntaxException {
        return responseClient.post("/contacts/" + contactId, contactRequest, Contact.class);
    }

    @Override
    public void deleteContactById(String contactId) throws URISyntaxException {
        responseClient.delete("/contacts/" + contactId, Contact.class);
    }

    @Override
    public void unsubscribeFromMessage(String contactId, String messageId) {

    }

    @Override
    public List<Contact> getAllContacts(SearchRequest request) throws URISyntaxException {
        Contact[] contacts;
        if (request != null) {
            contacts = responseClient.search("/contacts", request.formatQueryParameters(), Contact[].class);
            return Arrays.asList(contacts);
        }
        contacts = responseClient.get("/contacts", Contact[].class);
        return Arrays.asList(contacts);
    }

    @Override
    public Contact findByEmailAndCampaign(String email, String campaignId) throws URISyntaxException {
        SearchRequest request = new SearchRequest();
        request.addQuery("email", email);
        request.addQuery("campaignId", campaignId);
        final List<Contact> contacts = getAllContacts(request);
        if (!contacts.isEmpty()) {
            return contacts.get(0);
        }
        return null;
    }
}
