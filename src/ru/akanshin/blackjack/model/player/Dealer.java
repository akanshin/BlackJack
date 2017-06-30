package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.Card;

public class Dealer extends Player {
	public Dealer() {
		super();
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
}
