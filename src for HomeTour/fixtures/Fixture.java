package fixtures;


public abstract class Fixture {
	
	
	private static String line = "";

	private static char str = '0';
	
	private static char key = '0';
	
	private static int HP = 50;
	
	private static String butch = "Say hey to the NiceGuy Butch, probably just asking for a fight. (type: butch)" + "\r\n";
	
	//Setters
	public static void setRoom(String newRoom) {
		line = newRoom;
		}
	public static void setStr(char str) {
		Fixture.str = str;
	}	
	public static void setKey(char key) {
		Fixture.key = key;
	}
	public static void setHP(double hP) {
		HP = (int) hP;
	}
	public static void setButch(String butch) {
		Fixture.butch = butch;
	}
	
	//Getters
	public static String getRoom() {
		return line;
	}
	public static char getKey() {
		return key;
	}
	public static char getStr() {
		return str;
	}
	public static int getHP() {
		return HP;
	}
	public static String getButch() {
		return butch;
	}

	
	
	
	
	
	//Rando vars
	protected static String HPcount = "current HP: "; 
	
	protected char quit = 'a';
	
	protected static String ouch = "'Ughhhhhhh.... What the heck?' " + "\r\n"
			+ "You wake up in the prison yard after losing a fight." + "\r\n"
			+ "'Dang.' Maybe I'll get him next time. Those NiceGuys are really a tough bunch." + "\r\n"
			+"                               " + "\r\n";
			
	protected static String intro = "Oh yeah, what did they say again? If I go to sleep I wont wake up?" + "\r\n"
			+ "I guess taking a nap in my cell wont be the best idea then." + "\r\n";
						
	protected static String menu = "I guess I could go...." + "\r\n"
    		+ "" + "\r\n"
			+ "To the Mess Hall to grab a bite and heal up. (type: mess)" + "\r\n"
			+ "To the Workout Area and maybe buff up. (type: workout)" + "\r\n"
			+ "To Cellblock A where I sleep, I gues not anymore. (type: cellA)" + "\r\n"
			+ "To Cellblock B where the gang NiceGuys hang around. (type: cellB)" + "\r\n"
			+ "To the Wardens Office, not sure why I would want to go there. (type: warden)";
	
	protected static String cellB = ("NiceGuys territory...." + "\r\n"
    		+ "I don't want to be here any longer then I have to." + "\r\n"
    		+ "" + "\r\n"
    		+ "I could....." + "\r\n"
    		+ "" + "\r\n");	    		
    		
    protected static String options = "Head back to the yard. (type: yard)" + "\r\n"
    		+ "Head to the Workout Area and maybe buff up. (type: workout)" + "\r\n";
	
    protected static String mess = ("The Mess Hall...." + "\r\n"
    		+ "It contains substances eerily similar to food" + "\r\n"
    		+ "Apperantly this stuff is good for me? (eating will restore HP)"+ "\r\n"
    		+ "" + "\r\n"
    		+ "I could....." + "\r\n"
    		+ "" + "\r\n"
    		+ "Eat what might be your last meal. (type: eat)" + "\r\n"
    		+ "Head back to the yard. (type: yard)" + "\r\n"
    		+ "Head to Cellblock A. (type: cellA)");

    protected static String cellA = ("Home sweet home.... I guess." + "\r\n"
    		+ "" + "\r\n"
    		+ "I could....." + "\r\n"
    		+ "" + "\r\n"
    		+ "Go to sleep. Apperantly I won't wake up? (type: sleep)" + "\r\n"
    		+ "Head back to the yard. (type:yard)" + "\r\n"
    		+ "Head to the Workout Area and maybe buff up. (type: workout)" + "\r\n"
    		+ "Head to the Mess Hall to grab a bite and heal up. (type: mess)");

    protected static String work = ("The Workout Area...." + "\r\n"
    		+ "Filled to the brim with VERY large men." + "\r\n"
    		+ "" + "\r\n"
    		+ "I could....." + "\r\n"
    		+ "" + "\r\n"
    		+ "Workout and maybe get a bit stronger. (type: pump)" + "\r\n"
    		+ "Head to Cellblock B. (type: cellB)"+ "\r\n"
    		+ "Head back to the yard. (type: yard)" + "\r\n"
    		+ "Head to Cellblock A. (type: cellA)");
    
    protected static String ward = ("The Warden's Office...." + "\r\n"
    		+ "Usually it is locked." + "\r\n"
    		+ "" + "\r\n"
    		+ "I could....." + "\r\n"
    		+ "" + "\r\n"
    		+ "Try the lock. (type: try)" + "\r\n"
    		+ "Head back to the yard. (type: yard)" + "\r\n");  

}

