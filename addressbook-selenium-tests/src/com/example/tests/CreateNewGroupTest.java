package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCSVFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CreateNewGroupTest extends TestBase {
  
 @DataProvider
   public Iterator<Object[]> groupsFromFile() throws IOException{
	  List <Object[]> list = wrapGroupsForDataProvider(loadGroupsFromXMLFile(new File("groups.xml")));
	  return list.iterator();
  }

@Test(dataProvider = "groupsFromFile")
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
