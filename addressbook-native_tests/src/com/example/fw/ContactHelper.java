package com.example.fw;



public class ContactHelper extends BaseHelper{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.getFirstName())
			.send("TDBEdit11", contact.getLastName());
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add")
			.winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		
		Contact contact = new Contact()
			.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
		
	}

	public void deleteAllContacts() {
		manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TListView1")
			.click("Select All")
			.click("Delete")
			.winWaitAndActivate("Confirm", "", 5000)
			.click("&Yes")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
			
	}

	public boolean checkEmptyList() {
		return manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}")
		.click("Edit").winExists("Information", "", 5000);
		
	}

	

}
