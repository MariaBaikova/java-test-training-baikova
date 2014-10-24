package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {
	@Test
	  public void DeleteSomeContact() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().deleteContact(1);
	    app.getContactHelper().returnToHomePage();
	  }
}
