package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.example.fw.User;

public class SignUpTests extends TestBase{
	
	@Test
	public void newUserShouldSignUp() {
		User user = new User().setLogin("testuser1").setPassword("123456")
				.setEmail("testuser1@localhost.localdomain");
		app.getAccountHelper().signup(user);
		assertTrue(app.getAccountHelper().isLogged(user));
	}

	
}
