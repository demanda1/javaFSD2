package example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shuffle {

	public Shuffle() {
		// TODO Auto-generated constructor stub
	}
	
	private static Suit suit;
	private static Rank rank;
	
	private static List<Card> shufflecard=new ArrayList<Card>();
	
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int numOfHands=s.nextInt();
		int numOfCards=s.nextInt();
		int range=12;
		int rangesuit=3;
		for(int i=0;i<numOfHands;i++) {
			for(int j=0;j<numOfCards;j++) {
				shufflecard.add(new Card(suit.values()[(int)(Math.random()*rangesuit +1)],rank.values()[(int)(Math.random()*range +1)]));
			}
			System.out.println(shufflecard);
			shufflecard.clear();
		}
	}

}
