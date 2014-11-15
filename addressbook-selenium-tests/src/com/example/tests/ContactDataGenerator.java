package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tests.RandomDataGenerator.generateNotEmptyRandomString;
import static com.example.tests.RandomDataGenerator.generateRandomNumber;
import static com.example.tests.RandomDataGenerator.generateRandomString;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args)throws IOException  {
		if (args.length < 3) {
			System.out.println("Please specify parametrs: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		if (file.exists()){
			System.out.println("file exists, please remote it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)){
			saveContactsToCSVFile(contacts, file); }
		else if ("xml".equals(format)) {
		saveContactsToXMLFile(contacts, file); }
		else{
			System.out.println("Unkown format " + format);
			return;
		}
	}

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXMLFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress()  + "," +
					contact.getHomeTelephone()  + "," + contact.getMobileTelephone() + "," + contact.getWorkTelephone()  + "," +
					contact.getEmail()  + "," + contact.getEmail_2()  + "," + contact.getbDay()  + "," + contact.getbMonth()  + "," +
					contact.getbYear()  + "," + contact.getAddress_2() + contact.getHome() + ",!"+ "\n");
		}
		writer.close();
		
	}

	public static List<ContactData> loadContactsFromCSVFile(File file) throws IOException {
		List <ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
	  			.withFirstName(part[0])
	  			.withLastName(part[1])
	  			.withAddress(part[2])
	  			.withHomeTelephone(part[3])
	  			.withMobileTelephone(part[4])
	  			.withWorkTelephone(part[5])
	  			.withEmail(part[6])
	  			.withEmail_2(part[7])
	  			.withBday(part[8])
	  			.withBmonth(part[9])
	  			.withByear(part[10])
	  			.withAddress_2(part[11])
	  			.withHome(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List <ContactData> list = new ArrayList<ContactData>();
		  for (int i = 0; i < amount; i++)	{
			  ContactData contact = new ContactData()
	  			.withFirstName(generateNotEmptyRandomString())
	  			.withLastName(generateRandomString())
	  			.withAddress(generateRandomString())
	  			.withHomeTelephone(generateRandomNumber())
	  			.withMobileTelephone(generateRandomNumber())
	  			.withWorkTelephone(generateRandomNumber())
	  			.withEmail(generateRandomString()+"@mail.ru")
	  			.withEmail_2(generateRandomString()+"@mail.ru")
	  			.withBday("11")
	  			.withBmonth("November")
	  			.withByear("1990")
	  			.withAddress_2(generateRandomString())
	  			.withHome(generateRandomNumber())
	  			.withGroup("");
			  list.add(contact);
		  }
		return list;
	}
}

