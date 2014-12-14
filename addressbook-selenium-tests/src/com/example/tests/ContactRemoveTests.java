package com.example.tests;


import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemoveTests extends TestBase {
	@Test
	  public void DeleteSomeContact() throws Exception {
		
	  //save old state
		SortedListOf <ContactData> oldList = new  SortedListOf <ContactData> (app.getHibernateHelper().listContacts());
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getContactHelper().deleteContact(index);
	    
	    //save new state
	    SortedListOf <ContactData> newList = app.getContactHelper().getContacts();
	    //compare state   
	    app.getContactHelper().compareContactsListWithDB(newList);
	  }
}
