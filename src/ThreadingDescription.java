import java.util.Scanner;

public class ThreadingDescription extends Gameplay implements Runnable {

	Scanner scanner = new Scanner(System.in);
	String userInput;
	static boolean chosenCharacter = false;
	
	public void run() {
		try {
			promptForStats();		
			}
		catch(Exception e)
		{
			System.out.println("Failed!");
		}
	}
	
	public void promptForStats() {
		System.out.println("Enter 'STATS' for character description and stats");
		userInput = scanner.nextLine();
		if (userInput.equals("STATS")) {
			String name = player.getName();
			String description = player.getDescription();
			String stats = "Attack: " + player.getAttack() + "\nSpecial: " + player.getSpecial();
			System.out.println("Character name: " + name);
			System.out.println("Character description: " + description);
			System.out.println(stats);
	}
		else {
			System.out.println("Good luck!");
		}
	}
}