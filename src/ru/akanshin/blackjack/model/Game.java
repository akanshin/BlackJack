package ru.akanshin.blackjack.model;

import java.util.ArrayList;

import ru.akanshin.blackjack.model.card.Pack;
import ru.akanshin.blackjack.model.player.Bot;
import ru.akanshin.blackjack.model.player.*;

public class Game {
	private Pack pack;
	int bots;
	
	private Player human;
	private Player dealer;
	private ArrayList<Player> botList;

	public Game(int bots) {
		this.bots = bots;
		
		human = new Human();
		dealer = new Dealer();
		botList = new ArrayList<Player>();
		
		for (int i = 0; i < this.bots; i++) {
			botList.add(new Bot());
		}
		
		pack = Pack.getFullPack();
		pack.shuffle();
	}
	
	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public int getBots() {
		return bots;
	}

	public void setBots(int bots) {
		this.bots = bots;
	}
}
