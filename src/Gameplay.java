import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.Border;


public class Gameplay implements ActionListener{
	//set for testing output text file
	static int count;
	
	//Chars
	static Playable_Char player = new Playable_Char();
	Boss1 boss = new Boss1();
	
	//UI
	JFrame frame = new JFrame();
	static JPanel contentPanel = new JPanel();
	JPanel startGame = new JPanel();
	JPanel characterPanel = new JPanel();
	JPanel bossPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel winScreen = new JPanel();
	JPanel loseScreen = new JPanel();
	
	//border
	Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
	
	
	static JLabel characterText = new JLabel();
	static JLabel characterAtkText = new JLabel();
	static JLabel characterHealth = new JLabel();
	//attack descriptions
	JLabel atkDescription = new JLabel(" ");
	JLabel bossAtkDescription = new JLabel(" ");
	
	JLabel winScreenText = new JLabel();
	JLabel loseScreenText = new JLabel();
	
	// buttons
	JButton charAtk = new JButton();
	JButton specialAtk = new JButton();
	JButton startGameButton = new JButton("Start Game");
	
	
	JLabel bossText = new JLabel();
	JLabel bossAtk = new JLabel();
	JLabel bossHealth = new JLabel();
	
	
	
	//listeners
	ActionListener attack = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				regularAttack();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	ActionListener specialAttack = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			specialAttack();	
		}
	};
	
	static JPanel characterSelection = new JPanel();
	
	//Characters
	JButton len = new JButton("Len");
	JButton jarya = new JButton("Jarya");
	JButton ditsu = new JButton("Ditsu");
	ActionListener lenPick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			player.pickPlayableLen();
			Character_Selection.pickChar();
			
		}
	};
	
	ActionListener jaryaPick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				player.pickPlayableJarya();
				Character_Selection.pickChar();
				
			}
		};
		
	ActionListener ditsuPick = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					player.pickPlayableDitsu();
					Character_Selection.pickChar();
					
				}
			};
		
	ActionListener start = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					startGame.setVisible(false);
					characterSelection.setVisible(true);
					
				}
			};
		
		

	//main function
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
		bossText.setText(boss.name);
		bossText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//setting FONT SIZE
		bossText.setFont(bossText.getFont().deriveFont(55.0f));
		bossAtk.setText("Attack: " + boss.attack);
		bossAtk.setHorizontalAlignment(SwingConstants.CENTER);
		bossAtk.setFont(bossAtk.getFont().deriveFont(30.0f));
		bossHealth.setText("Health: " + boss.health);
		bossHealth.setHorizontalAlignment(SwingConstants.CENTER);
		bossHealth.setFont(bossHealth.getFont().deriveFont(40.0f));
		
		//character text
		characterText.setText(player.getName());
		characterText.setHorizontalAlignment(SwingConstants.CENTER);
		characterText.setFont(characterText.getFont().deriveFont(55.0f));
		characterAtkText.setText("Attack: " + " " +player.getAttack());
		characterAtkText.setHorizontalAlignment(SwingConstants.CENTER);
		characterAtkText.setFont(characterAtkText.getFont().deriveFont(30.0f));
		characterHealth.setText("Health: " + player.health);
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
        


		
		//set labels and buttons

		
		//add to frame

		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.attack = player.getAttack() - boss.attack;
		frame.repaint();
		frame.revalidate();
	}
	

	
	public void bossAttack() {
		int damage = boss.chosenAttack();
		if(damage == 60) {
			bossAtkDescription.setText(boss.attackDescription);
			bossAtkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
			bossAtkDescription.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		}
		else {
			bossAtkDescription.setText(boss.specialDescription);
			bossAtkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
			bossAtkDescription.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		}
		player.health = player.getHealth() - damage;
		characterHealth.setText("Health: " + player.health);
	}
	//overriden method
	public void actionPerformed1(ActionEvent e) {
		player.attack = player.getAttack() - boss.attack;
		frame.repaint();
		frame.revalidate();
	}
	
	public void regularAttack() throws FileNotFoundException {
		
		if(player.getHealth() > 0) {
			boss.health = boss.health - player.getAttack();
			bossHealth.setText("Health: " + boss.health);
			atkDescription.setText(player.getAttackDesc());
			atkDescription.setHorizontalAlignment(SwingConstants.CENTER);
			atkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
			
			if(boss.health > 0) {
				bossAttack();
				if (player.getHealth() <=0) {
					contentPanel.remove(buttonsPanel);
					contentPanel.add(loseScreen);
				}
			}
			else {
				contentPanel.remove(buttonsPanel);
				contentPanel.add(winScreen);
				try(PrintWriter output = new PrintWriter("test.txt")){
					output.println(player.name + " " + count);
				}
					
				
			
				
			}
		}
		else {
		
			contentPanel.remove(buttonsPanel);
			contentPanel.add(winScreen);
			
		}
		
	}
	
	public void specialAttack() {
		if(player.getHealth() > 0) {
			if(player.name.equals("Jarya")) {
				player.special = player.bulletRain();
				player.setSP();

			}
			else if(player.name.equals("Ditsu")) {
				player.restore();	
			}
			boss.health = boss.health - player.getSpecial();
			bossHealth.setText("Health: " + boss.health);
			atkDescription.setText(player.getSpecialAtk());
			atkDescription.setHorizontalAlignment(SwingConstants.CENTER);
			atkDescription.setFont(atkDescription.getFont().deriveFont(20.0f));
			
			if(boss.health > 0) {
				bossAttack();
				if (player.getHealth() <=0) {
					contentPanel.remove(buttonsPanel);
					contentPanel.add(loseScreen);
				}
			}
			else {
				
				contentPanel.remove(buttonsPanel);
				contentPanel.add(winScreen);
			}
		}
		else {

			contentPanel.remove(buttonsPanel);
			contentPanel.add(loseScreen);
		}
	}
	
}
	
	

