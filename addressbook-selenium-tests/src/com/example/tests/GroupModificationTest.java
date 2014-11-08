package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	  public void modificationSomeGroup(GroupData group) throws Exception {
	    
	   //save old state
	    List <GroupData> oldList = app.getgroupHelper().getGroups();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getgroupHelper().modifyGroup(index, group);
	    
	    //save new state
	    List <GroupData> newList = app.getgroupHelper().getGroups();
	    
	    //compare state   
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}
