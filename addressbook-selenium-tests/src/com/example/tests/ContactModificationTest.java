package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {	
	@Test
	  public void modificationSomeContact() throws Exception {
	    app.getNavigationHelper().openMainPage();  
	    
		//save old state
	    List <ContactData> oldList = app.getContactHelper().getContacts();
	    
	    app.getContactHelper().initModificationContact(0);
	    ContactData contact = new ContactData(); 
	    contact.firstName = "new firstname";
	    contact.lastName = "new lastname";
	    contact.email = "new_email@mail.ru";
	    contact.home = "321321321";
	    app.getContactHelper().fillFormContact(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	    
	  //save new state
	    List <ContactData> newList = app.getContactHelper().getContacts();
	    //compare state   
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
