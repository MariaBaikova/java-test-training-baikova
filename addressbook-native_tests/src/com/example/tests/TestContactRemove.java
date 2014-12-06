package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestContactRemove extends TestBase{
	
	@Test
	public void removeAllContacts(){
		app.getContactHelper().deleteAllContacts();
		Assert.assertEquals(app.getContactHelper().checkEmptyList(),true);
	}
}
