package application;


import java.util.ArrayList;
import java.util.Collections;

public class AIPlayer extends Player {
private ArrayList<Card> AIhand = new ArrayList<Card>(); //the cards a player has
	
	private ArrayList<Card> AIwon = new ArrayList<Card>(); //the cards a player has won
	private int AIid; //player id
	private int AInumPoints; //   current points a player has
	private int AIbid;//player bid
	private Card AIcardPlayed = null;
	private Card deternmineTrump;
	private int hasPlayed = 0;
	private int turnAIWins = 0;

//	AIPlayer(ArrayList<Card> x) {
//		setAIhand(x);
//	}
	
	 void makeAIbid() {

		int counter =0;
		for( Card a :AIhand) {
		if(a.toStringAI()== "Ace" ) {counter++;}
	    if(a.toStringAI()== "two" ) {counter++;}
		if(a.toStringAI()== "three") {counter++;}
		if(counter ==3) {
			this.setAIbid(2);
			return;
		}
		}
		counter=0;
		for( Card a2 :AIhand) {
			if(a2.toStringAI()== "Ace"|| a2.toStringAI() == "King") {counter++;}
		    if(a2.toStringAI()== "king"|| a2.toStringAI()== "Jack") {counter++;}
			if(a2.toStringAI()== "two"|| a2.toStringAI()== "three") {counter++;}
			if(a2.toStringAI()== "Four"|| a2.toStringAI()== "Five") {counter++;}

			if(counter ==3 ) {
				this.setAIbid(3);
				return;
			}
		}
		counter=0;
		for( Card a2 :AIhand) {
			if(a2.toStringAI()== "Ace") {counter++;}
		    if(a2.toStringAI()== "king") {counter++;}
			if(a2.toStringAI()== "10" || a2.toStringAI()== "Queen") {counter++;}
			if(a2.toStringAI()== "Queen") {counter++;}
			if(a2.toStringAI()== "2" || a2.toStringAI()== "Jack") {counter++;}
			if(a2.toStringAI()== "Jack" || a2.toStringAI()== "ten") {counter++;}

			if(counter >= 4) {
				this.setAIbid(4);
				return;
			}
		}
		counter=0;
		for( Card a2 :AIhand) {
			if(a2.toStringAI()== "Ace") {counter++;}
		    if(a2.toStringAI()== "king") {counter++;}
			if(a2.toStringAI()== "10" || a2.toStringAI()== "Queen") {counter++;}
			if(a2.toStringAI()== "Queen" || a2.toStringAI()== "King") {counter++;}
			if(a2.toStringAI()== "King" || a2.toStringAI()== "Jack") {counter++;}
			if(a2.toStringAI()== "Jack" || a2.toStringAI()== "ten") {counter++;}
			if(a2.toStringAI()== "two" || a2.toStringAI()== "three") {counter++;}

			if(counter >= 5) {
				this.setAIbid(5);
				return;
			}
		}
		
		this.setAIbid(0);// we reached then bid pass 
		
	}
	ArrayList<Integer> sortSuit = new ArrayList<Integer>(); //to sort wining bid

	private Card setAIcardPlayed;
	
