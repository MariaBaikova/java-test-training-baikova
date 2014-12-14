package com.example.tests;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
public class ContactModificationTest extends TestBase {	
	
	@Test(dataProvider = "randomValidContactGenerator")
	  public void modificationSomeContact(ContactData contact) throws Exception {
 
		//save old state
		SortedListOf <ContactData> oldList =  app.getModel().getContacts();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getContactHelper().modifyContact(index, contact);
	    
	  //save new state
	    SortedListOf <ContactData> newList = app.getContactHelper().getUiContacts();
	    //compare state   
	    app.getContactHelper().compareContactsListWithDB(newList);
	  }
}
