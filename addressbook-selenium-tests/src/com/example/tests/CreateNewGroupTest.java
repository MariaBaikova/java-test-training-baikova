package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CreateNewGroupTest extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old state
	 SortedListOf <GroupData> oldList = app.getgroupHelper().getGroups();
    
    app.getgroupHelper().createGroup(group);
    
    //save new state
    SortedListOf <GroupData> newList = app.getgroupHelper().getGroups();
    
    //compare state   
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }
  
}
