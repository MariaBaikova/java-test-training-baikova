package com.example.tests;

public class ContactData implements Comparable <ContactData>{
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String homeTelephone;
	private String mobileTelephone;
	private String workTelephone;
	private String email;
	private String email_2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String address_2;
	private String home;
	private String telephone;
	private String group;
	
	public String getFirstName() {
		return firstName;
	}

	public ContactData setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public ContactData setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public ContactData setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public ContactData setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
		return this;
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public ContactData setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
		return this;
	}

	public String getWorkTelephone() {
		return workTelephone;
	}

	public ContactData setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ContactData setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getEmail_2() {
		return email_2;
	}

	public ContactData setEmail_2(String email_2) {
		this.email_2 = email_2;
		return this;
	}

	public String getbDay() {
		return bDay;
	}

	public ContactData setbDay(String bDay) {
		this.bDay = bDay;
		return this;
	}

	public String getbMonth() {
		return bMonth;
	}

	public ContactData setbMonth(String bMonth) {
		this.bMonth = bMonth;
		return this;
	}

	public String getbYear() {
		return bYear;
	}

	public ContactData setbYear(String bYear) {
		this.bYear = bYear;
		return this;
	}

	public String getAddress_2() {
		return address_2;
	}

	public ContactData setAddress_2(String address_2) {
		this.address_2 = address_2;
		return this;
	}

	public String getHome() {
		return home;
	}

	public ContactData setHome(String home) {
		this.home = home;
		return this;
	}

	public String getGroup() {
		return group;
	}

	public ContactData setGroup(String group) {
		this.group = group;
		return this;
	}

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
				+ ", address=" + address + ", homeTelephone=" + homeTelephone
				+ ", mobileTelephone=" + mobileTelephone + ", workTelephone="
				+ workTelephone + ", email=" + email + ", email_2=" + email_2
				+ ", bDay=" + bDay + ", bMonth=" + bMonth + ", bYear=" + bYear
				+ ", address_2=" + address_2 + ", home=" + home + "]";
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address_2 == null) {
			if (other.address_2 != null)
				return false;
		} else if (!address_2.equals(other.address_2))
			return false;
		if (bDay == null) {
			if (other.bDay != null)
				return false;
		} else if (!bDay.equals(other.bDay))
			return false;
		if (bMonth == null) {
			if (other.bMonth != null)
				return false;
		} else if (!bMonth.equals(other.bMonth))
			return false;
		if (bYear == null) {
			if (other.bYear != null)
				return false;
		} else if (!bYear.equals(other.bYear))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_2 == null) {
			if (other.email_2 != null)
				return false;
		} else if (!email_2.equals(other.email_2))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileTelephone == null) {
			if (other.mobileTelephone != null)
				return false;
		} else if (!mobileTelephone.equals(other.mobileTelephone))
			return false;
		if (workTelephone == null) {
			if (other.workTelephone != null)
				return false;
		} else if (!workTelephone.equals(other.workTelephone))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int result = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (result != 0)
				return result;
		result = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase()); 
		if (result != 0)
			return result; 
		return 0;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
		return this;
	}

	public ContactData withMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
		return this;
	}

	public ContactData withWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail_2(String email_2) {
		this.email_2 = email_2;
		return this;
	}

	public ContactData withBday(String bDay) {
		this.bDay = bDay;
		return this;
	}

	public ContactData withBmonth(String bMonth) {
		this.bMonth = bMonth;
		return this;
	}

	public ContactData withByear(String bYear) {
		this.bYear = bYear;
		return this;
	}

	public ContactData withAddress_2(String address_2) {
		this.address_2 = address_2;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}

	public String getTelephone() {
		return telephone;
	}

	public ContactData setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}