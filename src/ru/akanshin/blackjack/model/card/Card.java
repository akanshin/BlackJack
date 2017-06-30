package ru.akanshin.blackjack.model.card;

public class Card {
	
	public final static int heart = 0;
	public final static int spade = 1;
	public final static int diamond = 2;
	public final static int club = 3;
	
	public static String names[] = {"A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K"};

	private boolean faceup;
	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
		faceup = false;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public boolean isFaceup() {
		return faceup;
	}

	public void flip() {
		faceup = !faceup;
	}
	
	public void faceup() {
		faceup = true;
	}
	
	public void facedown() {
		faceup = false;
	}
	
	@Override
	public String toString() {
		if (this.isFaceup()) {
			String result = names[rank];
			switch (suit) {
			case heart:
				result += "\u2665";
				break;
			case spade:
				result += "\u2660";
				break;
			case diamond:
				result += "\u2666";
				break;
			case club:
				result += "\u2663";
				break;
			}
			return result;
		} else {
			return "XX";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
}
