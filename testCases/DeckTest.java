package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeck() {  //check size of deck
		Deck a = new Deck();
		int x =0;
		for(  Card b : a.deck) {
			x++;
		}
		assertEquals(x, 52 );
	}
	
	@Test
	void tesNumber() {
		Deck a = new Deck();
		assertEquals(a.deck.get(0).getNumber(), 1 );
	}
	void tessuit() {
		Deck a = new Deck();
		assertEquals(a.deck.get(0).getSuit(), Suit.Diamond );
	}
	
//	void testShuffle() {
//		Deck a = new Deck();
//		Integer a = a.deck.get(0).getNumber();
//		
//		assertNotEquals(a.deck.get(0).getSuit(), Suit.Diamond );
//
//
//	}
	
	

}
