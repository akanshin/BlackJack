package ru.akanshin.blackjack.model;

import java.util.ArrayList;

import ru.akanshin.blackjack.controller.GameController;
import ru.akanshin.blackjack.model.card.Pack;
import ru.akanshin.blackjack.model.player.*;

public class Game {
	private int round = 1;

	private Pack pack;
	int bots;

	private ArrayList<Player> playerList;
	private ArrayList<Player> winners;
	private ArrayList<Player> losers;
	private Dealer dealer;
	private Human human;

	private double bank = 0;

	public static final double bet = 10;

	public Game(int bots) {
		this.bots = bots;
		if (this.bots < 0) {
			this.bots = 0;
		}

		playerList = new ArrayList<Player>();
		winners = new ArrayList<Player>();
		losers = new ArrayList<Player>();

		playerList.add(human = new Human());
		for (int i = 0; i < this.bots; i++) {
			playerList.add(new Bot());
		}
		playerList.add(dealer = new Dealer());
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

	@Override
	public String toString() {
		String result = "bank=" + bank + "\n\n";
		for (Player p : playerList) {
			result += p.toString();
			result += "\n";
		}
		if (!winners.isEmpty()) {
			result += "\nwinners: ";
			for (int i = 0; i < winners.size(); i++) {
				result += winners.get(i).getName();
				if (i < winners.size() - 1) {
					result += ", ";
				} else {
					result += "\n";
				}
			}
		}
		return result;
	}

	public boolean game() {
		pack = Pack.getFullPack();
		pack.shuffle();

		winners.clear();
		bank = 0;
		
		for (Player p : playerList) {
			p.clear();
			if (p.getMoney() < bet) {
				playerList.remove(p);
				losers.add(p);

				if (p == human) {
					GameController.getInstance().viewMessage("You lose");
					return false;
				}
			} else {
				bank += p.getBet(bet);
			}
		}
		
		GameController.getInstance().viewMessage("\nRound " + round++);

		for (int i = 0; i < 2; i++) {
			for (Player p : playerList) {
				if (pack.size() > 0) {
					p.put(pack.get());
				}
			}
		}

		for (Player p : playerList) {
			if (p.isBlackjack()) {
				winners.add(p);
				if (p == dealer) {
					dealer.open();
				}
			}

		}

		GameController.getInstance().refreshView();

		if (!winners.isEmpty()) {
			for (Player p : winners) {
				p.putMoney(bank / (double) winners.size());
			}

			return true;
		}

		for (Player p : playerList) {
			while (p.need()) {
				if (pack.size() > 0) {
					p.put(pack.get());
				}
			}
			if (p.getScore() == 21) {
				winners.add(p);
			}
		}

		if (!winners.isEmpty()) {
			if (winners.size() > 1 && winners.contains(dealer)) {
				winners.remove(dealer);
			}
			for (Player p : winners) {
				p.putMoney(bank / (double) winners.size());
			}
		
			dealer.open();
			GameController.getInstance().refreshView();
			return true;
		} else {
			int maxScore = 0;
			
			for (Player p : playerList) {
				int score = p.getScore();
				if (score < 22 && score > maxScore) {
					maxScore = score;
				}
			}
			for (Player p : playerList) {
				if (p.getScore() == maxScore) {
					winners.add(p);
				}
			}
			
			for (Player p : winners) {
				p.putMoney(bank / (double) winners.size());
			}
			
			dealer.open();
			GameController.getInstance().refreshView();
			return true;
		}
	}
}
