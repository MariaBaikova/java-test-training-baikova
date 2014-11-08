package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateNewGroupTest extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    //save old state
    List <GroupData> oldList = app.getgroupHelper().getGroups();
    
    app.getgroupHelper().initGroupCreation();
    app.getgroupHelper().fillGroupForm(group);
    app.getgroupHelper().submitGroupCreation();
    app.getgroupHelper().returnToGroupsPage();
    
    //save new state
    List <GroupData> newList = app.getgroupHelper().getGroups();
    
    //compare state   
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
  }
  
}
