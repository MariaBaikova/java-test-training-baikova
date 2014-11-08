package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {
	@Test
	  public void DeleteSomeContact() throws Exception {
		
	  //save old state
	    List <ContactData> oldList = app.getContactHelper().getContacts();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getContactHelper().deleteContact(index);
	    
	    //save new state
	    List <ContactData> newList = app.getContactHelper().getContacts();
	    //compare state   
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
