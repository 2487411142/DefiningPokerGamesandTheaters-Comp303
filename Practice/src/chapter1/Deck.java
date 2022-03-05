package chapter1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Deck implements Iterable<Card> {
	
	private List<Card> aCards = new ArrayList<>();
	
	private static final Suit[] COPY_OF_NORMAL_SUIT = 
			Arrays.copyOfRange(Suit.values(), 0, 4);
	private static final Rank[] COPY_OF_NORMAL_RANK = 
			Arrays.copyOfRange(Rank.values(), 0, 13);
	
	
	public Deck(CardValidator pValidator)
	{
		assert pValidator != null;
		for (Rank r : COPY_OF_NORMAL_RANK) {
			for (Suit s : COPY_OF_NORMAL_SUIT) {
				aCards.add(new Card(Joker.NOT, r, s));
			}
		}
		aCards.add(new Card(Joker.LOW, Rank.JOKER, Suit.JOKER));
		aCards.add(new Card(Joker.HIGH, Rank.JOKER, Suit.JOKER));
		Collections.shuffle(aCards);
		
		for (Card c : getCards()) {
			if (!pValidator.isValid(c)) {
				aCards.remove(c);
			}
		}
		
		
	}
	
	public Deck(Deck pDeck) {
		aCards = pDeck.aCards;
	}
	
	public List<Card> getCards (Deck pCards){
		List<Card> result = new ArrayList<>();
		for (Card c : pCards.aCards) {
			result.add(new Card(c));
		}
		return result;
	}
	
	public Card draw() {
		return aCards.remove(aCards.size() - 1);
	}
	
	public List<Card> getCards(){
		return new ArrayList<>(aCards);
		
	}
	
	public Iterator<Card> iterator(){
		return aCards.iterator();
	}
}
