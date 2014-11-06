package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemoveTests extends TestBase{
	@Test
	  public void DeleteSomeGroup() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    //save old state
	    List <GroupData> oldList = app.getgroupHelper().getGroups();
	    
	    app.getgroupHelper().deleteGroup(0);
	    app.getgroupHelper().returnToGroupsPage();
	    
	    //save new state
	    List <GroupData> newList = app.getgroupHelper().getGroups();
	    
	    //compare state   
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
