package chapter1;

public class Card implements Comparable<Card> {
	
	private Rank aRank;
	private Suit aSuit;
	private Joker aJoker;
	private Color aColor;
	
	
	/**
	 * @param pJoker
	 * @param pRank
	 * @param pSuit
	 * @pre pJoker != null && pRank != null && pSuit != null
	 */
	public Card(Joker pJoker, Rank pRank, Suit pSuit) {
		assert pJoker != null && pRank != null && pSuit != null;
		aJoker = pJoker;
		aRank = pRank;
		aSuit = pSuit;
		if (pJoker == Joker.HIGH) {
			aColor = Color.RED;
		}
		else if(pJoker == Joker.LOW) {
			aColor = Color.BLACK;
		}
		else {
			if (aSuit == Suit.HEARTS || aSuit == Suit.DIAMONDS) {
				aColor = Color.RED;
			}
			else {
				aColor = Color.BLACK;
			}
		}
	}
	
	public Card(Card pCard) {
		aJoker = pCard.aJoker;
		aRank = pCard.aRank;
		aSuit = pCard.aSuit;
		aColor = pCard.aColor;
	}
	
	public Rank getRank() {
		return aRank;
	}
	
	public Suit getSuit() {
		return aSuit;
	}
	
	public Color getColor() {
		return aColor;
	}
	
	public boolean isBlack() {
		return aColor == Color.BLACK;
	}
	
	public int getId(){
		if (this.aRank == Rank.JOKER) {
			if (this.aJoker == Joker.HIGH) {
				return 53;
			}
			else {
				return 52;
			}
		}
		else {
			return aSuit.ordinal() * 13 + aRank.ordinal();
		}
		
	}
	
	public String toString() {
		return aRank.toString() + " of " + aSuit.toString();
	}

	@Override
	public int compareTo(Card pCard) {
		
		return aRank.compareTo(pCard.aRank);
	}
	
}
