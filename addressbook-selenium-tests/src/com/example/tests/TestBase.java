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
			  GroupData group = new GroupData()
			  	.withName(generateRandomString())
			  	.withHeader(generateRandomString())
			  	.withFooter(generateRandomString());
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
		}
	   
	   

	@DataProvider
	   public Iterator<Object[]> randomValidContactGenerator(){
		  List <Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++)	{
			  	ContactData contact = new ContactData()
			  			.withFirstName(generateNotEmptyRandomString())
			  			.withLastName(generateRandomString())
			  			.withAddress(generateRandomString())
			  			.withHomeTelephone(generateRandomNumber())
			  			.withMobileTelephone(generateRandomNumber())
			  			.withWorkTelephone(generateRandomNumber())
			  			.withEmail(generateRandomString()+"@mail.ru")
			  			.withEmail_2(generateRandomString()+"@mail.ru")
			  			.withBday("11")
			  			.withBmonth("November")
			  			.withByear("1990")
			  			.withAddress_2(generateRandomString())
			  			.withHome(generateRandomNumber())
			  			.withGroup("");
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
