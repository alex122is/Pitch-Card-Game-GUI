package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {
/*
	@Test
	void testSetSuit() {
		
	}*/

	@Test
	void testGetSuit() {
		Card a = new Card(Suit.Clubs, 5);
		assertEquals(a.getSuit().toString(), "Clubs");
	}

	@Test
	void testSetSuit() {
		Card a = new Card(Suit.Clubs, 5);
		a.setSuit(Suit.Clubs);
		assertEquals(a.getSuit().toString(), "Clubs");
	}

	@Test
	void testGetNumber() {
		
		Card a = new Card(Suit.Clubs, 5);		
		a.getNumber();
		assertEquals(a.getNumber(), 5);

	}

	@Test
	void testToString() {
		Card a = new Card(Suit.Clubs, 5);
		assertEquals(a.getSuit().toString(), "Clubs");

	}
	

}
