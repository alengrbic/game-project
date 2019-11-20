import java.io.*;
import java.text.*;
import java.util.*;

public class ThreadingDescription extends Gameplay_Methods implements Runnable  {
	

	Scanner scanner = new Scanner(System.in);
	String userInput;
	static boolean chosenCharacter = false;
	
	public static String path = System.getProperty("user.dir");
	
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
	
	public void readSave(String saveName) {
		
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
		
	//	System.out.println(dataTheReturn[0]);
	//	System.out.println(dataTheReturn[1]);
	//	System.out.println(dataTheReturn[2]);
	//	System.out.println(dataTheReturn[3]);

		if (dataTheReturn[3] == "Tank") {
			Gameplay_Methods.player.pickPlayableLen(dataTheReturn[0], Integer.parseInt(dataTheReturn[1]));
			Gameplay_Methods.boss.health = Integer.parseInt(dataTheReturn[2]);
		
		}
		
		if (dataTheReturn[3] == "DPS") {
			Gameplay_Methods.player.pickPlayableJarya(dataTheReturn[0], Integer.parseInt(dataTheReturn[1]));
			Gameplay_Methods.boss.health = Integer.parseInt(dataTheReturn[2]);
		
			}
		
		if (dataTheReturn[3] == "Healer") {
			Gameplay_Methods.player.pickPlayableDitsu(dataTheReturn[0], Integer.parseInt(dataTheReturn[1]));
			Gameplay_Methods.boss.health = Integer.parseInt(dataTheReturn[2]);
		
			}		

		
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
	
	public void promptForStats() {
		System.out.println("Enter 'STATS' for character description and stats, and SAVE to save the game and quit");
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
			System.exit(0);;			
		}
		
		
		else {			

		    promptForStats();
		    
		}
	}
	

	
}