package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.example.utils.SortedListOf;

public class CheckPrintPhonesPage extends TestBase{
	
	@Test
	public void testCheckCountContactOnPrintPage() throws Exception {
		//save contact list on main page
		SortedListOf <ContactData> contactList = app.getContactHelper().getContacts();
		assertEquals(contactList.size(),app.getContactHelper().getCountContactOnPrintPage());
	}
	
	@Test
	public void testCheckContactOnPrintPage() throws Exception {
		//save contact list on main page
		SortedListOf <ContactData> contactList = app.getContactHelper().getContacts();
		app.getContactHelper().checkContactsOnPrintPage(contactList);
	}
}
