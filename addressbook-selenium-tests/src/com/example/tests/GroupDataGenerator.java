package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.example.tests.RandomDataGenerator.generateRandomString;
import com.thoughtworks.xstream.XStream;

public class GroupDataGenerator {

	public static void main(String[] args) throws IOException {
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
		
		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)){
			saveGroupsToCSVFile(groups, file); }
		else if ("xml".equals(format)) {
		saveGroupsToXMLFile(groups, file); }
		else{
			System.out.println("Unkown format " + format);
			return;
		}
	}

	private static void saveGroupsToXMLFile(List<GroupData> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveGroupsToCSVFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (GroupData group : groups) {
			writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + ",!"+ "\n");
		}
		writer.close();
		
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List <GroupData> list = new ArrayList<GroupData>();
		  for (int i = 0; i < amount; i++)	{
			 GroupData group = new GroupData()
			  	.withName(generateRandomString())
			  	.withHeader(generateRandomString())
			  	.withFooter(generateRandomString());
			  list.add(group);
		  }
		return list;
	}
}
