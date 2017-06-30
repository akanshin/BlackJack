package ru.akanshin.blackjack.controller;

import ru.akanshin.blackjack.model.Game;
import ru.akanshin.blackjack.view.ConsoleView;

public class GameController {
	public static void main(String[] args) {
		GameController controller = new GameController();
		
	}
	
	private ConsoleView view;
	private Game game;
	
	public GameController() {
		view = new ConsoleView();
		game = new Game(1);
		
		view.printPack(game.getPack());
	}
}
