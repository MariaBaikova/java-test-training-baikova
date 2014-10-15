package com.example.tests;

import org.testng.annotations.Test;

public class AlsoCreateNewGroupTest extends TestBase{
	 @Test
	  public void testEmptyGroupCreation() throws Exception {
	    openMainPage();
	    changeGroupsPage();
	    initGroupCreation(); 
	    fillGroupForm(new GroupData("","",""));
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
}
