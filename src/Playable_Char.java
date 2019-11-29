

import java.util.Random;

public class Playable_Char extends Character_Template  {

	Random random = new Random();	

	
	public void pickPlayableLen(String name) {
		
		Len_Char len = new Len_Char(name);
			this.attack = len.getAttack();
			this.specialAtk = len.getSpecialAtk();
			this.name = name;
			this.health = len.getHealth();
			this.physicalAtk = len.getAttackDesc();
			this.special = len.getSpecial();
			this.description = "Tank";		
	}
	
		
	public void pickPlayableJarya(String name) {
		Jarya jarya = new Jarya(name);
			this.attack = jarya.getAttack();
			this.special = jarya.getSpecial();
			this.specialAtk = jarya.getSpecialAtk();
			this.name = jarya.getName();
			this.health = jarya.getHealth();
			this.physicalAtk = jarya.getAttackDesc();
			this.description = "DPS";

	}
	
	
	public void pickPlayableDitsu(String name) {
		Ditsu_Char ditsu = new Ditsu_Char(name);
			this.attack = ditsu.getAttack();
			this.special = ditsu.getSpecial();
			this.specialAtk = ditsu.getSpecialAtk();
			this.name = ditsu.getName();
			this.health = ditsu.getHealth();
			this.physicalAtk = ditsu.getAttackDesc();
			this.description = "Healer";

	}


	public void setSpecial(){
		int damage = bulletRain();
		this.special = damage;
	}

	
	
	
}
