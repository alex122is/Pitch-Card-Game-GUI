package application;

import java.util.ArrayList;

public class Pitch implements DealType{

	private String Trump;
	private int trumpSet =0;
	private int trickNumber=0;
	private int pitcher=0;
	private int numPlayers;
	private int thebid=0;
	private int turn=0;
	private PitchDealer dealer;
	private ArrayList<Card> tableCards = new ArrayList<Card>(); //different trcik updstre 
	private ArrayList<Card> keyCardsWon;
	private ArrayList<Player> players ;
	private ArrayList<AIPlayer> aiPlayer;
	
	private int HumanPlayWent = 0;
	private int ComPla1Went = 0;
	private int ComPla2Went = 0;
	private int ComPla3Went = 0;


	
	public Dealer createDealer() {		
		PitchDealer dealer1 = new PitchDealer();
		this.dealer  = dealer1;
		return dealer;
	}
	Pitch(int numPlayers){  //will create the human player for us
		createDealer();// creates a Deck for us
		players = new ArrayList<Player> (); //Array to store players 
		Player player = new Player();
		player.setHand(dealer.dealHand());// put their hands on 
		players.add(player);
		System.out.println();

		
		//AIPlayer sendAI;
		
		aiPlayer = new ArrayList<AIPlayer>(); //this will create the computer players
		if(numPlayers >=2) {
			AIPlayer playerai = new AIPlayer();
			//playerai.getAIhand().clear();
			playerai.setAIhand(dealer.dealHandAI());
			//playerai.setAIhand(dealer.dealHandAI());// put their hands on 
			aiPlayer.add(playerai);
			System.out.println();
			
			System.out.println("we should be pushing");

		}
		
		if(numPlayers >=3) {
			AIPlayer playerai3 = new AIPlayer();
			playerai3.getAIhand().clear();
			playerai3.setAIhand(dealer.dealHandAI2());
			//playerai3.setAIhand(dealer.dealHandAI());// put their hands on 
			aiPlayer.add(playerai3);

		}if(numPlayers ==4) {

			AIPlayer playerai4 = new AIPlayer();
			playerai4.setAIhand(dealer.dealHandAI3());// put their hands on 
			aiPlayer.add(playerai4);

		}

	}
	
	
	public void FindTrump(int x) {
		if(x ==2) {
			
		}
		
	}
	

//	public Card makeCardString(String a) {
//		
//		return null;
//	}
	
	 public ArrayList<Player> retPlayer(){
		return players;
	}
	 public ArrayList<AIPlayer> retAIPlayer(){
			return aiPlayer;
		}
	void cardUpdate() {
		
		
	}
	
	public int getPitcher() {
		return pitcher;
	}
	public void setPitcher(int pitcher) {
		this.pitcher = pitcher;
	}
	public String getTrump() {
		return Trump;
	}
	public void setTrump(String trump) {
		Trump = trump;
	}
	public int getTrickNumber() {
		return trickNumber;
	}
	public void setTrickNumber(int trickNumber) {
		this.trickNumber = trickNumber;
	}
	public int getThebid() {
		return thebid;
	}
	public void setThebid(int thebid) {
		this.thebid = thebid;
	}
	public int getTurn() {
		return this.turn;
	}
	public void setTurn(int x) {
		this.turn = turn + x;
	}
	public void initTableCards(int x) {
		for(int i = 0; i< x; i++) {
			Card card = new Card(Suit.Diamond, 1);//init table cards
			tableCards.add(card);
		}
	}
	public ArrayList<Card> getTableCards() {
		return tableCards;
	}
	public void setTableCards(ArrayList<Card> tableCards) {
		this.tableCards = tableCards;
	}
	public void clearTableCards() {
		 tableCards.clear();

	}
	public void addTableCards(Card tableCards ) {
		this.tableCards.add( tableCards);
	}
	
	public ArrayList<Card> getKeyCardsWon() {
		return keyCardsWon;
	}
	public void setKeyCardsWon(ArrayList<Card> keyCardsWon) {
		this.keyCardsWon = keyCardsWon;
	}
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	public int getTrumpSet() {
		return trumpSet;
	}
	public void setTrumpSet(int trumpSet) {
		this.trumpSet = trumpSet;
	}
	public int getHumanPlayWent() {
		return HumanPlayWent;
	}
	public void setHumanPlayWent(int humanPlayWent) {
		HumanPlayWent = humanPlayWent;
	}
	public int getComPla1Went() {
		return ComPla1Went;
	}
	public void setComPla1Went(int comPla1Went) {
		ComPla1Went = comPla1Went;
	}
	public int getComPla2Went() {
		return ComPla2Went;
	}
	public void setComPla2Went(int comPla2Went) {
		ComPla2Went = comPla2Went;
	}
	public int getComPla3Went() {
		return ComPla3Went;
	}
	public void setComPla3Went(int comPla3Went) {
		ComPla3Went = comPla3Went;
	}
	
//	public String retTextBid(int x) {
//		String numStr= "error";
//
//		switch(x) {
//
//	case 2:
//		numStr = "2";
//		break;
//	case 3:
//		numStr= "3";
//		break;
//	case 4:
//		numStr= "4";
//		break;
//	
//	case 5:
//		numStr= "5";
//		break;
//	case 0:
//		numStr= "0";
//		break; 
//	}
//		return numStr;
//	}
	
	
	
}
