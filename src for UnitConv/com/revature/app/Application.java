package com.revature.app;

import java.util.Scanner;
import com.revature.model.Converters;
import com.revature.model.Pstat;

public class Application {

	static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {

		Converters conv = new Converters();
		Pstat talk = new Pstat();
		
		talk.Intro();
				
		char line = scanner.next().charAt(0);

		char quit = 'a';

		
		do {
			if(line=='1') {
				conv.Distance(line);
				line = scanner.next().charAt(0);
			} else if(line=='2') {
				conv.Volume(line);
				line = scanner.next().charAt(0);
			} else if(line=='3') {
				conv.Temp(line);
				line = scanner.next().charAt(0);
			} else if(line == 'q') {
				System.out.println("Goodbye");
				quit = 'q';
			}
			else {talk.Error();
			line = scanner.next().charAt(0);
			}
		} while (quit != 'q');
		
	}
	
}

