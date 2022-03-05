package chapter1;

import static java.util.Arrays.asList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Pair implements Iterable<Card> {
	
	public static void main(String[] args) {
		
		Pair pair = new Pair(new Card(Joker.NOT, Rank.ACE, Suit.CLUBS), 
				new Card(Joker.NOT, Rank.ACE, Suit.DIAMONDS));
		
		for (Card card : pair) {
			System.out.println(card);
		}
//		
		Iterator<Card> iterator = pair.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}
	
	private Card aFirst;
	private Card aSecond;
	
	public Pair(Card pCard1, Card pCard2) {
		aFirst = pCard1;
		aSecond = pCard2;
	}
	
	public Card first() {
		return aFirst;
	}
	
	public Card second() {
		return aSecond;
	}
	
	@Override
	public Iterator<Card> iterator(){
		return new PairIterator(this);
	}
	
}

class PairIterator implements Iterator<Card>{
	
	private Queue<Card> aCards;
	
	public PairIterator(Pair pPair) {
		aCards = new LinkedList<>(asList(pPair.first(), pPair.second()));
	}
	
	@Override
	public boolean hasNext() {
		
		return !aCards.isEmpty();
	}

	@Override
	public Card next() {
		
		return aCards.remove();
	}
	
}