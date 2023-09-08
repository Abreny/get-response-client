package fr.hadeen.getresponse.services.contact;

import fr.hadeen.getresponse.domain.Contact;

import fr.hadeen.getresponse.domain.dto.ContactRequest;
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
    public Contact createContact(ContactRequest contactRequest) throws URISyntaxException {
        return responseClient.post("/contacts", contactRequest, Contact.class);
    }

    @Override
    public Contact updateContact(String contactId, ContactRequest contactRequest) throws URISyntaxException {
        return responseClient.put("/contacts/" + contactId, contactRequest, Contact.class);
    }

    @Override
    public void deleteContactById(String contactId) throws URISyntaxException {
        responseClient.delete("/contacts/" + contactId, Contact.class);
    }

    @Override
    public void unsubscribeFromMessage(String contactId, String messageId) {

    }

    @Override
    public List<Contact> getAllContacts() throws URISyntaxException {
        System.out.println("get all contacts");
        final Contact[] contacts = responseClient.get("/contacts", Contact[].class);
        return Arrays.asList(contacts);
    }
}
