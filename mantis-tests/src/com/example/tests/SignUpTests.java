package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.example.fw.User;

public class SignUpTests extends TestBase{
	
	public User user = new User().setLogin("testuser1").setPassword("123456")
			.setEmail("testuser1@localhost");
	@BeforeClass
	public void createUser(){
		if (! app.getJamesManager().doesUserExist(user.login)){
			app.getJamesManager().createUser(user.login, user.password);
		}
	}
	
	@Test
	public void newUserShouldSignUp() {
		app.getAccountHelper().signup(user);
		assertTrue(app.getAccountHelper().isLogged(user));
	}

	@AfterClass
	public void deleteMailUser(){
		if (app.getJamesManager().doesUserExist(user.login)){
			app.getJamesManager().deleteUser(user.login);
		}
	}
}
