import java.util.Random;

public class Boss1 {
	String name;
	int health;
	int attack;
	Random random = new Random();
	String attackDescription;
	String specialDescription;
	
	public Boss1() {
		this.name = "Testomaniac";
		this.health = 700;
		this.attack = 40;	
		this.attackDescription = this.name + " smashes the target for " + this.chosenAttack() + " damage!";
		this.specialDescription = this.name + " throws a magical hammer at the target, inflicting " + bossAttackSpecial() + " damage!";
	}
	
	public int getBossHealth() {
		
		return this.health;
		
	}
	
	public void setBossHealth(int health) {
		
		this.health = health;
		
	}
	
	public int bossAttack() {
		//first
		int damage = this.attack;
		return damage;
	}
	
	public int bossAttackSpecial() {
		//second
		int damage = 110;
		return damage;
	}
	
	public int bossAttackThird() {
		int damage = 50;
		return damage;
	}
	
	public int randomChoice() {
		int choice = random.nextInt(3);
		return choice;
	}
	
	public int chosenAttack() {
		//method for randomizing boss attack
		int choice = this.randomChoice();
		int damage = 0;
		switch(choice) {
		case 0:
			damage = this.bossAttack();
			break;
		case 1:
			damage = this.bossAttackSpecial();
			break;
		case 2:
			damage = this.bossAttackThird();
			break;
		}
		return damage;
	}
	
	
}
