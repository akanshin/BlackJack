package ru.akanshin.blackjack.controller;

import ru.akanshin.blackjack.model.Game;
import ru.akanshin.blackjack.view.ConsoleView;

public class GameController {

	public static void main(String[] args) {
		GameController.getInstance().viewMessage("Welcome to minimal Blackjack game (console version)\n");
		int bots = -1;
		
		GameController.getInstance().viewMessage("Press enter");
		GameController.getInstance().getView().pressEnter();
		
		bots = GameController.getInstance().getView().getIntAnswer("Enter the number of bots");

		
		GameController.getInstance().setGame(bots);

//		try {
			while (true) {
				boolean result = GameController.getInstance().getGame().game();
				if (result) {
					if (GameController.getInstance().getAnswer("Do you want to continue the game?")) {
						continue;
					} else {
						GameController.getInstance().viewMessage("Thanks for game!");
						System.exit(0);
					}
				} else {
					GameController.getInstance().viewMessage("Thanks for game!");
					System.exit(0);
				}
			}
//		} catch (Exception e) {
//			GameController.getInstance().viewMessage(e.getMessage());
//		}
	}

	private static GameController instance = null;

	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private ConsoleView view;
	private Game game;

	public GameController() {
		view = new ConsoleView();
	}

	public void setGame(int bots) {
		game = new Game(bots);
	}

	public ConsoleView getView() {
		return view;
	}

	public Game getGame() {
		return game;
	}

	public void refreshView() {
		view.print(game.toString());
	}

	public void viewMessage(String message) {
		view.print(message);
	}

	public boolean getAnswer(String question) {
		String result = view.getAnswer(question + " (y/n)");
		if (result.equals("y")) {
			return true;
		} else if (result.equals("n")) {
			return false;
		} else {
			return getAnswer("");
		}
	}
}
