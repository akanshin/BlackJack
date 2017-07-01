package ru.akanshin.blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ConsoleView {
	
	private PrintStream out;
	private BufferedReader in;
	
	public ConsoleView() {
		try {
			out = new PrintStream(System.out, true, "UTF-8");
			in = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void print(String string) {
		out.println(string);
	}
	
	public String getAnswer(String question) {
		out.println(question);
		out.print(">");
		String line = "";
		try {
			line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	public int getIntAnswer(String question) {
		out.println(question);
		out.print(">");
		
		int n = -1;
		try {
			n = Integer.parseInt(in.readLine());
		} catch (NumberFormatException | IOException e) {
			return getIntAnswer("Please, enter the correct number");
		}
		return n;
	}
	
	public void pressEnter() {
		try {
			in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
