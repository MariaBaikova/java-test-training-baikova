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
	
	private SortedListOf<GroupData> cachedGroups;
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	returnToGroupsPage();
    	rebuildCache();
    	return this;
	}
	
	public SortedListOf<GroupData> getGroups() {
		/*if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;*/
		SortedListOf<GroupData> listGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List <WebElement> checkboxes = findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			listGroups.add(new GroupData().withName(name));
		}
		return listGroups;
	}
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>(manager.getHibernateHelper().listGroups());
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}

	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initModificationGroup(index);
		assertThat((manager.getHibernateHelper().listGroups()),hasItem(getGroupFromEditPage()));
    	fillGroupForm(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	rebuildCache();
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
		cachedGroups = null;
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
		cachedGroups = null;
		return this;
		
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
	
	
	
}
