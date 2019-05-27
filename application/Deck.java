package application;



import java.util.ArrayList;
import java.util.Collections;

enum Suit { Diamond,Heart, Clubs, Spades }

public class Deck {
	
	ArrayList<Card> deck = new ArrayList<Card>();
	
	Deck(){
		for(int x = 0; x <4; x++) {
			for(int y = 1 ; y <= 13 ; y++) {
				if(x ==0) {
					Card card = new Card(Suit.Diamond, y);
					deck.add(card);
				}
				else if ( x == 1) {
					Card card = new Card(Suit.Heart, y);
					deck.add(card);
				}
				else if( x == 2) {
					Card card = new Card(Suit.Clubs, y);
					deck.add(card);
				
				}
				else if( x == 3) {
					Card card = new Card(Suit.Spades, y);
					deck.add(card);
				}					
				
			}
		}
	}
	void shuffledeck() {
		Collections.shuffle(deck);
	}



 
}