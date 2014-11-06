package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {
	@Test
	  public void DeleteSomeContact() throws Exception {
	    app.getNavigationHelper().openMainPage();
	  //save old state
	    List <ContactData> oldList = app.getContactHelper().getContacts();
	    
	    app.getContactHelper().deleteContact(0);
	    app.getContactHelper().returnToHomePage();
	    
	    //save new state
	    List <ContactData> newList = app.getContactHelper().getContacts();
	    //compare state   
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
