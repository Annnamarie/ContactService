package contactService;

import java.util.HashMap;
import java.util.Map;


public class ContactService {
	
	private Map<String, Contact> contactMap;
	
	public ContactService() {
		contactMap = new HashMap<>();
	}
	
	//Adding new contact
	public void addContact(Contact contact) {
		
		//check is the contact ID is unique
		if (contactMap.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contactMap.put(contact.getContactId(), contact);
	}
	
	//Deleting a contact by contact ID
	public void deleteContact(String contactId) {
		//check if the contact ID exists
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		contactMap.remove(contactId);
	}
	
	//update contact - firstName, lastName, phone number, address
	public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		//check if contact ID exists
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		Contact contact = contactMap.get(contactId);
		
		
		//set the updated/new values
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhoneNumber(phoneNumber);
		contact.setAddress(address);
	}
	
	//get contact by ID
	public Contact getContact(String contactId) {
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		return contactMap.get(contactId);
	}

}
