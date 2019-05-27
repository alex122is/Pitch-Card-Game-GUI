package application;


public class Card{
	Card(Suit color, int number){
		 
		 setSuit(color);
		 setNumber(number);
			 
		 }
	 
	 
	private Suit suit;
	private int Number;
	
	
	public void setSuit(Suit suitNumber) {
		this.suit = suitNumber;
	}
	public Suit getSuit() {
		return this.suit;
	}
	public void setNumber(int number) {
		this.Number = number;
	}
	public int getNumber() {
		return this.Number;
	}

public String toString() {// return the name of the class
		String numStr= "error";
		switch(this.getNumber()) {
		
		case 1:
			numStr = "Ace";
			break;
		case 2:
			numStr= "two";
			break;
		case 3:
			numStr= "three";
			break;
		
		case 4:
			numStr= "Four";
			break;
		case 5:
			numStr= "Five";
			break;
		case 6:
			numStr= "Six";
			break;
		case 7:
			numStr= "Seven";
			break;
		case 8:
			numStr= "Eight";
			break;
		case 9:
			numStr= "Nine";
			break;
		case 10:
			numStr= "ten";
			break;
		case 11:
			numStr= "Jack";
			break;
		case 12:
			numStr= "Queen";
			
			break;
		case 13:
			numStr= "king";
			break;

		default:
			return null;
		}
		return numStr + " of " + suit.toString();
		}
public String toStringSuit() {
	return getSuit().toString();
}
public String toStringAI() {// return the name of the class
	String numStr= "error";
	switch(this.getNumber()) {
	
	case 1:
		numStr = "Ace";
		break;
	case 2:
		numStr= "two";
		break;
	case 3:
		numStr= "three";
		break;
	
	case 4:
		numStr= "Four";
		break;
	case 5:
		numStr= "Five";
		break;
	case 6:
		numStr= "Six";
		break;
	case 7:
		numStr= "Seven";
		break;
	case 8:
		numStr= "Eight";
		break;
	case 9:
		numStr= "Nine";
		break;
	case 10:
		numStr= "ten";
		break;
	case 11:
		numStr= "Jack";
		break;
	case 12:
		numStr= "Queen";
		
		break;
	case 13:
		numStr= "king";
		break;

	default:
		return null;
	}
	return numStr;
	}
}