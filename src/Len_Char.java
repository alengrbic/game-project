
public class Len_Char extends Character_Template {
	
	public Len_Char() {
		this.health = 400;
		this.attack = 80;
		this.special = 120;
		this.name = "Len";
		
		this.physicalAtk = this.name + " slashes the target with the sword for " + getAttack() + " damage!";
		this.specialAtk = this.name + " strikes the target with a fireball for " + getSpecial() + " damage!";
	}
	
	
}
