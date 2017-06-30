package ru.akanshin.blackjack.model.card;

import java.util.ArrayList;
import java.util.Collections;

public class Pack {
	private ArrayList<Card> list;
	
	public Pack() {
		list = new ArrayList<Card>();
	}
	
	public Card get() {
		if (list.size() == 0) {
			return null;
		} else {
			return list.remove(list.size() - 1);
		}
	}
	
	public void put(Card card) {
		if (card != null) {
			for (Card c : list) {
				if (c.equals(card)) {
					return;
				}
			}
			list.add(0, card);
		}
	}
	
	public static Pack getFullPack() {
		Pack pack = new Pack();		
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				pack.put(new Card(rank, suit));
			}
		}
		return pack;
	}
	
	public void shuffle() {
		Collections.shuffle(list);
	}
	
	public int getScore() {
		int score = 0;
		int aces = 0;
		
		for (Card c : list) {
			if (c.getRank() == 0) {
				aces++;
			} else {
				int rank = c.getRank();
				if (rank > 0 && rank < 10) {
					score += rank + 1;
				} else if (rank >= 10) {
					score += 10;
				}
			}
		}
		
		while (aces > 0) {
			if (score + 11 > 21) {
				score += 1;
			} else {
				score += 11;
			}
			aces--;
		}
		
		return score;
	}

	@Override
	public String toString() {
		String result = "";
		for (Card c : list) {
			result += c.toString() + " ";
		}
		return result;
	}
	
	public void flipAll(boolean faceup) {
		for (Card c : list) {
			if (c.isFaceup() != faceup) {
				c.flip();
			}
		}
	}
	
	public void flip(int index) {
		if (index >= 0 && index < list.size()) {
			list.get(index).flip();
		}
	}
	
	public int size() {
		return list.size();
	}
}
