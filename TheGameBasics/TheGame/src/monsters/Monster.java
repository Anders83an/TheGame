package monsters;

import main.RandomHelper;

public class Monster implements IMonster{

	public String monsterNamn;
	public int monsterHp;
	
	
	public Monster() {
		this.monsterNamn = "Dragon";
		this.monsterHp = 50;
	}
	
	public int attack() {
		int attackDamage = RandomHelper.getInt(5, 10);
		return attackDamage;
	}

	@Override
	public void takeDamage(int damage) {
		monsterHp = monsterHp - damage;
		return;
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		
		return monsterNamn;
	}

	@Override
	public int getHp() {
		return monsterHp;
	}

	@Override
	public int getExp() {
		return 50;
	}

}
