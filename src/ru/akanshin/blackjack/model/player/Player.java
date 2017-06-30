package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.*;

public abstract class Player {
	protected Pack pack;
	
	public Player() {
		pack = new Pack();
	}
	
	public boolean need() {
		if (pack.getScore() > 16) {
			return false;
		}
		
		return true;
	}
	
	public void put(Card card) {
		
	}
	
	public Card get() {
		return pack.get();
	}
}
