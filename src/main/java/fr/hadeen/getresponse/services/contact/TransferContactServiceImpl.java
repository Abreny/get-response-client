package fr.hadeen.getresponse.services.contact;

import fr.hadeen.getresponse.GetResponseServiceFactoryInterface;
import fr.hadeen.getresponse.domain.Contact;
import fr.hadeen.getresponse.domain.dto.ContactRequest;
import fr.hadeen.getresponse.domain.dto.SearchRequest;

import java.net.URISyntaxException;
import java.util.List;

public class TransferContactServiceImpl implements TransferContactService {
    private final GetResponseServiceFactoryInterface getResponseServiceFactory;

    public TransferContactServiceImpl(GetResponseServiceFactoryInterface getResponseServiceFactory) {
        this.getResponseServiceFactory = getResponseServiceFactory;
    }

    @Override
    public void transferContact(String campaignId, ContactRequest contactRequest) throws URISyntaxException {
        final ContactService contactService = getResponseServiceFactory.getContactService();
        SearchRequest request = new SearchRequest();
        request.addQuery("email", contactRequest.getEmail())
            .addQuery("campaignId", campaignId);
        final List<Contact> contacts = contactService.getAllContacts(request);
        System.out.println("FOIUND: " + contacts.size());
        if (!contacts.isEmpty()) {
            contactService.deleteContactById(contacts.get(0).getContactId());
        }
        contactService.createContact(contactRequest);
    }
}
