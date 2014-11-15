package com.example.tests;

import java.util.Random;

public class RandomDataGenerator {
	 public static String generateRandomString(){
	 	  Random rnd  = new Random();
	 	  if (rnd.nextInt(3) ==0) {
	 		  return  "";
	 	  }
	 	  else {
	 		  return "test"+rnd.nextInt();
	 	  }
	   }
	 
	   public static String generateNotEmptyRandomString(){
		 	  Random rnd  = new Random();
		 	  return "test"+rnd.nextInt();
		   }
	   
	   public static String generateRandomNumber(){
		 	  Random rnd  = new Random();
		 	  return rnd.nextInt()+"";
		   }
}
