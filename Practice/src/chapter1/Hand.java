package chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand>, Iterable<Card> {
	
	private final List<Card> aCards = new ArrayList<>();
	private final int aMaxCards;
	
	/**
	 * @param pMaxCards
	 * @pre pMaxCards > 0
	 */
	public Hand(int pMaxCards) {
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * Add pCard to the hand.
	 * @param pCard The card to add.
	 * @pre !isFull()
	 * @pre pCard != null;
	 */
	public void add(Card pCard) {
		assert pCard != null;
		assert !isFull();
		aCards.add(pCard);
				
	}
	
	/**
	 * Remove pCard from the hand if it is in hand. Otherwise, do nothing.
	 * @param pCard The card to remove
	 * @pre pCard != null;
	 */
	public void remove(Card pCard) {
		assert pCard != null;
		aCards.remove(pCard);
	}
	
	/**
	 * @param pCard
	 * @return true if pCard exists in hand.
	 * @pre pCard != null;
	 */
	public boolean contains(Card pCard) {
		assert pCard != null;
		return aCards.contains(pCard);
	}
	
	public boolean isEmpty() {
		return aCards.size() == 0;
	}
	
	public boolean isFull() {
		return aCards.size() == aMaxCards;
	}
	
	public int size() {
		return aCards.size();
	}
	
	public List<Card> getCards(){
		return new ArrayList<>(aCards);
	}

	@Override
	public int compareTo(Hand pHand) {
		
		return aCards.size() - pHand.aCards.size();
	}
	
	public static Comparator<Hand> ByNumAscending(){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				return pHand1.aCards.size() - pHand2.aCards.size();
			}};
	}
	
	public static Comparator<Hand> ByNumDescending(){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				return pHand2.aCards.size() - pHand1.aCards.size();
			}};
	}
	
	public static Comparator<Hand> ByRankAscending(Rank pRank){
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				return count(pHand1, pRank) - count(pHand2, pRank);
			}
			
			private int count(Hand pHand, Rank pRank) {
				int total = 0;
				for (Card card : pHand.aCards) {
					if (card.getRank() == pRank) {
						total ++;
					}
				}
				return total;
			}
		
		};
	}

	

	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	
}
