package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {	
	
	@Test(dataProvider = "randomValidContactGenerator")
	  public void modificationSomeContact(ContactData contact) throws Exception {
	    app.getNavigationHelper().openMainPage();  
	    
		//save old state
	    List <ContactData> oldList = app.getContactHelper().getContacts();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getContactHelper().initModificationContact(index);
	    app.getContactHelper().fillFormContact(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	    
	  //save new state
	    List <ContactData> newList = app.getContactHelper().getContacts();
	    //compare state   
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
