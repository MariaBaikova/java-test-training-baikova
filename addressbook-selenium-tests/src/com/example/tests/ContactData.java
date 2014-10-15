package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homeTelephone;
	public String mobileTelephone;
	public String workTelephone;
	public String email;
	public String email_2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String address_2;
	public String home;
	public String group;

	public ContactData(String firstName, String lastName, String address,
			String homeTelephone, String mobileTelephone, String workTelephone,
			String email, String email_2, String bDay, String bMonth,
			String bYear, String address_2, String home, String group) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeTelephone = homeTelephone;
		this.mobileTelephone = mobileTelephone;
		this.workTelephone = workTelephone;
		this.email = email;
		this.email_2 = email_2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.address_2 = address_2;
		this.home = home;
		this.group = group;
	}
	
	public ContactData(){
		
	}
}