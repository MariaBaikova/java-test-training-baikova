package com.example.fw;



import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{
	
	public GroupHelper(ApplicationManager manager){
		super(manager);
	}
	
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	returnToGroupsPage();
    	//update model
    	manager.getModel().addGroup(group);
    	return this;
	}
	

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		manager.getModel().removeGroup(index);
		return this;
	}

	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initModificationGroup(index);
		assertThat((manager.getHibernateHelper().listGroups()),hasItem(getGroupFromEditPage()));
    	fillGroupForm(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	manager.getModel().removeGroup(index).addGroup(group);
		return this;
	}
	
	public GroupData getGroupFromEditPage(){
		return new GroupData().withName(getAttribute(By.name("group_name"), "value"))
				.withFooter(getText(By.name("group_footer")))
				.withHeader(getText(By.name("group_header")));
	}
//------------------------------------------------------------------------------------------------------------	
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}
	
	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"),group.getName());
		type(By.name("group_header"),group.getHeader());
		type(By.name("group_footer"),group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath(".//input[@name='selected[]']["+(index+1)+"]"));
	}

	public GroupHelper initModificationGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
		
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
		
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
	}


	public SortedListOf<GroupData> getUiGroups() {	
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List <WebElement> checkboxes = findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}
	
	
	
}
