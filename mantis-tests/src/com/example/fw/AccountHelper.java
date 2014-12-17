package com.example.fw;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelperBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
	//	openURL("/signup_page.php");
		openURL("/");
		click(By.cssSelector("span.bracket-link"));
		type(By.name("username"),user.login);
		type(By.name("email"),user.email);
		click(By.cssSelector("input.button"));
		
		Message msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = exctractConfirmationLink(msg);
		openAbsoluteURL(confirmationLink);
		
		type(By.name("password"),user.password);
		type(By.name("password1"),user.password);
		click(By.cssSelector("input.button"));
	}

	public boolean isLogged(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
