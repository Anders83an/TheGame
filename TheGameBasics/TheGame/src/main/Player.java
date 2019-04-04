package main;

public class Player implements IPlayer{
	
	public String namn;
	public int level;
	public int hp = 200;
	public int exp = 0;
	
	
	public Player(String namn) {
		this.namn = namn;
		//this.level = level;
		//this.hp = hp;
		//this.exp = exp;
	}

	public String getNamn() {
		return namn;
	}


	
	public int attack() {
		int attackDamage = RandomHelper.getInt(10, 20);
		return attackDamage;
	}

	@Override
	public void takeDamage(int damage) {
		
		hp = hp - damage;
		return;
		
	}

	@Override
	public void giveExp(int newExp) {
		
		return;
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return hp;
	}

	@Override
	public int getExp() {
		
		return 0;
	}

	@Override
	public int getLevel() {
		level = 1;
		
		return level;
	}


	

}
