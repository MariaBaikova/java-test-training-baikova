package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{
	@Test
	  public void modificationSomeGroup() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getgroupHelper().initModificationGroup(1);
	    GroupData group = new GroupData(); 
	    group.name = "new group";
	    app.getgroupHelper().fillGroupForm(group);
	    app.getgroupHelper().submitGroupModification();
	    app.getgroupHelper().returnToGroupsPage();
	  }
}
