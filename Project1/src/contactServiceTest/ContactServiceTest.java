package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {
	
	private ContactService contactService;
	
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
	}
	
	//Testing AddContact
	@Test
	void testAddContact() {
		Contact contact = new Contact("1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
		contactService.addContact(contact);
		assertEquals(contact, contactService.getContact("1234567890"));
	}
	
	//Adding contact with an already existing ID
	@Test
	void testInvalidAddContact() {
		Contact contact1 = new Contact("1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
        contactService.addContact(contact1);
        
        // Attempt to add another contact with the same ID
        Contact contact2 = new Contact("1234567890", "Jason", "Johnson", "8625491872", "978 Rancho Roble Way");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
		
	}
	
	//Testing Deleting Contact
	@Test
	void testDeleteContact() {
		Contact contact = new Contact("1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
		contactService.addContact(contact);
		
		//Delete the contact
		contactService.deleteContact("1234567890");
		
		//Check that the contact was deleted
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact("1234567890");
		});
	}
	
	//Try to delete a contact that does not exist
	@Test
	void testDeleteInvalidContact() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.deleteContact("9999999999");
	    });
	}
	
	//testing updateContact
	@Test
	void testUpdateContact() {
		Contact contact = new Contact("1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
		contactService.addContact(contact);
		
		//update contact details
		contactService.updateContact("1234567890","Jason", "Johnson", "8625491872", "978 Rancho Roble Way");
		
		//retrieve the updated contact
		Contact updatedContact = contactService.getContact("1234567890");
		
		//Check that the updated details are correct
		assertEquals("Jason", updatedContact.getFirstName());
	    assertEquals("Johnson", updatedContact.getLastName());
	    assertEquals("8625491872", updatedContact.getPhoneNumber());
	    assertEquals("978 Rancho Roble Way", updatedContact.getAddress());
	}
	
	@Test
	void testInvalidUpdateContac() {
	    Contact contact = new Contact("1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
	    contactService.addContact(contact);

	    // Try to update with null values
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.updateContact("1", null, null, null, null);
	    });
	    
	    // Try to update with invalid first name
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.updateContact("1", "Michele-Annelise", "Camacho", "77765ABC5", "456 Elk Grove Blvd");
	    });
	    
	    // Try to update with invalid last name
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.updateContact("1", "Michele", "Camacho-Ybanez", "77765ABC5", "456 Elk Grove Blvd");
	    });

	    // Try to update with invalid phone number
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.updateContact("1", "Michele", "Camacho", "77765ABC5", "456 Elk Grove Blvd");
	    });

	    // Try to update with address longer than 30 characters
	    assertThrows(IllegalArgumentException.class, () -> {
	        contactService.updateContact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd, Elk Grove, CA 95677, United States, North America");
	    });
	}
}


//"1234567890", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd"
//"2234567890", "Jason", "Johnson", "8625491872", "978 Rancho Roble Way"