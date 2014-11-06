package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateNewGroupTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    //save old state
    List <GroupData> oldList = app.getgroupHelper().getGroups();
    
    app.getgroupHelper().initGroupCreation();
    GroupData group = new GroupData(); 
    group.name = "group 1 S";
    group.header = "header";
    group.footer = "footer 1";
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
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    //save old state
    List <GroupData> oldList = app.getgroupHelper().getGroups();
    
    app.getgroupHelper().initGroupCreation(); 
    GroupData group = new GroupData("","",""); 
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
