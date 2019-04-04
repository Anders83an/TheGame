package main;

public interface IPlayer {
	
	/**
	 * Tells the player to attack
	 * @returns the damage of the attack
	 */
	int attack();

	/**
	 * Tells the player to take damage.
	 * This reduces the player's HP, and may result in him dying
	 * @param damage - amount of hp points to subtract from hp
	 */
	void takeDamage(int damage);

	/**
	 * Gives the player some experience.
	 * May level up the player, and may result in the player winning the game.
	 * @param newExp - the amount of exp to add to the player
	 */
	void giveExp(int newExp);
	
	/**
	 * Checks if this player is dead or not.
	 * @return true if dead, false if alive
	 */
	boolean isDead();

	/**
	 * Returns the current HP of the player
	 */
	int getHp();

	/**
	 * Returns the current EXP of the player
	 */
	int getExp();

	/**
	 * Returns the current level of the player
	 */
	int getLevel();
	
	
	String getNamn();

}
