package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
public class TestBase {
	protected ApplicationManager app;
	
	@BeforeTest 
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	  }
	
	@AfterTest 
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	   public Iterator<Object[]> randomValidGroupGenerator(){
		  List <Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++)	{
			  GroupData group = new GroupData();
			  group.name =   generateRandomString();
			  group.footer = generateRandomString();
			  group.header = generateRandomString();
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
		}
	   
	   @DataProvider
	   public Iterator<Object[]> randomValidContactGenerator(){
		  List <Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++)	{
			  	ContactData contact = new ContactData();
			  	contact.firstName = generateNotEmptyRandomString();
			    contact.lastName =  generateRandomString();
			    contact.address =   generateRandomString();
			    contact.homeTelephone = generateRandomNumber();
			    contact.mobileTelephone = generateRandomNumber();
			    contact.workTelephone = generateRandomNumber();
			    contact.email = generateRandomString()+"@mail.ru";
			    contact.email_2 = generateRandomString()+"@mail.ru";
			    contact.bDay = "11";
			    contact.bMonth = "November";
			    contact.bYear = "1990";
			    contact.address_2 = generateRandomString();
			    contact.home = generateRandomNumber();
			    contact.group = "";
			    list.add(new Object[]{contact});
		  }
		  return list.iterator();
		}
		  
		
	   public String generateRandomString(){
	 	  Random rnd  = new Random();
	 	  if (rnd.nextInt(3) ==0) {
	 		  return  "";
	 	  }
	 	  else {
	 		  return "test "+rnd.nextInt();
	 	  }
	   }
	   
	   public String generateNotEmptyRandomString(){
		 	  Random rnd  = new Random();
		 	  return "test "+rnd.nextInt();
		   }
	   
	   public String generateRandomNumber(){
		 	  Random rnd  = new Random();
		 	  return rnd.nextInt()+"";
		   }
}
