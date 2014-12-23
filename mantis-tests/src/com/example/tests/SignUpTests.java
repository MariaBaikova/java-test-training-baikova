package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignUpTests extends TestBase{
	
	public User user = new User().setLogin("testuser1").setPassword("123456")
			.setEmail("testuser1@localhost");
	
	private JamesHelper james;
	private AccountHelper accHelper;
	@BeforeClass
	public void createUser(){
		james = app.getJamesManager();
		accHelper = app.getAccountHelper();
		if (! james.doesUserExist(user.login)){
			james.createUser(user.login, user.password);
		}
	}
	
	@Test
	public void newUserShouldSignUp() {
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.login));
	}

	//@AfterClass
	public void deleteMailUser(){
		if (james.doesUserExist(user.login)){
			james.deleteUser(user.login);
		}
	}
}
