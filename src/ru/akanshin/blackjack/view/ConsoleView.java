package ru.akanshin.blackjack.view;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import ru.akanshin.blackjack.model.card.Pack;

public class ConsoleView {
	
	private PrintStream console;
	
	public ConsoleView() {
		try {
			console = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void printPack(Pack pack) {
		console.println(pack.toString());
	}
}
