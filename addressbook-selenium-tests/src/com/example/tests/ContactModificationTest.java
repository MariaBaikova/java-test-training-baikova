package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {	
	@Test
	  public void modificationSomeContact() throws Exception {
	    app.getNavigationHelper().openMainPage();  
	    app.getContactHelper().initModificationContact(1);
	    ContactData contact = new ContactData(); 
	    contact.firstName = "new firstname";
	    contact.lastName = "new lastname";
	    app.getContactHelper().fillFormContact(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	  }
}
