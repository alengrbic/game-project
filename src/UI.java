import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class UI {
	//set for testing output text file
	
	static int count;
	
	//test for image
	
	//Chars
	
	
	//UI
	JFrame frame = new JFrame();
	static JPanel contentPanel = new JPanel();
	JPanel startGame = new JPanel();
	static JPanel characterPanel = new JPanel();
	static JPanel bossPanel = new JPanel();
	static JPanel buttonsPanel = new JPanel();
	static JPanel winScreen = new JPanel();
	static JPanel loseScreen = new JPanel();
	
	//border
	Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
	
	
	static JLabel characterText = new JLabel();
	static JLabel characterAtkText = new JLabel();
	static JLabel characterHealth = new JLabel();
	//attack descriptions
	static JLabel atkDescription = new JLabel(" ");
	static JLabel bossAtkDescription = new JLabel(" ");
	
	static JLabel winScreenText = new JLabel();
	static JLabel loseScreenText = new JLabel();
	
	// buttons
	static JButton charAtk = new JButton();
	static JButton specialAtk = new JButton();
	static JButton startGameButton = new JButton("Start Game");
	
	
	static JLabel bossText = new JLabel();
	static JLabel bossAtk = new JLabel();
	static JLabel bossHealth = new JLabel();
	
	
	//listener for regular attack
	ActionListener attack = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Gameplay_Methods.regularAttack();
			
		}
	};
	//listener for special attack
	ActionListener specialAttack = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			
			Gameplay_Methods.specialAttack();
			
		}
	};
	
	static JPanel characterSelection = new JPanel();
	
	//Characters
	static JButton len = new JButton("Len");
	static JButton jarya = new JButton("Jarya");
	static JButton ditsu = new JButton("Ditsu");
	
	
	//listeners for character picks 
	ActionListener lenPick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Gameplay_Methods.player.pickPlayableLen();
			Character_Selection.pickChar();
			
		}
	};
	
	ActionListener jaryaPick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gameplay_Methods.player.pickPlayableJarya();
				Character_Selection.pickChar();
				
			}
		};
		
	ActionListener ditsuPick = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Gameplay_Methods.player.pickPlayableDitsu();
					Character_Selection.pickChar();
					
				}
			};			
	//end of listeners for character pick
		
	ActionListener start = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					startGame.setVisible(false);
					characterSelection.setVisible(true);
					
				}
			};

	//UI function
	public void gameStart() {
		
		startGame.setLayout(new BorderLayout());
		startGame.add(startGameButton, BorderLayout.CENTER);
		startGame.setBounds(0, 0, 800, 800);
		startGameButton.addActionListener(start);
		startGameButton.setFont(startGameButton.getFont().deriveFont(50.0f));
		
		len.addActionListener(lenPick);
		len.setFont(len.getFont().deriveFont(30.0f));
		jarya.addActionListener(jaryaPick);
		jarya.setFont(jarya.getFont().deriveFont(30.0f));
		
		ditsu.setFont(ditsu.getFont().deriveFont(30.0f));
		ditsu.addActionListener(ditsuPick);
		
		characterSelection.setLayout(new GridLayout());
		characterSelection.add(len);
		characterSelection.add(jarya);
		characterSelection.add(ditsu);
		characterSelection.setBounds(0, 0, 800, 800);
		characterSelection.setVisible(false);
		contentPanel.setVisible(false);			
		
		charAtk.addActionListener(attack);
		specialAtk.addActionListener(specialAttack);
		
		atkDescription.setBorder(border);
		atkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
		bossAtkDescription.setBorder(border);
		bossAtkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
			
		//boss text
		bossText.setText(Gameplay_Methods.boss.name);
		bossText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//setting FONT SIZE
		bossText.setFont(bossText.getFont().deriveFont(55.0f));
		bossAtk.setText("Attack: " + Gameplay_Methods.boss.attack);
		bossAtk.setHorizontalAlignment(SwingConstants.CENTER);
		bossAtk.setFont(bossAtk.getFont().deriveFont(30.0f));
		bossHealth.setText("Health: " + Gameplay_Methods.boss.health);
		bossHealth.setHorizontalAlignment(SwingConstants.CENTER);
		bossHealth.setFont(bossHealth.getFont().deriveFont(40.0f));
		
		//character text
		characterText.setText(Gameplay_Methods.player.getName());
		characterText.setHorizontalAlignment(SwingConstants.CENTER);
		characterText.setFont(characterText.getFont().deriveFont(55.0f));
		characterAtkText.setText("Attack: " + " " +Gameplay_Methods.player.getAttack());
		characterAtkText.setHorizontalAlignment(SwingConstants.CENTER);
		characterAtkText.setFont(characterAtkText.getFont().deriveFont(30.0f));
		characterHealth.setText("Health: " + Gameplay_Methods.player.health);
		characterHealth.setHorizontalAlignment(SwingConstants.CENTER);
		characterHealth.setFont(characterHealth.getFont().deriveFont(40.0f));
		
		//winscreen
		winScreenText.setText("You win!");
		winScreenText.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		winScreenText.setFont(winScreenText.getFont().deriveFont(40.0f));
		
		winScreen.setLayout(new BorderLayout());
		winScreen.setBackground(Color.WHITE);
		winScreen.add(winScreenText, BorderLayout.CENTER);
		
		//lose screen
		loseScreenText.setText("Game over!");
		loseScreenText.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		loseScreenText.setFont(loseScreenText.getFont().deriveFont(40.0f));
		
		loseScreen.setLayout(new BorderLayout());
		loseScreen.setBackground(Color.WHITE);
		loseScreen.add(loseScreenText, BorderLayout.CENTER);
				
		
		//buttons
		charAtk.setText("Attack");
		specialAtk.setText("Special");

		//panels
		bossPanel.setLayout(new BorderLayout());
		bossPanel.setBackground(Color.getHSBColor(0.8f, 20, 75));
		bossPanel.setPreferredSize(new Dimension(300, 240));
		bossPanel.add(bossText, BorderLayout.NORTH);
		bossPanel.add(bossAtk, BorderLayout.CENTER);
		bossPanel.add(bossHealth, BorderLayout.SOUTH);
		
		characterPanel.setLayout(new BorderLayout());
		characterPanel.setBackground(Color.getHSBColor(0.8f, 20, 75));
		characterPanel.setPreferredSize(new Dimension(300, 240));
		characterPanel.add(characterText, BorderLayout.SOUTH);
		characterPanel.add(characterAtkText, BorderLayout.CENTER);
		characterPanel.add(characterHealth, BorderLayout.NORTH);
				
		
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setPreferredSize(new Dimension(500,500));
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.add(charAtk, BorderLayout.WEST);
		buttonsPanel.add(specialAtk, BorderLayout.EAST);
		
		
		buttonsPanel.add(atkDescription, BorderLayout.SOUTH);
		buttonsPanel.add(bossAtkDescription, BorderLayout.NORTH);
				
		
		//settings for content panel
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBounds(0, 0, 800, 800);
		
        contentPanel.add(bossPanel, BorderLayout.NORTH);
        contentPanel.add(characterPanel, BorderLayout.SOUTH);
        contentPanel.add(buttonsPanel, BorderLayout.CENTER);
        
		
		//sets for frame
        frame.setSize(800+15, 800 + 40);
        frame.setResizable(false);
        frame.add(startGame);
        frame.add(characterSelection);
		frame.add(contentPanel);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}	
}
	
	

