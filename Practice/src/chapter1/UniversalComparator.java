package chapter1;

import java.util.Comparator;

public class UniversalComparator implements Comparator<Hand>{
	
	public enum Order {ASCENDING, DESCENDING}
	
	private Order aOrder = Order.ASCENDING;
	
	public UniversalComparator() {
		
	}
	
	public UniversalComparator(Order pOrder) {
		aOrder = pOrder;
	}
	
	@Override
	public int compare(Hand pHand1, Hand pHand2) {
		if (aOrder == Order.ASCENDING) {
			return pHand1.size() - pHand2.size();
		}
		else {
			return pHand2.size() - pHand1.size();
		}
			
	}
	
	public void setOrder(Order pOrder) {
		aOrder = pOrder;
	}
	
	public static void main(String[] args)
	{
		Hand hand1 = new Hand(3);
		Hand hand2 = new Hand(3);
		hand1.add(new Card(Joker.NOT, Rank.ACE, Suit.CLUBS));
		UniversalComparator comparator = new UniversalComparator();
		System.out.println(comparator.compare(hand1, hand2));
		comparator.setOrder(Order.DESCENDING);
		System.out.println(comparator.compare(hand1, hand2));
	}
}
