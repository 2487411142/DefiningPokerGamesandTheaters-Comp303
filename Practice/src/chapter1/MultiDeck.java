package chapter1;

import java.util.List;



import java.util.ArrayList;
import java.util.Collections;

public class MultiDeck {
	
	private List<Deck> aDecks = new ArrayList<>();
	
	/**
	 * @param pNumberOfDecks
	 * @pre pNumberOfDecks > 0
	 */
	public MultiDeck(int pNumberOfDecks) {
		assert pNumberOfDecks > 0;
		for (int i = 0; i < pNumberOfDecks; i++) {
			aDecks.add(new Deck(new CardValidatorImplementation(CardValidatorImplementation.Config.STANDARD)));
		}
	}
	
	public MultiDeck(MultiDeck pDecks) {
		aDecks = pDecks.aDecks;
	}
	
	public List<List<Card>> DeepCopy(MultiDeck pDecks){
		List<List<Card>> result = new ArrayList<>();
		for (Deck d : pDecks.aDecks) {
			result.add(d.getCards(d));
		}
		return result;
	}
}
