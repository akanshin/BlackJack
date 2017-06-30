package ru.akanshin.blackjack.model.player;

public class Human extends Player {
	public Human() {
		super("You");
	}
	
	@Override
	public boolean need() {
		
		return false;
	}

}
