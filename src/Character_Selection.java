

import javax.swing.*;

public class Character_Selection extends UI{

		public static void pickChar() {
			characterSelection.setVisible(false);
			contentPanel.setVisible(true);
			characterText.setText(Gameplay_Methods.player.getName());
			characterText.setHorizontalAlignment(SwingConstants.CENTER);
			characterText.setFont(characterText.getFont().deriveFont(55.0f));
			characterAtkText.setText("Attack: " + " " +Gameplay_Methods.player.getAttack());
			characterAtkText.setHorizontalAlignment(SwingConstants.CENTER);
			characterAtkText.setFont(characterAtkText.getFont().deriveFont(30.0f));
			characterHealth.setText("Health: " + Gameplay_Methods.player.health);
			characterHealth.setHorizontalAlignment(SwingConstants.CENTER);
			characterHealth.setFont(characterHealth.getFont().deriveFont(40.0f));
		}
	

}
