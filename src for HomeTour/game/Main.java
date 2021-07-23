package game;

import java.util.Scanner;
import fixtures.Fixture;

public class Main extends Fixture{
			
	static RoomManager boss = new RoomManager();
		
	static Scanner scanner = new Scanner(System.in);		

	public static void main(String[] args) {
		
		System.out.println(ouch + intro);		
		
		boss.Yard();
	}

}
