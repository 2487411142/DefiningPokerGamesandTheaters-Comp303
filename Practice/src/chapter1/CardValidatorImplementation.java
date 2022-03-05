package chapter1;

public class CardValidatorImplementation implements CardValidator {
	public enum Config { STANDARD, ALL_RED, fACE_CARDS };
	
	private Config aConfig;
	
	public CardValidatorImplementation(Config pConfig) {
		aConfig = pConfig;
	}
	
	@Override
	public boolean isValid (Card pCard) {
		if (aConfig == Config.STANDARD) {
			return true;
		}
		else if (aConfig == Config.ALL_RED) {
			return !pCard.isBlack();
		}
		else {
			return pCard.getRank().ordinal() < Rank.JACK.ordinal();
		}
	}
}

class StandardDeck implements CardValidator{

	@Override
	public boolean isValid(Card pCard) {
		return true;
	}
	
}

class AllReds implements CardValidator{

	@Override
	public boolean isValid(Card pCard) {
		return !pCard.isBlack();
	}
	
}


class Faces implements CardValidator{

	@Override
	public boolean isValid(Card pCard) {
		return pCard.getRank().ordinal() >= Rank.JACK.ordinal();
	}
	
}