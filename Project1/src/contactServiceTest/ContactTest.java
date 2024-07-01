package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contact = new Contact("1","Bob", "Johnson", "0123456789", "1234 Main St");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Bob"));
		assertTrue(contact.getLastName().equals("Johnson"));
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
		assertTrue(contact.getAddress().equals("1234 Main St"));
	}
	
	//test contact ID constraints - cannot be updated, null, no longer than 10 char
	
	@Test
	void testContactIdNull() {
	    Contact contact = new Contact("1", "Bob", "Johnson", "0123456789", "1234 Main St");
	
	    // Try to set the contact ID to null
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(null, "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
	    });
	}
	@Test
	void testContactIdTooLong() {
	    Contact contact = new Contact("1", "Bob", "Johnson", "0123456789", "1234 Main St");

	    // Try to set the contact ID longer than 10 characters
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("99999999999", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
	    });
	}
	@Test
	void testContactIdUpdate() {
	    Contact contact = new Contact("1", "Bob", "Johnson", "0123456789", "1234 Main St");
	    
	    //Try to update contact ID
	    assertThrows(IllegalStateException.class, () -> {
	    	contact.setContactId("2");
	    });
	}
	
	//test first name constraints - cannot be null, no longer than 10 char
	@Test
	void testFirstNameNull() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
		    
		// Try to set the first name to null
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);

		});
	}
	@Test
	void testFirstNameTooLong() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
		   

		// Try to set the first name longer than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
		     contact.setFirstName("Airian Zaire");
		});
		
	}
		
	//test last name constraints - cannot be null, no longer than 10 char
	@Test
	void testLastNameNull() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
				    
		// Try to set the last name to null
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	@Test
	void testLastNameTooLong() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
			

		// Try to set the last name longer than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Camacho-Ybanez");
		});
	}
	
	//test phone number constraints - cannot be null, must be digits, no longer than 10
	@Test
	void testPhoneNumberNull() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
			    
		// Try to set the phone number to null
		assertThrows(IllegalArgumentException.class, () -> {
			 contact.setPhoneNumber(null);
		});
	}
	@Test
	void testPhoneNumberNotDigits() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
			

		// Try to set the phone number that are not digits
		assertThrows(IllegalArgumentException.class, () -> {
			 contact.setPhoneNumber("8876ABCDEJ");
		});
	}
	@Test
	void testPhoneNumberTooLong() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
			
		
		// Try to set the phone number that are longer than 10
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("999999999999");
		});
	}
	
	//test phone number constraints - cannot be null, must be digits, no longer than 10
	@Test
	void testAddress() {
		Contact contact = new Contact("1", "Michele", "Camacho", "7776537290", "456 Elk Grove Blvd");
				    
		// Try to set the phone number to null
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
			
		// Try to set the phone number that are longer than 30
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("456 Elk Grove Blvd, Elk Grove, CA 95677, United States, North America");
		});
	}

}
