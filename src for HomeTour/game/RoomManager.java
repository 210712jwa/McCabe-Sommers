package game;

public class RoomManager extends Main{
	
	
public void Yard() {
		
	    
	    System.out.println(menu + "\r\n" + HPcount);
	    System.out.println(getHP()+ "/100");
		
		String line = scanner.next();

		
		do {
			if(line.equals("cellB")) {
				CellBlockB();
				line = getRoom();
			} else if(line.equals("yard")) {
				Yard();
				line = getRoom();
			} else if(line.equals("mess")) {
				MessHall();
				line = getRoom();
			} else if(line.equals("cellA")) {
				CellBlockA();
				line = getRoom();
			} else if(line.equals("workout")) {
				Workout();
				line = getRoom();
			} else if(line.equals("warden")) {
				Warden();
				line = getRoom();
			} else if(line.equals("quit")) {
				System.out.println("Game Over");
				quit = 'q';
			}
			else {System.out.println("I dont think thats an option......");
			line = scanner.next();
			}
		} while (quit != 'q');
	}
	
public static void CellBlockB() {
	    	    
	    System.out.println(cellB + getButch() + options + HPcount);
	    System.out.println(getHP() + "/100");
		
		String tine = scanner.next();
		
		char quit = 'a';
		char con = 0;
		char wimp = 'a';
		char limp = 'a';
		
		do {			
			if(tine.equals("butch")) {
				System.out.println("'What you wanna fight'? (type: n/y)");
				con = scanner.next().charAt(0);
				do {
				if(con == 'n') {
					System.out.println("'Smart move.'");
					System.out.println(cellB);
					wimp = 'q';
				} else if(con == 'y') {
					if(getStr() == '0') {
					System.out.println("'Let's go then!'" + "\r\n"
							+ "WHAM!! BAMMM!! KERPLOWWWWWW!!!!" + "\r\n"
							+ "");
					setHP(getHP() - (Math.random() * 100));
					if(getHP() <= 0) {
						System.out.println("As you fade to black, you realize your not coming back."
								+ "\r\n" + "HP = 0");
						System.out.println("Game Over");
						System.exit(0);
					}
					setRoom("yard");
					System.out.println(ouch);
					quit = 'q';
					limp = 'q';
					wimp = 'q';
					} else {
						System.out.println("'Let's go then!'" + "\r\n"
								+ "WHAM!! BAMMM!! KERPLOWWWWWW!!!!" + "\r\n"
								+ "" + "\r\n"
								+ "'HAHA GOT YOU, YOU OVERSIZED LUG!!!'" + "\r\n"
								+ "As Butch falls to the ground unconscious" + "\r\n" 
								+ "a key with a big W falls out of his pocket." + "\r\n"
								+ "You grab the key and pretend that nothing ever happened." + "\r\n"
								+ "" + "\r\n");
						setKey('1');
						if(getKey() == '1') {
							setButch("");
						}
						System.out.println(cellB + getButch() + options);
						wimp = 'q';
					}
				} else {System.out.println("'What did you say? You wanna fight?' (type: n/y)");
					con = scanner.next().charAt(0);}
				} while (wimp != 'q');

				if(limp == 'q') {
					tine = "quit";
				} else {
				tine = scanner.next();
				}
				
			} else if(tine.equals("workout")) {
				setRoom("workout");
				quit = 'q';	
				
			} else if(tine.equals("yard")) {
				System.out.println("Back to the yard....." + "\r\n"
						+ "Not much has changed");	
				setRoom("yard");				
				quit = 'q';

			} else if(tine.equals("quit")) {
				quit = 'q';
			}
			else {System.out.println("I dont think thats an option......");
				tine = scanner.next();
			}
		} while(quit != 'q');				
		
	}
	
public static void MessHall() {
		
	    System.out.println(mess + "\r\n" + HPcount);
	    System.out.println(getHP()+ "/100");
		
		String tine = scanner.next();
		
		char quit = 'a';
		char con = 0;
		char wimp = 'a';
		
		do {			
			if(tine.equals("eat")) {
				System.out.println("lunch person: 'You really want to eat it?' (type: n/y)");
				con = scanner.next().charAt(0);
				do {
				if(con == 'n') {
					System.out.println("'Probably for the best.'");
					System.out.println(mess);
					wimp = 'q';
				} else if(con == 'y') {
					System.out.println("Oh boy....." + "\r\n"
							+ "munch munch munch" + "\r\n"
							+ "");
					setHP(100);
					System.out.println(mess);
					System.out.println(getHP()+ "/100");
					wimp = 'q';
				} else {System.out.println("lunch person: 'I couldn't hear you. You want food?' (type: n/y)");
				con = scanner.next().charAt(0);}
				} while (wimp != 'q');
				
				tine = scanner.next();
				
			} else if(tine.equals("yard")) {
				System.out.println("Back to the yard....." + "\r\n"
						+ "Not much has changed");	
				setRoom("yard");
				quit = 'q';

			} else if(tine.equals("cellA")) {
				setRoom("cellA");
				quit = 'q';
			}
			else {System.out.println("I dont think thats an option......");
				tine = scanner.next();
			}
		} while(quit != 'q');				
	}

public static void CellBlockA() {	
    
    System.out.println(cellA + "\r\n" + HPcount);
    System.out.println(getHP()+ "/100");
	
	String tine = scanner.next();
	
	char quit = 'a';
	char con = 0;
	char wimp = 'a';
	char limp = 'a';
	
	do {			
		if(tine.equals("sleep")) {
			System.out.println("Are you sure? (type: n/y)");
			con = scanner.next().charAt(0);
			do {
			if(con == 'n') {
				System.out.println("Not quite done with life yet.");
				System.out.println(cellA);
				wimp = 'q';
			} else if(con == 'y') {
				System.out.println("It wasn't the worst life");
				System.out.println("Game Over");
				System.exit(0);
			} else {System.out.println("I don't think that is an option. (type: n/y)");
				con = scanner.next().charAt(0);}
			} while (wimp != 'q');
			if(limp == 'q') {
				tine = "quit";
			} else {
			tine = scanner.next();
			}
			
		} else if(tine.equals("workout")) {
			setRoom("workout");
			quit = 'q';	
			
		} else if(tine.equals("yard")) {
			System.out.println("Back to the yard....." + "\r\n"
					+ "Not much has changed");	
			setRoom("yard");
			quit = 'q';

		} else if(tine.equals("mess")) {
			setRoom("mess");
			quit = 'q';
		}
		else {System.out.println("I dont think thats an option......");
			tine = scanner.next();
		}
	} while(quit != 'q');				
	
	//return "";
}

public static void Workout() {	
    
    System.out.println(work + "\r\n" + HPcount);
    System.out.println(getHP()+ "/100");
	
	String tine = scanner.next();
	
	char quit = 'a';
	char wimp = 'a';
	
	do {			
		if(tine.equals("pump")) {
			do {
			if(getStr() == '0') {
				System.out.println("UHF ERGH GRAAAAAH" + "\r\n"
						+ "That was a good workout." + "\r\n");
				System.out.println(work);
				setStr('1');
				wimp = 'q';
			} else {
				System.out.println("Already worked out today." + "\r\n");
				System.out.println(work);
				wimp = 'q';
			} 
			} while (wimp != 'q');
			
			tine = scanner.next();
			
		} else if(tine.equals("cellB")) {
			setRoom("cellB");
			quit = 'q';	
			
		} else if(tine.equals("yard")) {
			System.out.println("Back to the yard....." + "\r\n"
					+ "Not much has changed");	
			setRoom("yard");
			quit = 'q';

		} else if(tine.equals("cellA")) {
			setRoom("cellA");
			quit = 'q';
		}
		else {System.out.println("I dont think thats an option......");
			tine = scanner.next();
		}
	} while(quit != 'q');				
	
}

public static void Warden() {
    
    System.out.println(ward + HPcount);
    System.out.println(getHP()+ "/100");
	
	String tine = scanner.next();
	
	char quit = 'a';
	char wimp = 'a';
	
	do {			
		if(tine.equals("try")) {
			do {
			if(getKey() == '0') {
				System.out.println("Tries doorknob" + "\r\n"
						+ "'Nope, it is locked.'" + "\r\n");
				System.out.println(ward);
				wimp = 'q';
			} else {
				System.out.println("The key worked!!!" + "\r\n"
						+"You manage to sneak through the office, out a window, and to your freedom!" + "\r\n"
						+ "\r\n"
						+"CONGRATULATIONS!!! YOU WON!!!!");				
				System.exit(0);
			} 
			} while (wimp != 'q');
			
			tine = scanner.next();
			
		} else if(tine.equals("yard")) {
			System.out.println("Back to the yard....." + "\r\n"
					+ "Not much has changed");	
			setRoom("yard");
			quit = 'q';

		}
		else {System.out.println("I dont think thats an option......");
			tine = scanner.next();
		}
	} while(quit != 'q');				
	
}

	
}

