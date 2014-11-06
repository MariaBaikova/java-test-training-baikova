package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateNewContactTest extends TestBase{
  @Test
  public void testContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	//save old state
    List <ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "AAA";
    contact.lastName = "Baikova";
    contact.address = "Moscow";
    contact.homeTelephone = "1111111111111";
    contact.mobileTelephone = "22222222222222";
    contact.workTelephone = "3333333333";
    contact.email = "aemail@mail.ru";
    contact.email_2 = "email_2@mail.ru";
    contact.bDay = "11";
    contact.bMonth = "November";
    contact.bYear = "1990";
    contact.address_2 = "Moscow";
    contact.home = "111111";
    contact.group = "";
    
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
