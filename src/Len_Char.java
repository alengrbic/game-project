
public class Len_Char extends Character_Template {
	
	public Len_Char(String name) {
		
		this.name = name;
		this.health = 400;
		this.attack = 90;
		this.special = 130;
		
		
		this.physicalAtk = this.name + " slashes the target with the sword for " + getAttack() + " damage!";
		this.specialAtk = this.name + " strikes the target with a fireball for " + getSpecial() + " damage!";
	}
	
	
}
