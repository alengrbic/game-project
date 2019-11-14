
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
			this.description = "A warrior from far away land, utilizing his exceptional speed to fight foes.";
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
			this.description = "A fearless gunslinger, specializing in handguns and revolvers.";
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
			this.description = "A shaman who learned to control elements, looking for revenge against those who wronged him.";
			Gameplay.count += 1;

	}

	public void setSpecial(){
		int damage = bulletRain();
		this.special = damage;
	}

	
	
	
}
