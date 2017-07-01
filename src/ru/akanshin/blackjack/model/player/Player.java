package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.*;

public abstract class Player {
	protected Pack pack;
	
	private String name;
	
	protected double money = 100.0;
	
	public double getMoney() {
		return money;
	}
	
	public double getBet(double bet) {
		money -= bet;
		return bet;
	}
	
	public void putMoney(double prize) {
		money += prize;
	}
	
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
	
	public int getScore() {
		return pack.getScore();
	}

	@Override
	public String toString() {
		String result = name + ") " + pack.toString();
		if (isBlackjack()) {
			result += " BLACKJACK!";
		}
		result += "\n  score=" + pack.getScore() + "\tmoney=" + money;
		return result;
	}
	
	public boolean isBlackjack() {
		return pack.isBlackjack();
	}
	
}
