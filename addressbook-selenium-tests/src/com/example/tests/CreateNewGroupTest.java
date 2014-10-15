package com.example.tests;

import org.testng.annotations.Test;

public class CreateNewGroupTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    changeGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData(); 
    group.groupName = "group 1";
    group.header = "header";
    group.footer = "footer 1";
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
}
