package ru.akanshin.blackjack.model.player;

import ru.akanshin.blackjack.model.card.Card;

public class Human extends Player {
	public Human() {
		super();
	}
	
	@Override
	public void put(Card card) {
		if (card != null) {
			card.faceup();
			pack.put(card);
		}
	}
}
