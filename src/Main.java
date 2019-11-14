


public class Main  {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gameplay game = new Gameplay();
		game.gameStart();
		
		Thread description = new Thread(new ThreadingDescription());
		description.start();
		}			
	}