	//will declare a trump card and play first card, deduct the card form the player that picked the trump card
public  Card declareTrumpCard(Pitch Hold) {
	int counter  =0;
	int t=0;
	int x=0;
	Card chosenCard =null;
	for(Card a :AIhand) {
		if (a == null) {
			t++;
			continue;
		}
		if(a.getNumber()==1) {
			this.AIcardPlayed = a;
			this.AIhand.set(t, null);
			
			Hold.setTrump(a.toString());
			Hold.setTrumpSet(1);
			
			return a;
		}
		else if(a.getNumber() >= counter) {
				x++;
				System.out.println(a.getNumber());
				System.out.println(counter);
				chosenCard = a;
				counter = a.getNumber();
			}	
		t++;
		}
	System.out.println("settong trump");
	System.out.println(t);
	System.out.println(chosenCard);

	for(Card a :AIhand) {
		if (a == null) {
			t++;
			continue;
		}
		System.out.println(a);
	}
	
	System.out.println("the cards");
	setAIcardPlayed(chosenCard);
	System.out.println(t);

	this.AIhand.set(x, null);
	Hold.setTrump(chosenCard.toString());
	Hold.setTrumpSet(1);
	return chosenCard;
	
		
	/*	int diamond=0;
		int spades =0;
		int heart = 0;
		int clubs =0;
		for(Card a :AIhand) {
			if (a == null) {
				continue;
			}
			System.out.println(a.getSuit().toString());
			if(a.getSuit().toString()=="Heart") {heart++;}
			if(a.getSuit().toString()=="Diamond") {diamond++;}  
			if(a.getSuit().toString()=="Clubs") {clubs++;}
			if(a.getSuit().toString()=="Spades") {spades++;}
			
			
		}	
		sortSuit.add(diamond);
		sortSuit.add(spades);
		sortSuit.add(heart);
		sortSuit.add(clubs);
		Collections.sort(sortSuit,Collections.reverseOrder());
		System.out.println("the most suits");
		System.out.println("looks here++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("looks here++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("looks here++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("looks here++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("looks here++++++++++++++++++++++++++++++++++++++++++++++++++");
		//System.out.println(sortSuit.get(0).);
		if (sortSuit.get(0) == diamond) {//pick the first Trump card

			int t=0;
			for(Card a :AIhand) {
				if(a == null) {
					t++;
					continue;
				}
				//if(a.getSuit().toString()=="Diamond") {

				if(a.toStringSuit()=="Diamond") {
					Card temp =a;
					this.AIcardPlayed = temp;
					this.AIhand.set(t, null);
					Hold.setTrump(temp.toString());
					Hold.setTrumpSet(1);
					sortSuitclear();

					return temp;
					}
				t++;
			}	
		}
		if (sortSuit.get(0) == spades) {//pick the first Trump card
			int t=0;
			for(Card a :AIhand) {
				if(a == null) {
					t++;
					continue;
				}
				if(a.toStringSuit().equals("Spades")) {
					Card temp =a;
					this.AIcardPlayed = temp;

					this.AIhand.set(t,null);
					Hold.setTrump(temp.toString());
					Hold.setTrumpSet(1);
					sortSuitclear();

					return temp;
					}	
				t++;
			}	
		}if (sortSuit.get(0) == heart) {//pick the first Trump card
			int t =0;
			for(Card a :AIhand) {
				if(a == null) {
					t++;
					continue;
				}
				if(a.toStringSuit().equals("Heart")) {
					Card temp =a;
					this.AIcardPlayed = temp;
					this.AIhand.set(t, null);
					Hold.setTrump(temp.toString());
					Hold.setTrumpSet(1);
					sortSuitclear();

		
					return temp;
					}	
				t++;
			}	
		}if (sortSuit.get(0) == clubs) {//pick the first Trump card
			int t =0;
			for(Card a :AIhand) {
				if(a == null) {
					t++;
					continue;
				}

				if(a.toStringSuit().equals("Clubs")) {
					Card temp =a;
					this.AIcardPlayed = temp;
					this.AIhand.set(t,null);
					Hold.setTrump(temp.toString());
					Hold.setTrumpSet(1);
					sortSuitclear();
					return temp;
					}
				t++;
			}	
		}*/
		
		
		
		//System.out.println("errror should not be geetting here");
		//return null;
	
	

	
	
	
	}
	
