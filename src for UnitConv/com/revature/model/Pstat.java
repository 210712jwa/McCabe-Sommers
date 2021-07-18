package com.revature.model;

public class Pstat {
	
public void Intro() {
	System.out.println("Main Menu");
	System.out.println("Acceptable input: ");
	System.out.println(	"[1 - Distance, 2 - Volume, 3 - Temperature"
			+ ", q - exit program]");
	System.out.println("Please type in a command and hit Enter.");
}

public void Error() {
	System.out.println("Try again. Accepatable input:"); 
	System.out.println("[1 - Distance, 2 - Volume, 3 - Temperature,"
			+ ", q - exit program]");
	System.out.println("Please type in a command and hit Enter.");
}

public void DisIntro() {
    System.out.println("Acceptable input:");
	System.out.println("[1 - Miles to Kilometers, 2 - Feet to Meters, 3 - " + 
			"Inches to Centimeters, q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

public void DisError() {
	System.out.println("Try again. Accepatable input:");
	System.out.println("[1 - Miles to Kilometers, 2 - Feet to Meters," + 
		" 3 - Inches to Centimeters, q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

public void VolIntro() {
	System.out.println("Acceptable input:");
	System.out.println("[1 - Gallons to Liters, 2 - Cubic Inches to Mililiters, 3 - " + 
			"Cups to Mililiters, q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

public void VolError() {
	System.out.println("Try again. Accepatable input:");
	System.out.println("[1 - Miles to Kilometers, 2 - Feet to Meters," + 
			" 3 - Inches to Centimeters, q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

public void TempIntro() {
	System.out.println("Acceptable input:");
	System.out.println("[1 - Fahrenheit to Celsius, 2 - Fahrenheit to Kelvin" + 
			" q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

public void TempError() {
	System.out.println("Try again. Accepatable input:");
	System.out.println("[1 - Fahrenheit to Celsius, 2 - Fahrenheit to Kelvin" + 
			" q - previous menu]");
	System.out.println("Please type in a command and hit Enter.");
}

}
