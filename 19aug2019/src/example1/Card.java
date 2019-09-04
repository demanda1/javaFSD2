package example1;

public class Card {

	private Suit suit;
	private Rank rank;
	public Card() {
		// TODO Auto-generated constructor stub
		
	}
	public Card(Suit s, Rank r) {
		this.suit=s;
		this.rank=r;
	}
	
	public Suit suit() {
		return suit();
	}
	
	public Rank rank() {
		return rank();
	}
	
	@Override
	public String toString() { 
		return  "Card[suit= "+ suit +" rank ="+rank +"]";
	}

}
