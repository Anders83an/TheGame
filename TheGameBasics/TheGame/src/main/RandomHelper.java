package main;

import java.util.Random;

public class RandomHelper {
	
	public static boolean getBigChance() {
		Random random = new Random();
		boolean chance = (random.nextDouble()<0.7);
		return chance;
	
	}
	
	public static boolean get50Chance() {
		Random random = new Random();
		boolean chance = (random.nextDouble()<0.5);
		return chance;
		
	}
	
	public static int getInt(int lowNumber, int maxNumber) {
		Random random = new Random();
		int slumpat = random.nextInt(maxNumber - lowNumber) + lowNumber;
		return slumpat;
	}
	
}
