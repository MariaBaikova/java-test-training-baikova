package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemoveTests extends TestBase{
	@Test
	  public void DeleteSomeGroup() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getgroupHelper().deleteGroup(1);
	    app.getgroupHelper().returnToGroupsPage();
	  }
}
