package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateNewContactTest extends TestBase{
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	//save old state
    List <ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillFormContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    List <ContactData> newList = app.getContactHelper().getContacts();
    //compare state   
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
  }
}
