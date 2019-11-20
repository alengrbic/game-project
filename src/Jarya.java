import java.util.Random;

public class Jarya extends Character_Template {
	
	Random random = new Random();
	
	
	public Jarya(String name) {
		
		this.name = name;
		this.health = 500;
		this.attack = 40;
		this.special = bulletRain();
		this.physicalAtk = this.name + " throws a knife at the target, inflicting " + getAttack() + " damage!";
		this.specialAtk = this.name + " shoots the target with the revolver, inflicting " + getSpecial() + " damage!";
	}
	
	

	

	
	
		



	
	
	
}
