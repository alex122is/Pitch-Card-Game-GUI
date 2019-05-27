package application;


import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>(); //the cards a player has
	
	private ArrayList<Card> won = new ArrayList<Card>(); //the cards a player has won
	
	private int id; //player id
	private int numPoints = 0;; //   current points a player has
	private int bid;//player bid
	private Card cardPlayed;
	private int hasPlayed = 0;
	private Card tableCard;
	private int turnWins = 0;

	
	
	
	void playHand() {// remove card from had and play it
		
	}
	void getPlayerId() {
		
	}
	void makebid(int bid) { // the game
		if( bid !=0 || bid!= 2 || bid != 3 || bid != 4) {
			
		}
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public ArrayList<Card> getWon() {
		return won;
	}
	public void setWon(ArrayList<Card> won) {
		this.won = won;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumPoints() {
		return numPoints;
	}
	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Card getCardPlayed() {
		return cardPlayed;
	}
	public void setCardPlayed(Card cardPlayed) {
		this.cardPlayed = cardPlayed;
	}
	public Card getTableCard() {
		return tableCard;
	}
	public void setTableCard(Card tableCard) {
		this.tableCard = tableCard;
	}
	public int getTurnWins() {
		return turnWins;
	}
	public void setTurnWins(int turnWins) {
		this.turnWins = turnWins;
	}
	
	
}