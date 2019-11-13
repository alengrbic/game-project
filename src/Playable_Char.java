
import java.util.Random;

public class Playable_Char extends Character_Template  {

	Random random = new Random();
	
	public void pickPlayableLen() {
		Len_Char len = new Len_Char();
			this.attack = len.getAttack();
			this.specialAtk = len.getSpecialAtk();
			this.name = len.getName();
			this.health = len.getHealth();
			this.physicalAtk = len.getAttackDesc();
			this.special = len.getSpecial();
			Gameplay.count += 1;
	}
	
	public void pickPlayableJarya() {
		Jarya jarya = new Jarya();
			this.attack = jarya.getAttack();
			this.special = jarya.getSpecial();
			this.specialAtk = jarya.getSpecialAtk();
			this.name = jarya.getName();
			this.health = jarya.getHealth();
			this.physicalAtk = jarya.getAttackDesc();
			Gameplay.count += 1;

	}
	
	public void pickPlayableDitsu() {
		Ditsu_Char ditsu = new Ditsu_Char();
			this.attack = ditsu.getAttack();
			this.special = ditsu.getSpecial();
			this.specialAtk = ditsu.getSpecialAtk();
			this.name = ditsu.getName();
			this.health = ditsu.getHealth();
			this.physicalAtk = ditsu.getAttackDesc();
			Gameplay.count += 1;

	}

	public void setSpecial(){
		int damage = bulletRain();
		this.special = damage;
	}

	
	
	
}
