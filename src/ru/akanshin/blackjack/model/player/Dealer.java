package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.Card;

public class Dealer extends Player {
	private boolean opened = false;
	
	public Dealer() {
		super("Dealer");
		money = 1000.0;
	}
	
	@Override
	public void put(Card card) {
		if (card != null) {
			if (pack.size() > 0) {
				card.faceup();
			} else {
				card.facedown();
			}
			pack.put(card);
		}
	}
	
	@Override
	public boolean need() {
		if (pack.getScore() > 17) {
			return false;
		}
		return true;
	}
	
	public void open() {
		opened = true;
		pack.flipAll(true);
	}
	@Override
	public void clear() {
		super.clear();
		opened = false;
	}

	@Override
	public String toString() {
		String result = this.getName() + ") " + pack.toString();
		if (isBlackjack()) {
			result += " BLACKJACK!";
		}
		
		result += "\n score=";
		if (opened) {
			result += pack.getScore();
		} else {
			result += "??";
		}
		result += "\tmoney=" + money;
		return result;
	}
}
