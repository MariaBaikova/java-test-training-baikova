package com.example.tests;

import static org.junit.Assert.assertThat;

import java.util.Random;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemoveTests extends TestBase{
	@Test
	  public void DeleteSomeGroup() throws Exception {
	    //save old state
		SortedListOf <GroupData> oldList =  new  SortedListOf <GroupData> (app.getHibernateHelper().listGroups());
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getgroupHelper().deleteGroup(index);
	    
	    //save new state
	    SortedListOf <GroupData> newList = app.getgroupHelper().getGroups();
	    
	    //compare state   
	    assertThat(newList, equalTo(oldList.without(index)));
	  }
}
