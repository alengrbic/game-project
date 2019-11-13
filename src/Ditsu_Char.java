
public class Ditsu_Char extends Character_Template {
	
	public Ditsu_Char() {
		this.health = 400;
		this.attack = 40;
		this.special = 30;
		this.name = "Ditsu";
		
		this.physicalAtk = this.name + " blasts the target with strong wind, inflicting " + getAttack() + " damage!";
		this.specialAtk = this.name + " restores its health by " + restore() + "!";
	}
	

	
}