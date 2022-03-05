package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public final class Client {

	public static void main(String[] pArgs)
	{
		Deck deck = new Deck(new StandardDeck());
		
		List<Card> someCards = new ArrayList<>();
		someCards.add(deck.draw());
		someCards.add(deck.draw());
		someCards.add(deck.draw());
		
		print(deck);
	}

	public static void print(Iterable<Card> pCards) {
		int index = 1;
		for(Card card : pCards) {
			System.out.println(index++ + ": " + card);
		}
		
		
//		Iterator<Card> iterator = pCards.iterator();
//		while(iterator.hasNext()) {
//			Card card = iterator.next();
//			System.out.println(index++ + ": " + card);
//		}
		
	}
	
	private Client() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
