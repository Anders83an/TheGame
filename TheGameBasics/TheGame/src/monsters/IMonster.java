package monsters;

public interface IMonster {

	/**
	 * Tells the monster to attack
	 * @returns the damage of the attack
	 */
	int attack();

	/**
	 * Tells the monster to take damage.
	 * This reduces the monster's HP, and may result in it dying
	 * @param damage - amount of hp points to subtract from hp
	 */
	void takeDamage(int damage);

	/**
	 * Checks if this monster is dead or not.
	 * @return true if dead, false if alive
	 */
	boolean isDead();

	/**
	 * Returns the name of the monster
	 */
	String getName();
	
	/**
	 * Returns the current HP of the monster
	 */
	int getHp();

	/**
	 * Returns the amount of EXP points that the player should gain
	 * when s/he kills this monster
	 */
	int getExp();
}
