package ru.akanshin.blackjack.model.player;

import java.util.Random;

public class Bot extends Player {
	private static int id = 0;
	
	public Bot() {
		super("Bot" + id);
		id++;
	}
	
	@Override
	public boolean need() {
		Random random = new Random();
		int r = random.nextInt(1000);
		int score = pack.getScore();
		score -= 5;
		if (score <= 0) {
			return true;
		} else {
			double p = (double) score / 16.0 * 1000.0;
			if (r > p) {
				return true;
			} else {
				return false;
			}
		}
	}
}
