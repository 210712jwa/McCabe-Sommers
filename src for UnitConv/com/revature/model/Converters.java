package com.revature.model;

import java.util.Scanner;

public class Converters {
	
	Scanner scanner = new Scanner(System.in);
	
	Pstat talk = new Pstat();
	
public double Distance(char line) {
	
	    talk.DisIntro();
		
		char tine = scanner.next().charAt(0);
		
		char quit = 'a';
		double con = 0;
		double mes = 0;
		
		do {			
			if(tine == '1') {
				System.out.println("Miles to Kilometers");
				System.out.println("Please enter measurement to convert.");
				con = scanner.nextDouble();
				System.out.println(con*1.60934 + "km");
				
				talk.DisIntro();
				
				tine = scanner.next().charAt(0);
			}
			else if(tine == '2') {
				System.out.println("Feet to Meters");
				System.out.println("Please enter measurement to convert.");
				con = scanner.nextDouble();
				System.out.println(con*0.3048 + "m");
				
				talk.DisIntro();
				
				tine = scanner.next().charAt(0);
			}
			else if(tine == '3') {
				System.out.println("Inches to Centimeters");
				System.out.println("Please enter measurement to convert.");
				con = scanner.nextDouble();
				System.out.println(con*2.54 + "cm");
				
				talk.DisIntro();
				
				tine = scanner.next().charAt(0);
			}
			else if(tine == 'q') {
				
				talk.Intro();
				
				quit = 'q';
			}
			else {
				
				talk.DisError();
				
				tine = scanner.next().charAt(0);
			}
		} while(quit != 'q');				
		
		return mes;
	}

public double Volume(char line) {
		
	talk.VolIntro();
	
	char tine = scanner.next().charAt(0);
	
	char quit = 'a';
	double con = 0;
	double mes = 0;
	
	do {			
		if(tine == '1') {
			System.out.println("Gallons to Liters");
			System.out.println("Please enter measurement to convert.");
			con = scanner.nextDouble();
			System.out.println(con*3.785 + "L");
			
			talk.VolIntro();
			
			tine = scanner.next().charAt(0);
		}
		else if(tine == '2') {
			System.out.println("Cubic Inches to Mililiters");
			System.out.println("Please enter measurement to convert.");
			con = scanner.nextDouble();
			System.out.println(con*16387.064 + "mL");
			
			talk.VolIntro();
			
			tine = scanner.next().charAt(0);
		}
		else if(tine == '3') {
			System.out.println("Cups to Mililiters");
			System.out.println("Please enter measurement to convert.");
			con = scanner.nextDouble();
			System.out.println(con*236.59 + "mL");
			
			talk.VolIntro();
			
			tine = scanner.next().charAt(0);
		}
		else if(tine == 'q') {
			
			talk.Intro();
			
			quit = 'q';
		}
		else {
			
			talk.VolError();
			
			tine = scanner.next().charAt(0);
		}
	} while(quit != 'q');
			
	return mes;
}	

public double Temp(char line) {
	
	
	talk.TempIntro();
	
	char tine = scanner.next().charAt(0);
	
	char quit = 'a';
	double con = 0;
	double mes = 0;
	
	do {			
		if(tine == '1') {
			System.out.println("Fahrenheit to Celsius");
			System.out.println("Please enter measurement to convert.");
			con = scanner.nextDouble();
			System.out.println(((con - 32)*(0.5556)) + "C");
			
			talk.TempIntro();
			
			tine = scanner.next().charAt(0);
		}
		else if(tine == '2') {
			System.out.println("Fahrenheit to Kelvin");
			System.out.println("Please enter measurement to convert.");
			con = scanner.nextDouble();
			System.out.println((((con - 32)*(0.5556)) + 273.15) + "K");
			
			talk.TempIntro();
			
			tine = scanner.next().charAt(0);
		}
		else if(tine == 'q') {
			
			talk.Intro();
			
			quit = 'q';
		}
		else {
			
			talk.TempError();

			tine = scanner.next().charAt(0);
		}
	} while(quit != 'q');
			
	return mes;
}	

}
