package com.example.tests;
import static com.example.tests.ContactDataGenerator.loadContactsFromCSVFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateNewContactTest extends TestBase{

 @DataProvider
   public Iterator<Object[]> contactsFromFile() throws IOException{
	  List <Object[]> list = wrapContactsForDataProvider(loadContactsFromXMLFile(new File("contacts.xml")));
	  return list.iterator();
  }

  @Test(dataProvider = "contactsFromFile")
  public void testContactCreation(ContactData contact) throws Exception {
	//save old state
	SortedListOf <ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().createContact(contact);
    	
    //save new state
    SortedListOf <ContactData> newList = app.getContactHelper().getContacts();
    //compare state   
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
