package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelperBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
	//	openURL("/signup_page.php");
		openURL("/");
		click(By.xpath(".//*[@href='signup_page.php']")); 
		//cssSelector("span.bracket-link"));
		type(By.name("username"),user.login);
		type(By.name("email"),user.email);
		click(By.cssSelector("input.button"));
		
		pause(3000);
		String msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = getConfirmationLink(msg);
		openAbsoluteURL(confirmationLink);
		
		type(By.name("password"),user.password);
		type(By.name("password1"),user.password);
		click(By.cssSelector("input.button"));
	}


	public boolean isLogged(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getConfirmationLink(String msg) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(msg);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}

}
