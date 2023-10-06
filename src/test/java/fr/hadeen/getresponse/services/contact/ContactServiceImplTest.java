package fr.hadeen.getresponse.services.contact;

import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import fr.hadeen.getresponse.config.GetResponseProperties;
import fr.hadeen.getresponse.domain.Contact;
import fr.hadeen.getresponse.domain.dto.ContactRequest;
import fr.hadeen.getresponse.domain.dto.ids.CampaignId;
import fr.hadeen.getresponse.services.GetResponseClient;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceImplTest {
    private final String key = "6m073i1z3olpndadb8h2393wq4s3fdxq";
    private final String campaignId = "MPnQ7";
    // private final String campaignId = "MPnCm";

    private final String email = "vatilab@gmail.com";
    
    private GetResponseClient getResponseClient;

    @BeforeEach
    void setUp() {
        getResponseClient = new GetResponseClient(GetResponseProperties.forKey(key), new RestTemplate(), UriComponentsBuilder.newInstance());
    }

    @Disabled
    @Test
    @Order(1)
    void test_add_to_campaign() throws URISyntaxException {
        final ContactService service = new ContactServiceImpl(getResponseClient);
        final ContactRequest request = buildContactRequest();
        service.createContact(request);

        final Contact contact = service.findByEmailAndCampaign(email, campaignId);
        assertNotNull(contact);
        assertNotNull(contact.getContactId());
    }

    private ContactRequest buildContactRequest() {
        final ContactRequest request = new ContactRequest(email, new CampaignId().setCampaignId(campaignId));
        return request;
    }

    @Test
    @Order(2)
    void test_reset_in_campaign() throws URISyntaxException {
        final ContactService service = new ContactServiceImpl(getResponseClient);
        final ContactRequest request = buildContactRequest();
        service.resetContact(request);

        try {
            Thread.sleep(12000);
        } catch (Exception e) {}

        final Contact contact = service.findByEmailAndCampaign(email, campaignId);
        assertNotNull(contact);
    }
    
    @Disabled
    @Test
    @Order(3)
    void test_delete_from_campaign() throws URISyntaxException {
        final ContactService service = new ContactServiceImpl(getResponseClient);
        Contact contact = service.findByEmailAndCampaign(email, campaignId);
        assertNotNull(contact);

        service.deleteContactById(contact.getContactId());

        contact = service.findByEmailAndCampaign(email, campaignId);
        assertNull(contact);
    }
}
