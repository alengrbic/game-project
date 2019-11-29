import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;

public class ThreadingDescription extends Gameplay_Methods implements Runnable  {
	

	Scanner scanner = new Scanner(System.in);
	String userInput;
	static boolean chosenCharacter = false;
	
	
	//a string storing the path of the project 
	private static String path = System.getProperty("user.dir");
	
	
	//a function that searches the project directory for .txt files and saves the results in an array list
	public List<String> listFiles() {	
		
		  List<String> textFiles = new ArrayList<String>();
		  File dir = new File(path);
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".txt"))) {
		      textFiles.add(file.getName());
		    }
		  }
	
		  return textFiles;		  

	}
	
	
	//a function that opens the selected .txt file, reads the info and prints it to the console
	private void readSave(String saveName) {
		
		Scanner fileIn;
		ArrayList<String> data = new ArrayList<String>();		
		
		try {
			fileIn = new Scanner(new FileReader(saveName));
		for (int i = 0; i < 4; i++) { 
			data.add(fileIn.nextLine());
			}
		fileIn.close();
			}
		catch (FileNotFoundException e) {System.out.println("Error: " + e.getMessage());
		}
		
		String[] dataTheReturn = data.toArray(new String[data.size()]);
		
		System.out.println("Character name: " + dataTheReturn[0]);
		System.out.println("Character health: " + dataTheReturn[1]);
		System.out.println("Boss Health: " + dataTheReturn[2]);
		System.out.println("Character description: " + dataTheReturn[3]);
		
	}
	
	
	//a function that opens the dialogue prompt offering the selection of loaded .txt files
	private void runLoad() {
		
		List<String> loadedList = listFiles();
		
		Object[] list = loadedList.toArray();
				
		Object value = JOptionPane.showInputDialog(null, "Which game would you like to continue?",
		        "Load Game", JOptionPane.QUESTION_MESSAGE, null, list, null);
		
		readSave(value.toString());
			
	}
	
	//randomises a number, turns it to a string, uses the current system date in ddMMyyyy format and creates a sting RNDNUMplayernameDATE
	//opens a new file, reads the information from the player object and prints it to the file. closes the file
	//sends a message under which filename the game has been successfully saved
	private void saveGame() {
		
		
		PrintWriter fileOut;
		Random ran = new Random();
		int randomNum = ran.nextInt(1000);
		String serial = Integer.toString(randomNum);
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		String date = df.format(new Date());
		String saveFileName = serial + player.getName() + date + ".txt";
		
		
		
		try {
			
			
			fileOut = new PrintWriter(saveFileName);
			fileOut.println(player.getName());
			fileOut.println(Integer.toString(player.getHealth()));
			fileOut.println(Integer.toString(boss.getBossHealth()));
			fileOut.print(player.getDescription());
			fileOut.close();
			
		} 
		catch (FileNotFoundException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}
		
		
		System.out.println("Your game has been saved with the save file name: " + saveFileName);
		System.exit(0);	
		
	}
		
	
	public void run() {
		try {			
			promptForStats();		
			}
		catch(Exception e)
		{
			System.out.println("Failed!");
		}
	}
	
	private void promptForStats() {
		System.out.println("Enter 'STATS' for character description and stats, SAVE to save the game and quit, LOAD to see the saved game stats.");
		userInput = scanner.nextLine();
		if (userInput.equals("STATS")) {
			String name = player.getName();
			String description = player.getDescription();
			String stats = "Attack: " + player.getAttack() + "\nSpecial: " + player.getSpecial() + "\nHealth: " + player.getHealth();
			String bossHealth = Integer.toString(boss.getBossHealth());
			System.out.println("Character name: " + name);
			System.out.println("Character description: " + description);
			System.out.println(stats);
			System.out.println("Boss Health: " + bossHealth);
			promptForStats();
	}
		else if (userInput.equals("SAVE")) {
			
			saveGame();
			
		}
		
		else if (userInput.equals("LOAD")) {
			
			runLoad();
			
		}
		else {			

		    promptForStats();
		    
		}
	}
	

	
}