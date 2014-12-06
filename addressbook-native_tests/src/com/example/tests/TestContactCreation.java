package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase{
	@Test
	public void createContactWithValidData(){
		Contact contact = new Contact().setFirstName("tester1").setLastName("tester1");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
	}
}
