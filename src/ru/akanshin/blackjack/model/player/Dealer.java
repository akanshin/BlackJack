package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.Card;

public class Dealer extends Player {
	private boolean opened = false;
	
	public Dealer() {
		super("Dealer");
	}
	
	@Override
	public void put(Card card) {
		if (card != null) {
			if (pack.size() > 0) {
				card.facedown();
			} else {
				card.faceup();
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
	public String toString() {
		String result = this.getName() + ") " + pack.toString();
		if (opened) {
			result += "\t score = " + pack.getScore();
		}
		return result;
	}
}
