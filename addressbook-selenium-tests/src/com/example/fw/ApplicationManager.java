package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;


public class ApplicationManager {
	private WebDriver driver;
	public String baseUrl;
	private Properties properties;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	
	public ApplicationManager(Properties properties){
		this.properties = properties;
		model = new ApplicationModel();
		model.setGroups(getHibernateHelper().listGroups());
		model.setContacts(getHibernateHelper().listContacts());
	}
	
	public void stop() {
		driver.quit();
	}
	
	public ApplicationModel getModel(){
		return model;
	}
	
	public NavigationHelper navigateTo(){
		if (navigationHelper==null){
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getgroupHelper(){
		if (groupHelper==null){
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper==null){
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		baseUrl = properties.getProperty("baseUrl");
		if (driver==null){
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();
			}else if ("opera".equals(browser)){
				driver = new OperaDriver();
			}else if ("ie".equals(browser)){
				driver = new InternetExplorerDriver();
			}else{
				throw new Error("Unsupported browser: " + browser);
			}
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		}
		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null){
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}
