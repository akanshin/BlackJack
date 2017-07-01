package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.controller.GameController;

public class Human extends Player {
	public Human() {
		super("You");
	}
	
	@Override
	public boolean need() {
		if (this.getScore() > 20) {
			return false;
		}
		boolean result = GameController.getInstance().getAnswer("Your score " + this.getScore() + ". Do you need a card?");
		return result; 
	}

}
