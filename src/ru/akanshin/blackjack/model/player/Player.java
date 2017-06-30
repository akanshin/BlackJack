package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.*;

public abstract class Player {
	protected Pack pack;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		pack = new Pack();
		this.name = name;
	}
	
	public boolean need() {
		return false;
	}
	
	public void put(Card card) {
		if (card != null) {
			card.faceup();
			pack.put(card);
		}
	}
	
	public Card get() {
		return pack.get();
	}
	
	public void clear() {
		pack.clear();
	}

	@Override
	public String toString() {
		return name + ") " + pack.toString() + "\t score = " + pack.getScore();
	}
	
	
}
