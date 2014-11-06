package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends BaseHelper {
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillFormContact(ContactData contact) {
		type(By.name("lastname"),contact.lastName);
		type(By.name("firstname"),contact.firstName);
		type(By.name("address"),contact.address);
		type(By.name("home"),contact.home );
		type(By.name("mobile"),contact.mobileTelephone);
		type(By.name("work"),contact.workTelephone);
		type(By.name("email"),contact.email);
		type(By.name("email2"),contact.email_2);
	    selectByText(By.name("bday"), contact.bDay);
	    selectByText(By.name("bmonth"), contact.bMonth);	  
	    type(By.name("byear"),contact.bYear);   
	   // selectByText(By.name("new_group"), contact.group);    
	    type(By.name("address2"),contact.address_2);
	    type(By.name("phone2"),contact.home);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}
	
	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath(".//*[@id='content']/form[2]/input[2]"));	
	}

	private void selectContactByIndex(int index) {
		By locator = By.xpath(".//*[@name='entry']["+(index+1)+"]/td[7]/a/img");
		click(locator);
	}


	public void submitContactModification() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
		
	}

	public void initModificationContact(int index) {
		selectContactByIndex(index);

	}


	public List<ContactData> getContacts() {
		List <ContactData> contacts = new ArrayList <ContactData>();
		int rowsTable = findElements(By.name("entry")).size();
		for (int i = 0; i < rowsTable; i++) {
			ContactData contact = new ContactData();
			contact.firstName = getText(By.xpath(".//*[@name='entry']["+(i+1)+"]/td[3]"));
			contact.lastName = getText(By.xpath(".//*[@name='entry']["+(i+1)+"]/td[2]"));
			contact.email = getText(By.xpath(".//*[@name='entry']["+(i+1)+"]/td[4]"));
			contact.home = getText(By.xpath(".//*[@name='entry']["+(i+1)+"]/td[5]"));
			contacts.add(contact);
		}
		return contacts;
	}


}
