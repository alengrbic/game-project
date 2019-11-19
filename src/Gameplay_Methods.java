import java.awt.Component;

import javax.swing.SwingConstants;

public class Gameplay_Methods {
	
	static Playable_Char player = new Playable_Char();
	static Boss1 boss = new Boss1();
	
	//method for "Attack" action
	public static void regularAttack() {
			
			if(player.getHealth() > 0) {
				boss.health = boss.health - player.getAttack();
				UI.bossHealth.setText("Health: " + boss.health);
				UI.atkDescription.setText(player.getAttackDesc());
				UI.atkDescription.setHorizontalAlignment(SwingConstants.CENTER);
				UI.atkDescription.setFont(UI.atkDescription.getFont().deriveFont(20.0f));
				
				if(boss.health > 0) {
					bossAttack();
					if (player.getHealth() <=0) {
						UI.contentPanel.remove(UI.buttonsPanel);
						UI.contentPanel.add(UI.loseScreen);
					}
				}
				else {
					UI.contentPanel.remove(UI.buttonsPanel);
					UI.contentPanel.add(UI.winScreen);
				
				}
			}
			else {
			
				UI.contentPanel.remove(UI.buttonsPanel);
				UI.contentPanel.add(UI.winScreen);
				
			}
			
		}
	
	//method for "Special" action
	public static void specialAttack() {
		if(player.getHealth() > 0) {
			if(player.name.equals("Jarya")) {
				player.special = player.bulletRain();
				player.setSP();

			}
			else if(player.name.equals("Ditsu")) {
				player.restore();	
			}
			boss.health = boss.health - player.getSpecial();
			UI.bossHealth.setText("Health: " + boss.health);
			UI.atkDescription.setText(player.getSpecialAtk());
			UI.atkDescription.setHorizontalAlignment(SwingConstants.CENTER);
			UI.atkDescription.setFont(UI.atkDescription.getFont().deriveFont(20.0f));
			
			if(boss.health > 0) {
				bossAttack();
				if (player.getHealth() <=0) {
					UI.contentPanel.remove(UI.buttonsPanel);
					UI.contentPanel.add(UI.loseScreen);
				}
			}
			else {
				
				UI.contentPanel.remove(UI.buttonsPanel);
				UI.contentPanel.add(UI.winScreen);
			}
		}
		else {

			UI.contentPanel.remove(UI.buttonsPanel);
			UI.contentPanel.add(UI.loseScreen);
		}
	}
	
	//method for boss attack after choosing player input
	public static void bossAttack() {
		int damage = boss.chosenAttack();
		if(damage == 40 || damage == 50) {
			UI.bossAtkDescription.setText(boss.attackDescription);
			UI.bossAtkDescription.setFont(UI.atkDescription.getFont().deriveFont(20.0f));
			UI.bossAtkDescription.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		}
		else {
			UI.bossAtkDescription.setText(boss.specialDescription);
			UI.bossAtkDescription.setFont(UI.atkDescription.getFont().deriveFont(20.0f));
			UI.bossAtkDescription.setHorizontalAlignment((int) (Component.CENTER_ALIGNMENT));
		}
		player.health = player.getHealth() - damage;
		UI.characterHealth.setText("Health: " + player.health);
	}
	
}
