package ru.akanshin.blackjack.controller;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import ru.akanshin.blackjack.model.card.Card;

public class Controller {
	public static void main(String[] args) throws UnsupportedEncodingException {
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		char c = 0;
		for (int i = 0; i < 256; i++) {
			out.println(i + ") " + c);
			c++;
		}
	}
}
