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
		SortedListOf <GroupData> oldList =  app.getModel().getGroups();
	    Random rnd  = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getgroupHelper().deleteGroup(index);
	    
	    //save new state
	    SortedListOf <GroupData> newList = app.getModel().getGroups();
	    
	    //compare state   
	    assertThat(newList, equalTo(oldList));
	 // compare model to implementation
	    if (wantToCheck()){
		    if ("yes".equals(app.getProperty("check.db"))){
		    		assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
		    }
		   
		    if ("yes".equals(app.getProperty("check.ui"))){
		    		assertThat(app.getModel().getGroups(), equalTo(app.getgroupHelper().getUiGroups()));
		   }
	    }
	  }
}
