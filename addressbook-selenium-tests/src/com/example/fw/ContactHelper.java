package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends BaseHelper {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCached();
		}
		return cachedContacts;
	}
	
	private void rebuildCached() {
		cachedContacts = new ArrayList <ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
			.setLastName(row.findElement(By.xpath(".//td[2]")).getText())
			.setFirstName(row.findElement(By.xpath(".//td[3]")).getText());
			cachedContacts.add(contact);
		}
	}

	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
    	fillFormContact(contact,CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	rebuildCached();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();	
		returnToHomePage();
		rebuildCached();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initModificationContact(index);
    	fillFormContact(contact, MODIFICATION);
    	submitContactModification();
    	returnToHomePage();
    	rebuildCached();
		return this;
	}
	
//------------------------------------------------------------------------------------------------	
	public ContactHelper fillFormContact(ContactData contact, boolean formType) {
		type(By.name("lastname"),contact.getLastName());
		type(By.name("firstname"),contact.getFirstName());
		type(By.name("address"),contact.getAddress());
		type(By.name("home"),contact.getHome() );
		type(By.name("mobile"),contact.getMobileTelephone());
		type(By.name("work"),contact.getWorkTelephone());
		type(By.name("email"),contact.getEmail());
		type(By.name("email2"),contact.getEmail_2());
	    selectByText(By.name("bday"), contact.getbDay());
	    selectByText(By.name("bmonth"), contact.getbMonth());	  
	    type(By.name("byear"),contact.getbYear());   
	    if (formType == CREATION){
	    	selectByText(By.name("new_group"), contact.getGroup());   
	    }
	    else{
	    	if (findElements(By.name("new_group")).size()!=0){
	    		throw new Error("Group selector exists in contact modification form");
	    	}		
	    }   	
	    type(By.name("address2"),contact.getAddress_2());
	    type(By.name("phone2"),contact.getHome());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	private void selectContactByIndex(int index) {
		By locator = By.xpath(".//*[@name='entry']["+(index+1)+"]/td[7]/a/img");
		click(locator);
	}


	public ContactHelper submitContactModification() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
		cachedContacts = null;
		return this;
		
	}

	public ContactHelper initModificationContact(int index) {
		selectContactByIndex(index);
		return this;

	}


	public List<WebElement> getContactRows(){
		List <WebElement> contactRows = new ArrayList <WebElement>();
		int rowsTable = getRowCountContact();
		for(int i = 0; i < rowsTable; i++){
			WebElement row = findElement(By.xpath(".//*[@name='entry']["+(i+1)+"]"));
			contactRows.add(row);
		}
		return contactRows;
	}
	
	public int getRowCountContact(){
		return findElements(By.name("entry")).size();
	}

	private ContactHelper submitContactDeletion() {
		click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
		cachedContacts = null;
		return this;
	}

}
