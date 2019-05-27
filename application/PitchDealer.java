package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PitchDealer implements Dealer{
	private ArrayList<Card> dealNewCards = new ArrayList<Card>();
	private ArrayList<Card> dealNewCardsAI = new ArrayList<Card>();
	private ArrayList<Card> dealNewCardsAI2 = new ArrayList<Card>();
	private ArrayList<Card> dealNewCardsAI3 = new ArrayList<Card>();


	private Deck deckOfDealer;
	
	PitchDealer(){// constructor to initialize the Deck
		this.deckOfDealer = new Deck();
		//Collections.shuffle(deck.deck);// shuffles deck fo us
		deckOfDealer.shuffledeck();
		//dealNewCArds = new ArrayList<Card>(); //out new cards
	}

	@Override
	public ArrayList<Card> dealHand() {
		//Player player = new Player();
		for( int i =0 ; i < 6; i++) {
			dealNewCards.add(deckOfDealer.deck.get(i));
			//player.setHand(deck.get(i));
		}	
		deckOfDealer.deck.remove(0);
		deckOfDealer.deck.remove(0);
		deckOfDealer.deck.remove(0);
		deckOfDealer.deck.remove(0);
		deckOfDealer.deck.remove(0);
		deckOfDealer.deck.remove(0);	
		return dealNewCards;
	}
	public ArrayList<Card> dealHandAI() {
		//AIPlayer player = new AIPlayer();
		for( int i =0 ; i < 6; i++) {
			dealNewCardsAI.add(deckOfDealer.deck.get(i));
		}
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			//ArrayList<Card> temp = dealNewCardsAI;
			//dealNewCardsAI.removeAll(getHand());
			return dealNewCardsAI;
		}	
	public ArrayList<Card> dealHandAI2() {
		//AIPlayer player = new AIPlayer();
		for( int i =0 ; i < 6; i++) {
			dealNewCardsAI2.add(deckOfDealer.deck.get(i));
		}
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			//ArrayList<Card> temp = dealNewCardsAI;
			//dealNewCardsAI.removeAll(getHand());
			return dealNewCardsAI2;
		}	
	public ArrayList<Card> dealHandAI3() {
		//AIPlayer player = new AIPlayer();
		for( int i =0 ; i < 6; i++) {
			dealNewCardsAI3.add(deckOfDealer.deck.get(i));
		}
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			deckOfDealer.deck.remove(0);
			//ArrayList<Card> temp = dealNewCardsAI;
			//dealNewCardsAI.removeAll(getHand());
			return dealNewCardsAI3;
		}	

	
	public ArrayList<Card> getHand() {
		return dealNewCards;
	}
	
//	public void setHand(ArrayList<Card> newHands) {
//		this.dealNewCards = newHands;
//	}
//	public void setHandAI(ArrayList<Card> newHands) {
//		this.dealNewCardsAI = newHands;
//	}
}
