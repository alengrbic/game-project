
import java.util.Random;

public abstract class Character_Template{
	
	Random random = new Random();
	String name;
	int health;
	int attack;
	int special;
	String description;
	
	//attacks & ablities desription
	
	String physicalAtk = "";
	String specialAtk = "";
	
	
	public int getAttack() {
		return this.attack;	
	}
	
	public String getName() {
		return this.name;
	}

	public int getHealth() {
		
		return this.health;
	}
	
	public int getSpecial() {
		return this.special;
	}
	
	public String getAttackDesc() {
		return this.physicalAtk;
	}

	public String getSpecialAtk() {
		// TODO Auto-generated method stub
		return this.specialAtk;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	
	public int bulletRain() {
		int damage = 0;
		int bulletsHit = random.nextInt(7);
		switch(bulletsHit) {
		case 0:
			damage = 20;
			
			break;
		case 1:
			damage = 40;
			
			break;
		case 2:
			damage = 60;
			
			break;
		case 3:
			damage = 85;
			
			break;
		case 4:
			damage = 100;
			
			break;
		case 5:
			damage = 120;
			
			break;
		case 6:
			damage = 150;
			
			break;
		}
		
		return damage;
	}
	
	public void setSP() {
		this.specialAtk = this.name + " shoots the target with the revolver, inflicting " + this.special + " damage!";
		
	}

	
	public int restore() {
		int num = 60;
		this.health += num;
		return num;
	}
	

		
	
};


	
	

