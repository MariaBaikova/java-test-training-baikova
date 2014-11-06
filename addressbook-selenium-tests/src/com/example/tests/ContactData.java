package com.example.tests;

public class ContactData implements Comparable <ContactData>{
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

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", home=" + home + "]";
	}

	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int result = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (result != 0) return result;
		return result = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
	
	
}