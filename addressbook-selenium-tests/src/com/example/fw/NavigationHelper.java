package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()){
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return findElements(By.id("maintable")).size() > 0;
	}

	public void groupsPage() {
		if (! onGroupPage()){
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupPage() {
		if (getCurrentURL().contains("/group.php")
			&& findElements(By.name("new")).size() > 0) {
			return true;
		}else {
			return false;
		}
	}

	public void printPhonesPage() {
		if (! onPrintPhonesPage()){
			click(By.linkText("print phones"));
		}
	}

	private boolean onPrintPhonesPage() {
		if (getCurrentURL().contains("phones")
				&& getCurrentURL().contains("print")
				&& findElements(By.id("view")).size() > 0) {
				return true;
			}else {
				return false;
			}
	}
}