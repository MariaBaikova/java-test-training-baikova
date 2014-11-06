package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{
	@Test
	  public void modificationSomeGroup() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	   //save old state
	    List <GroupData> oldList = app.getgroupHelper().getGroups();
	    
	    app.getgroupHelper().initModificationGroup(0);
	    GroupData group = new GroupData(); 
	    group.name = "new group";
	    app.getgroupHelper().fillGroupForm(group);
	    app.getgroupHelper().submitGroupModification();
	    app.getgroupHelper().returnToGroupsPage();
	    
	    //save new state
	    List <GroupData> newList = app.getgroupHelper().getGroups();
	    
	    //compare state   
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
