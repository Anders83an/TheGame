package main;

import java.util.Scanner;

import monsters.*;

public class Game {

	// Keeps track of when we should abort main loop
	private boolean lostGame, wonGame;
	// Handles input
	private Scanner scan;
	// Keep track of current player 
	private IPlayer player;
	private Monster monster;
	
	/**
	 * Creates a new Game. Start it by calling startGame()
	 */
	public Game() {
		scan = new Scanner(System.in);
	}
	
	public void startGame() {
		System.out.println("****************************************");
		System.out.println("*         Welcome to The Game!         *");     
		System.out.println("****************************************");
		System.out.print("Enter your character name: ");
		String namn = scan.nextLine();
		player = new Player(namn);
		monster = new Monster();
		// TODO create a new player using name,
		// and assign to our instance variable!
		
		
		
		int input;
		while (!wonGame && !lostGame) {
			printMainMenu();
			System.out.print("> ");
			input = scan.nextInt();
			scan.nextLine();
			switch(input) {
				case 1:
					goAdventure();
					break;
				case 2:
					goCharacter();
					break;
				case 3:
					System.out.println("To bad you are leaving us " +namn + " ,Bye!");
					lostGame = true;
					break;
			}
		}
	
		if (wonGame) {
			System.out.println("Congratulations! You won The Game!");
		}

	}
	
	/**
	 * Prints all menu options
	 */
	private void printMainMenu() {
		System.out.println("****************************************");
		System.out.println("What would you like to do next?");
		System.out.println("1. Go adventuring");
		System.out.println("2. Show details about your character");
		System.out.println("3. Exit game");
		System.out.println("****************************************");
	}
	
	/**
	 * First menu option - fighting monsters
	 */
	private void goAdventure() {
		/* TODO first menu option. May result in:
		 * 1. nothing
		 * 2. battle with random monster
		 * based on randomness
		 */
		boolean chance = RandomHelper.getBigChance();
		
		if (chance == true) { 
			System.out.println("You found a monster behind the bushes! You prepare to fight the " + monster.getName() + "! ");
			battle(monster);
		} 
		else if (chance == false){
			
			System.out.println("Nothing important happens...");
			System.out.println("So you keep walking and looking on the nice surrondings.");
			
		}
		
		pause();
		
		
	}
	
	/**
	 * Initiates a battle between the player and the given monster
	 * @param monster - the monster to fight
	 */
	private void battle(IMonster monster) {
		/* TODO
		 * simulate a battle.
		 * Must also handle all side effects, like death, leveling up to 10 and so on 
		 */
		int monsterNewHp = monster.getHp();
		int playerNewHp = player.getHp();
		
		while (monsterNewHp >= 0 && playerNewHp >= 0) {
			int playerDamage = player.attack(); 
			int monsterDamage = monster.attack();
			monsterNewHp = monsterNewHp - playerDamage;
			playerNewHp = playerNewHp - monsterDamage;
			playerNewHp = player.getHp() - monster.attack();
			System.out.println("You swing your spear and hit the " + monster.getName() + " with " + playerDamage + " damage.");
			System.out.println("The " + monster.getName() + " hit you back for " + monsterDamage + " damage.");
			
			if (monsterNewHp > 0) {
				System.out.println(monster.getName() + "'s health is now " + monsterNewHp );
			}
			else {
				System.out.println(monster.getName() + " has 0 health left and is now dead.");
			}
			if (playerNewHp > 0) {
				System.out.println(player.getNamn() + " health is now " + playerNewHp);
			}
			else {
				System.out.println(player.getNamn() + " has 0 health left and is now dead, sorry!" );
			}
			pause();
			if (monsterNewHp <= 0) {
				player.giveExp(monster.getExp());
				System.out.println(player.getNamn() + " get " + monster.getExp() + " Xp ");
			}
		}
		
		/*
		while (!monster.isDead()) {
			player.attack();
			System.out.println(player.attack());
			monster.takeDamage(0);
			/*
			if (player.attack() > monster.getHp()) {
				player.getExp()
			}
			monster.attack();
			player.takeDamage(damage);
			if (monster.attack() > player.getHp()) {
				player.isDead(lostGame);
			}
			System.out.println(player.getHp());
			System.out.println(monster.getHp());
			
		}
		*/
	}
	
	/**
	 * Second menu option - show details about character
	 */
	private void goCharacter() {
		// TODO print player
		System.out.println("****************************************");
		System.out.println("* Character name: " + player.getNamn() );
		System.out.println("* Level: " + player.getLevel() );
		System.out.println("* HP: " + player.getHp() );
		System.out.println("* EXP: " + player.getExp() );
		System.out.println("****************************************");
		pause();
	}

	/**
	 * Pauses the game, waiting for an enter keypress
	 * Helper method
	 */
	private void pause() {
		System.out.println("");
		System.out.println("Press Enter to Continue");
		scan.nextLine();
	}
	
}
