package com.example.tests;

import org.testng.annotations.Test;

public class CreateNewGroupTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getgroupHelper().initGroupCreation();
    GroupData group = new GroupData(); 
    group.name = "group 1";
    group.header = "header";
    group.footer = "footer 1";
    app.getgroupHelper().fillGroupForm(group);
    app.getgroupHelper().submitGroupCreation();
    app.getgroupHelper().returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getgroupHelper().initGroupCreation(); 
    app.getgroupHelper().fillGroupForm(new GroupData("","",""));
    app.getgroupHelper().submitGroupCreation();
    app.getgroupHelper().returnToGroupsPage();
  }
}
