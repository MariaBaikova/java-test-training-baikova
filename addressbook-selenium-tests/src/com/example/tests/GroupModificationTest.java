package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	  public void modificationSomeGroup(GroupData group) throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	   //save old state
	    List <GroupData> oldList = app.getgroupHelper().getGroups();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getgroupHelper().initModificationGroup(index);
	    app.getgroupHelper().fillGroupForm(group);
	    app.getgroupHelper().submitGroupModification();
	    app.getgroupHelper().returnToGroupsPage();
	    
	    //save new state
	    List <GroupData> newList = app.getgroupHelper().getGroups();
	    
	    //compare state   
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
