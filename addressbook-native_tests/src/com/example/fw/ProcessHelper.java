package com.example.fw;

import java.io.IOException;

public class ProcessHelper  extends BaseHelper {

	private Process process;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void startAppUnderTest() throws IOException{
		String command = manager.getProperty("app.path");
		process = Runtime.getRuntime().exec(command);
		
	}
	
	public void stopAppUnderTest(){
			manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000)
				.click("Exit");
	}

}
