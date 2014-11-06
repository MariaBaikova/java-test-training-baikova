package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends BaseHelper{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {
		getURL(manager.baseUrl + "/addressbookv4.1.4/");
	}


	public void gotoGroupsPage() {
		click(By.linkText("groups"));
	}
}