	public Card playAICard(ArrayList<Card> x, String trump) {
//============================================================================================================//
		ArrayList<Card> deternHigh = new ArrayList<Card>();//go through the computers hand and look for trumps
		int record =-1; //to determine if we have any trump card
	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		for(Card a :AIhand) {
			if(a == null ) {
				continue;
			}
			if((a.getSuit().toString()).equals(trump)) {
				deternHigh.add(a);
				record++;
			}
		} 
		Card chosenCard = null;

		if(record>=0) {
		int counter =2;
		Card b;
		for( Card a: deternHigh) {   // determine the highest available number trump card
			if(a == null) {
				continue;
			}
			if(a.getNumber() == 1) {
				chosenCard = a;
				break;
			}
			
			else if(a.getNumber() >= counter) {
				
				System.out.println(a.getNumber());
				System.out.println(counter);

				chosenCard = a;
				counter = a.getNumber();
			}	
		}
		int t =0;

		
		for(Card a :AIhand) {	//now delete it from the computers hand send that card back
			if( a == null) {
				t++;

				continue;
			}
			if(a.equals(chosenCard)) {
				System.out.println("we should be removing evey ai card played=======================================");
				Card temp;
				System.out.println("what should be removed");
				temp = chosenCard;
				System.out.println(temp);
				this.AIcardPlayed = temp;
				this.AIhand.set(t,null);
				System.out.println(temp.toString());
				System.out.println("what is beign removed");
				//System.out.println(this.AIhand.get(t));
				sortSuitclear();
				return temp;
			}
			t++;
		}
		}
		else {
//================================================================================================================//		
		//look for the Highest card number the computer has and play it

		int counter = 2; //the lowest card number
		for(Card a :AIhand) {	
			if(a == null) {
				continue;
			}
			if(a.getNumber() == 1) {
				chosenCard = a;
				break;
			}
			else if(a.getNumber()>=counter) {
				chosenCard = a;
				counter = a.getNumber(); 
			}
		}
		int t =0;
		for(Card a :AIhand) {	//know delete it from the computers and send that card back
			if(a == null) {
				t++;
				continue;
			}
			if(a.toString().equals(chosenCard.toString())) {
				Card temp;
				temp = chosenCard;
				this.AIcardPlayed = temp;
				this.setAIcardPlayed= temp;
				this.AIhand.set(t,null);
				sortSuitclear();
				return temp;
			}
			t++;
		}
		}
		System.out.println("should not be getting here");
		return null;
		
	}

	
	
	
	void  playAIHand() {
		for(Card a :AIhand) {
			if(a == null) {
				continue;
			}
			System.out.println(a.toString());
		}
	}
	public void sortSuitclear() {
		this.sortSuit.clear();
	}
	public ArrayList<Card> getAIhand() {
		return AIhand;
	}
	
	public void setAIhand(ArrayList<Card> aIhand) {
		this.AIhand = aIhand;
	}

	public ArrayList<Card> getAIwon() {
		return AIwon;
	}

	public void setAIwon(ArrayList<Card> aIwon) {
		AIwon = aIwon;
	}
	public int getAIid() {
		return AIid;
	}

	public void setAIid(int aIid) {
		AIid = aIid;
	}

	public int getAInumPoints() {
		return AInumPoints;
	}



	public void setAInumPoints(int aInumPoints) {
		AInumPoints = aInumPoints;
	}

	public int getAIbid() {
		return AIbid;
	}


	public void setAIbid(int aIbid) {
		AIbid = aIbid;
	}




	public Card getAIcardPlayed() {
		return AIcardPlayed;
	}

	public void setAIcardPlayed(Card aIcardPlayed) {
		AIcardPlayed = aIcardPlayed;
	}


	public Card getDeternmineTrump() {
		return deternmineTrump;
	}


	public void setDeternmineTrump(Card deternmineTrump) {
		this.deternmineTrump = deternmineTrump;
	}

	public int getHasPlayed() {
		return hasPlayed;
	}

	public void setHasPlayed(int hasPlayed) {
		this.hasPlayed = hasPlayed;
	}

	

	public int getTurnAIWins() {
		return turnAIWins;
	}

	public void setTurnAIWins(int turnAIWins) {
		this.turnAIWins = turnAIWins;
	}
	

}
