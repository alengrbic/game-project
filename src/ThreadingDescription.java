import java.util.Scanner;

public class ThreadingDescription extends Gameplay implements Runnable {
	
	//refactor the method "run" - if character is not chosen, output a string and reprompt. if chosen, output stats

	Scanner scanner = new Scanner(System.in);
	String userInput;
	
	public void run() {
		try {
			System.out.println("Enter 'STATS' for character description and stats");
			userInput = scanner.nextLine();
			if (userInput.equals("STATS")) {
				String description = player.getDescription();
				String stats = "Attack: " + player.getAttack() + "\nSpecial: " + player.getSpecial();
				System.out.println(description);
				System.out.println(stats);
		}
			else {
				System.out.println("Good luck!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed!");
		}
		

	}
}