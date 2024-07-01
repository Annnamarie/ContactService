package contactService;

public class Contact {
	
	//declaring contactId as constant so that it is not updatable
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String contactId, String firstName,String lastName, String phoneNumber, String address) {
		
		//contactId cannot be null
		//contactId cannot be longer than 10
		if(contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		this.contactId = contactId;
	
		
		//first name cannot be null
		//first name cannot be longer than 10
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
		
		//last name cannot be null
		//last name cannot be longer than 10
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
		
		//phone number cannot be null
		//must be digits
		//cannot be longer than 10 digits
		if(phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
		
		//address cannot be null
		//address cannot be longer than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
	
	//getter methods
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress(){
		return address;
	}

	
	//Setter methods
	public void setContactId(String contactId) {
		if (contactId != null && !contactId.equals(this.contactId)) {
			throw new IllegalStateException("Contact ID cannot be updated");
		}
	}
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	
}
