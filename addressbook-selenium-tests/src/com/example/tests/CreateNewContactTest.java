package com.example.tests;
import org.testng.annotations.Test;

public class CreateNewContactTest extends TestBase{
  @Test
  public void testGroupCreation() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "Maria";
    contact.lastName = "Baikova";
    contact.address = "Moscow";
    contact.homeTelephone = "1111111111111";
    contact.mobileTelephone = "22222222222222";
    contact.workTelephone = "3333333333";
    contact.email = "email@mail.ru";
    contact.email_2 = "email_2@mail.ru";
    contact.bDay = "11";
    contact.bMonth = "November";
    contact.bYear = "1990";
    contact.address_2 = "Moscow";
    contact.home = "123123123";
    contact.group = "";
    
    fillFormContact(contact);
    submitContactCreation();
    returnToHomePage();
  }
}
