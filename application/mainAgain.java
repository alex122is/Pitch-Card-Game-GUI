package application;
	

import java.awt.TextArea;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.paint.Color; 

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainAgain extends Application{
 
	TextField text, humanPlayer,compPlayer1,compPlayer2,compPlayer3, DrawHuman,Drawcom1,Drawcom2,Drawcom3, humanTurn, trump, humanTurn2;
	Button btn, Start, x, y, z,card1,card2,card3,card4,card5,card6,player2, player3, player4, bid2,bid3, bid4,bid5,pass,Exit,greeting,NextTurn;
	TextField Jack, High,Low, Game;
	Stage myStage;
	Scene scene, scene2, scene3;
	HashMap<String, Scene> sceneMap;
	Pitch Hold;
	Button Card1,Card2,Card3, Card4, Card5, Card6;
	EventHandler<ActionEvent> updateHand ;//= new EventHandler<ActionEvent>()
	EventHandler<ActionEvent> updateHand2;//= new EventHandler<ActionEvent>()
	int turns=0;
	TextArea ta;// = new TextArea();
	 Scene scene4;// = new Scene(ta);
	
	
	
	

public static void main(String[] args) {

launch(args);
}




public String retTextBid(int x) {
	String numStr= "error";

	switch(x) {

case 2:
	numStr = "2";
	break;
case 3:
	numStr= "3";
	break;
case 4:
	numStr= "4";
	break;

case 5:
	numStr= "5";
	break;
case 0:
	numStr= "0";
	break; 
}
	return numStr;
}


public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Pitch game");
	myStage = primaryStage;
	text = new TextField();
	btn = new Button();
	Start = new Button("Start");
	Exit = new Button("Exit");
	sceneMap = new HashMap<String, Scene>();
	
	player2 = new Button("Two Players");
	player3 = new Button("Three Players");
	player4 = new Button("Four PLayers");
	greeting = new Button("How many players do you want to play with");
	humanPlayer = new TextField();
	compPlayer1 = new TextField();
	compPlayer2 = new TextField();
	compPlayer3 = new TextField();
	DrawHuman = new TextField();
	DrawHuman.setMinSize(100, 200);
	Drawcom1 = new TextField();
	Drawcom1.setMinSize(100, 200);
	Drawcom2 = new TextField();
	Drawcom2.setMinSize(100, 200);
	Drawcom3 = new TextField();
	Drawcom3.setMinSize(100, 100);

	humanTurn = new TextField();
	humanTurn2= new TextField();
	NextTurn =new Button("BUTTON");
	trump = new TextField();
	Jack =new TextField();
	Card1= new Button();
	Card2= new Button();
	Card3= new Button();
	Card4= new Button();
	Card5= new Button();
	Card6= new Button();
	
	
	

	EventHandler<ActionEvent> updateHand = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event){

			//System.out.println("we should be entering event handler ");
			System.out.println("are we in here");
			int pitcher = Hold.getPitcher();
			int numplayers = Hold.getNumPlayers();
			
			System.out.println(pitcher);
			System.out.println(numplayers);
			System.out.println(turns);
			System.out.println(Hold.getTrumpSet());
			if(pitcher  ==  1) {// call the human click 
				 
				
				if( Hold.getTrumpSet() ==0 && Hold.getHumanPlayWent() ==0) {
					Button b = (Button)event.getSource();
					System.out.println(b);
					String a = parseString(b,Hold,0);
					System.out.println("inside the goods =============================");
					System.out.println(a);
					//Card send = makeCard(a);
					Hold.setTrump(a);
					humanTurn2.clear();
					humanTurn2.setText("The trump is" +Hold.getTrump());
					DrawHuman.setText(a);
					Hold.setTrumpSet(1); //  Trump will not be able to be modifies anymore
					b.setDisable(true);
					//Hold.setTableCards(0,a);
					Hold.setHumanPlayWent(1);
					turns++;
				}
				else {//if (Hold.getHumanPlayWent() ==0 && Hold.getTrumpSet() >=1){
					Button b = (Button)event.getSource();
					System.out.println(b);
					String a = parseString(b,Hold,0);
					DrawHuman.clear();
					DrawHuman.setText(a);
					b.setDisable(true);
					Hold.setHumanPlayWent(1);
					turns++;
				}
				int x =0;
				for(AIPlayer a :Hold.retAIPlayer()) {
					x++;
				}
				
				
				if(x >=1 && Hold.getComPla1Went() == 0){//&&  currentPlayer !=x +1) {
					Card a =Hold.retAIPlayer().get(0).playAICard(Hold.retAIPlayer().get(0).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla1Went(1);
					Hold.addTableCards(a);
					Hold.retAIPlayer().get(0).setAIcardPlayed(a);
					Drawcom1.clear();
					Drawcom1.setText(a.toString());
					}
				if(x >= 2 && Hold.getComPla2Went() == 0){//&&  currentPlayer !=x+1) {
					Card a =Hold.retAIPlayer().get(1).playAICard(Hold.retAIPlayer().get(1).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla2Went(1);
					Hold.addTableCards(a);
					Hold.retAIPlayer().get(1).setAIcardPlayed(a);
					Drawcom2.clear();
					Drawcom2.setText(a.toString());
				}
				if(x == 3 && Hold.getComPla3Went() == 0){// &&  currentPlayer !=x+1) {
					Card a =Hold.retAIPlayer().get(2).playAICard(Hold.retAIPlayer().get(2).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla3Went(1);
					Hold.addTableCards(a);
					Hold.retAIPlayer().get(2).setAIcardPlayed(a);
					Drawcom3.clear();
					Drawcom3.setText(a.toString());
				
			}
				
			}
			else if(pitcher  == 2 ) {
		
				 if (Hold.getHumanPlayWent() ==0 && Hold.getTrumpSet() >=1){
					Button b = (Button)event.getSource();
					System.out.println(b);
					String a = parseString(b,Hold,0);
					DrawHuman.clear();
					DrawHuman.setText(a);
					b.setDisable(true);
					Hold.setHumanPlayWent(1);
					turns++;

				}
			}
			else if ( pitcher  == 3) {
				
				 if (Hold.getHumanPlayWent() ==0 && Hold.getTrumpSet() >=1){
						Button b = (Button)event.getSource();
						System.out.println(b);
						String a = parseString(b,Hold,0);
						DrawHuman.clear();
						DrawHuman.setText(a);
						b.setDisable(true);
						Hold.setHumanPlayWent(1);
						turns++;

					}

				 int x =0;
					for(AIPlayer a :Hold.retAIPlayer()) {
						x++;
					}	
					
					if(x >=1 && Hold.getComPla1Went() == 0){//&&  currentPlayer !=x +1) {
						Card a =Hold.retAIPlayer().get(0).playAICard(Hold.retAIPlayer().get(0).getAIhand(), Hold.getTrump());//now play second player and retur
						Hold.setComPla1Went(1);
						Hold.addTableCards(a);
						Drawcom1.clear();
						Drawcom1.setText(a.toString());
						}
				
			}
			else if ( pitcher  == 4) {
				if (Hold.getHumanPlayWent() ==0 && Hold.getTrumpSet() >=1){
					Button b = (Button)event.getSource();
					System.out.println(b);
					String a = parseString(b,Hold,0);
					DrawHuman.clear();
					DrawHuman.setText(a);
					b.setDisable(true);
					Hold.setHumanPlayWent(1);
					turns++;
				}
				int x =0;
				for(AIPlayer a :Hold.retAIPlayer()) {
					x++;
				}
				
				
				if(x >=1 && Hold.getComPla1Went() == 0){//&&  currentPlayer !=x +1) {
					Card a =Hold.retAIPlayer().get(0).playAICard(Hold.retAIPlayer().get(0).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla1Went(1);
					Hold.addTableCards(a);
					Drawcom1.clear();
					Drawcom1.setText(a.toString());
					}
				if(x >= 2 && Hold.getComPla2Went() == 0){//&&  currentPlayer !=x+1) {
					Card a =Hold.retAIPlayer().get(1).playAICard(Hold.retAIPlayer().get(1).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla2Went(1);
					Hold.addTableCards(a);
					Drawcom2.clear();
					Drawcom2.setText(a.toString());
				}
			}
		
		        
			beginGame(Hold);
				
		}
	};

	
	
	
	EventHandler<ActionEvent> updateBids = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			Button b = (Button)event.getSource();
			if(b ==bid2) {Hold.retPlayer().get(0).setBid(2);}//sets the bid for the player
			if(b ==bid3) {Hold.retPlayer().get(0).setBid(3);}//sets the bid for the player
			if(b ==bid4) {Hold.retPlayer().get(0).setBid(4);}//sets the bid for the player
			if(b ==bid5) {Hold.retPlayer().get(0).setBid(5);}//sets the bid for the player
			if(b ==pass) {Hold.retPlayer().get(0).setBid(0);}//sets the bid for the player
			for( AIPlayer i : Hold.retAIPlayer()) {
				i.makeAIbid();
			}
			
			int x=0;   
			for(AIPlayer i :Hold.retAIPlayer()) {// to tell me how many computer players there are
				x++;
			}	
			
			int playerMAxBid=0;// to get the max bid
			playerMAxBid = Hold.retPlayer().get(0).getBid();
			int thePitcher =-2; //no one bid unless updated to something else
			if(playerMAxBid >=2) {
				thePitcher = -1; //to represent human player won bid;
			}

			int y =0;
			for( AIPlayer i : Hold.retAIPlayer()) {
				if((i.getAIbid())> playerMAxBid) {
					thePitcher = y;
					playerMAxBid = i.getAIbid();
				}	
				y++;
				}
			
			if(thePitcher ==-1) {Hold.setPitcher(1);}//the human won
			if(thePitcher ==0) {Hold.setPitcher(2);}// computer 1 won
			if(thePitcher ==1) {Hold.setPitcher(3);}//computer 2 won
			if(thePitcher ==2) {Hold.setPitcher(4);}//computer 3 won
			if(thePitcher == -2) {Hold.setPitcher(0);}//no one bid redo the game
			
			System.out.println(thePitcher);
			
			humanPlayer.setPromptText("Human player 1 bid " + retTextBid(Hold.retPlayer().get(0).getBid())); //sets up the bids to be displayed
			compPlayer1.setPromptText("computer player 2  bid " +retTextBid(Hold.retAIPlayer().get(0).getAIbid()));
			if(x >=2) {
			compPlayer2.setPromptText("computer player 3 bid " +retTextBid(Hold.retAIPlayer().get(1).getAIbid()));
			}
			if(x==3) {
			compPlayer3.setPromptText("Computer  player 4 bid " +retTextBid(Hold.retAIPlayer().get(2).getAIbid()));
			}
			
			
			beginGame(Hold);
			System.out.println();
			System.out.println("we are returning   good");
			
		
		}
	};

	card1 = new Button();
	card2 = new Button();
	card3 = new Button();
	card4 = new Button();
	card5 = new Button();
	card6 = new Button();
	card1.setMinSize(100, 200);
	card2.setMinSize(100, 200);
	card3.setMinSize(100, 200);
	card4.setMinSize(100, 200);
	card5.setMinSize(100, 200);
	card6.setMinSize(100, 200);

	card1.setOnAction(updateHand);
	card2.setOnAction(updateHand);
	card3.setOnAction(updateHand);
	card4.setOnAction(updateHand);
	card5.setOnAction(updateHand);
	card6.setOnAction(updateHand);

	bid2 = new Button("Bid 2");
	bid3 = new Button("Bid 3");
	bid4 = new Button("Bid 4");
	bid5 = new Button("Bid smudge");
	pass = new Button("Pass");
	bid2.setOnAction(updateBids);
	bid3.setOnAction(updateBids);
	bid4.setOnAction(updateBids);
	bid5.setOnAction(updateBids);
	pass.setOnAction(updateBids);
	
	

	
	//changes to game initializes pitch calls for player needed 
	EventHandler<ActionEvent> changeToGame = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			
			Button b = (Button)event.getSource();
			System.out.println(b);			
			if(b == player2) {Hold = new Pitch(2); Hold.setNumPlayers(2);}
			else if(b == player3) {Hold = new Pitch(3);Hold.setNumPlayers(3); }
			else if(b == player4) {Hold = new Pitch(4); Hold.setNumPlayers(4);}
			//myStage.setScene(sceneMap.get("playCards"));
			card1.setText(Hold.retPlayer().get(0).getHand().get(0).toString());
			card2.setText(Hold.retPlayer().get(0).getHand().get(1).toString());
			card3.setText(Hold.retPlayer().get(0).getHand().get(2).toString());
			card4.setText(Hold.retPlayer().get(0).getHand().get(3).toString());
			card5.setText(Hold.retPlayer().get(0).getHand().get(4).toString());
			card6.setText(Hold.retPlayer().get(0).getHand().get(5).toString());
		//	Hold.initTableCards(Hold.getNumPlayers());
			humanTurn.setText("BID BID");
		
			humanTurn2.setText("BID BID");
				
		}
	};

	player2.setOnAction(changeToGame);
	player3.setOnAction(changeToGame);
	player4.setOnAction(changeToGame);

//	Exit.setOnAction(new EventHandler<ActionEvent>(){
//		public void handle(ActionEvent event){
//			Platform.exit();
//	}
//});
	 
	
	//lambda expression
	   //======================================================================================================//
	  //======================================================================================================//
	
	
	
	
	Exit.setOnAction(e ->
	{
		Platform.exit();

	});

	
		Start.setOnAction(e ->
		{
			
					myStage.setScene(sceneMap.get("playCards"));
//			}
		});
		//======================================================================================================//
		  //======================================================================================================//
	
	
	BorderPane pane = new BorderPane(); //root node
	BorderPane pane2 = new BorderPane();
	BorderPane pane3 = new BorderPane();

	pane.setPadding(new Insets(350));
	pane2.setPadding(new Insets(0,200,70,200));
	pane3.setPadding(new Insets(0,200,70,200));

    HBox cardsDrawn =new HBox(10 ,DrawHuman,Drawcom1,Drawcom2,Drawcom3);
    cardsDrawn.setMaxHeight(100);
	HBox humanTu = new HBox(10, humanTurn,humanTurn2,trump,NextTurn);
	//humanTu.setAlignment(Pos.TOP_RIGHT);
//	humanTu.setMinHeight(150);
    HBox bids =new HBox(10 ,humanPlayer,compPlayer1,compPlayer2,compPlayer3);
	VBox bid = new VBox(12,pass,bid2,bid3,bid4, bid5);
	HBox classHand = new HBox(12,pass,bid2,bid3,bid4, bid5,card1,card2, card3, card4, card5, card6);
	HBox welcomeScrean = new HBox(10, Start,Exit,greeting, player2, player3 , player4);
	//HBox newCard = new HBox(12,Card1,Card2, Card3, Card4, Card5, Card6);
	
	
	

	
    HBox gameDisplay =new HBox(10 ,Jack);
	pane.setCenter(welcomeScrean);
	pane2.setTop(bids);
	pane2.setCenter(cardsDrawn);
	pane2.setBottom(classHand);
	pane2.setRight(humanTu);
	scene = new Scene(pane, 1600, 900);
    scene3 = new Scene(pane2, 1600,900);
	sceneMap.put("welcome", scene);
	sceneMap.put("playCards", scene3);
		
	primaryStage.setScene(sceneMap.get("welcome"));
	primaryStage.show();
		
	}
//counter num check, compare value fo card, put highest value card in fornt , for loop for every single player, first check if the 
// card is the trump card. if not dont play it, if the first , 

	public void beginGame(Pitch Hold) {
//        turns++;
      
System.out.println("tanble cards===============================================");
System.out.println("tanble cards===============================================");
System.out.println("tanble cards===============================================");
		for( Card a:Hold.getTableCards()) {
			System.out.println(a);
		}

		System.out.println(" ENd    tanble cards===============================================");
		System.out.println(" End   tanble cards===============================================");
		System.out.println("  End tanble cards===============================================");

		
		
		
		ArrayList<Card> sort = Hold.getTableCards();
		ArrayList<Card> SortTrump = new ArrayList<Card>();
		Card topCard = null;;

		if(turns >0) {                        //check for the turn winner
			
			int i =0;
			for ( Card a: sort ) {   //sort by trump
				if(a.toStringSuit().equals(Hold.getTrump())){
					SortTrump.add(a);
					i++;
				}
			}				//sort by trump by nummber
			if(i >0) {
				int counter = 2;
				for( Card a: SortTrump)
				if (a.getNumber() == 1) {
					topCard = a;
					break;
				}
				else if(a.getNumber()>=counter) {
					topCard = a;
					counter = a.getNumber(); 
					
				}
			}
		
		else {    // no trump just sort by number
			int counter = 2;
			for( Card a: sort)
			if (a.getNumber() == 1) {
				topCard = a;
				break;
			}
			else if(a.getNumber()>=counter) {
				topCard = a;
				counter = a.getNumber(); 
				
			}
			
		}		///found the highest card  now now declare the winner of trick
			for(AIPlayer a : Hold.retAIPlayer()) {
				for(Card b: a.getAIhand()) {
					System.out.println(b);
				}
			}
			System.out.println("The highch cARD IS===================");
			System.out.println("The highch cARD IS===================");
			System.out.println("The highch cARD IS===================");

			System.out.println(topCard);
			System.out.println("  ENDThe highch cARD IS===================");
			System.out.println(" ENd The highch cARD IS===================");
			System.out.println(" END The highch cARD IS===================");
			
			int x =0; int isIThere =0;
			for(AIPlayer a :Hold.retAIPlayer()) {
				++x;
				
				System.out.println();
				System.out.println("the ai card saved");
				

				System.out.println(a.getAIcardPlayed());
					if(topCard.toString().contains(a.getAIcardPlayed().toString())) {
						humanTurn2.clear();
						if(x ==1) {trump.clear(); trump.setText("Pitcher is  player 2"); Hold.setPitcher(2); isIThere++;}
						if(x ==2) {trump.clear(); trump.setText("Pitcher is  player 3"); Hold.setPitcher(3); isIThere++;}
						if(x ==3) {trump.clear(); trump.setText("Pitcher is  player 4"); Hold.setPitcher(4); isIThere++;}
					}
			}
			if(isIThere ==0) {
				humanTurn2.clear();
				trump.clear();
				trump.setText("Pitcher is player1"); Hold.setPitcher(1);
			}
			Hold.clearTableCards();
			SortTrump.clear();		
		}

		if(turns >=1) {
			Hold.setHumanPlayWent(0); 
			Hold.setComPla1Went(0);
			Hold.setComPla2Went(0);
			Hold.setComPla3Went(0);
			Hold.setTrumpSet(0);
		}//now check for winners  and updaate the pitcers:)
		

   		int firstBidder = Hold.getPitcher();
	
	    if(firstBidder ==1) {  //the human won the bid   check for wins 
	    	humanTurn.clear();
			humanTurn.setText("Your Turn Click A Card");
		
			
			
		}
		  else if(firstBidder  == 2) { //get the cards for the 3 cards computer, now do the human.

			  int x =0;
				for(AIPlayer a :Hold.retAIPlayer()) {
					x++;
				}
				
				//this will initiate trump card or the winner
				if( Hold.getTrumpSet() ==0 && Hold.getComPla1Went() ==0 && turns <=5 ){                     //for computer  class
					Card a  = Hold.retAIPlayer().get(0).declareTrumpCard(Hold);
					//Card a =Hold.retAIPlayer().get(0).playAICard(Hold.getTableCards(), Hold.getTrump());//now play second player and retur
					Hold.addTableCards(a);
					Hold.setComPla1Went(1);
					Hold.retAIPlayer().get(0).setAIcardPlayed(a);
					Hold.setTrump(a.toStringSuit());
					humanTurn2.clear();
					humanTurn2.setText("The trump is" +Hold.getTrump());
					Drawcom1.setText(a.toString());
					Hold.setTrumpSet(1);
					System.out.println("computer1");

					}


				if(x >= 2 && Hold.getComPla2Went() == 0 && turns <6){//&&  currentPlayer !=x+1) {
					Card a = Hold.retAIPlayer().get(1).playAICard(Hold.retAIPlayer().get(1).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla2Went(1);
					Drawcom2.clear();
					Drawcom2.setText(a.toString());
					System.out.println("computer2");
					Hold.addTableCards(a);
					Hold.retAIPlayer().get(1).setAIcardPlayed(a);



				}
				if(x == 3 && Hold.getComPla3Went() == 0 && turns <6){// &&  currentPlayer !=x+1) {
					Card a =Hold.retAIPlayer().get(2).playAICard(Hold.retAIPlayer().get(2).getAIhand(), Hold.getTrump());//now play second player and retur
					System.out.println("computer3");
					Hold.setComPla3Went(1);
					Drawcom3.clear();
					Drawcom3.setText(a.toString());	
					Hold.addTableCards(a);

			}
					for(AIPlayer a :Hold.retAIPlayer()) {
						
						x++;
					}

		  System.out.println("call to player draw");
		  //call the human turn
		    humanTurn.clear();
			humanTurn.setText("Your Turn Click A Card");
		  
		  }
		  else if (firstBidder  ==3) { //get the cards for the 
			  int x =0;
			
				for(AIPlayer a :Hold.retAIPlayer()) {
					x++;
				}
				
				//this will initiate trump card or the winner
				if( Hold.getTrumpSet() ==0 && Hold.getComPla2Went() ==0 && turns <=5 ){                     //for computer  class
					Card a  = Hold.retAIPlayer().get(1).declareTrumpCard(Hold);
					//Card a =Hold.retAIPlayer().get(0).playAICard(Hold.getTableCards(), Hold.getTrump());//now play second player and retur
					Hold.setComPla2Went(1);
					Hold.setTrump(a.toStringSuit());
					humanTurn2.clear();
					humanTurn2.setText("The trump is" +Hold.getTrump());
					Drawcom2.setText(a.toString());
					Hold.setTrumpSet(1);
					Hold.addTableCards(a);;
					System.out.println("computer2");

					}
//				else if(Hold.getComPla2Went() ==0 && Hold.getTrumpSet() >=1 && turns <6 && Hold.getTrumpSet() >0) {
//					Card a =Hold.retAIPlayer().get(1).playAICard(Hold.retAIPlayer().get(1).getAIhand(), Hold.getTrump());//now play second player and retur
//					Hold.setComPla2Went(1);
//					Drawcom2.clear();
//					Hold.addTableCards(a);;
//					Drawcom2.setText(a.toString());
//					System.out.println("computer2");
//
//				}

				if(x ==3 && Hold.getComPla3Went() == 0 && turns <6){//&&  currentPlayer !=x+1) {
					Card a =Hold.retAIPlayer().get(2).playAICard(Hold.retAIPlayer().get(2).getAIhand(), Hold.getTrump());//now play second player and retur
					Hold.setComPla3Went(1);
					Drawcom3.clear();
					Hold.addTableCards(a);;
					Drawcom3.setText(a.toString());
					System.out.println("computer3");
					

				} 
//				humanTurn.clear();
				DrawHuman.clear();
				humanTurn.setText("Your Turn Click A Card");
				

		  }
		  else if(firstBidder  ==4) {
			  int x =0;
				
				for(AIPlayer a :Hold.retAIPlayer()) {
					x++;
				}
				
				//this will initiate trump card or the winner
				if( Hold.getTrumpSet() ==0 && Hold.getComPla3Went() ==0 && turns <=5 ){                     //for computer  class
					Card a  = Hold.retAIPlayer().get(2).declareTrumpCard(Hold);
					Hold.setComPla3Went(1);
					Hold.setTrump(a.toStringSuit());
					humanTurn2.setText("The trump is " +Hold.getTrump());
					Hold.addTableCards(a);;
					Drawcom3.setText(a.toString());
					Hold.setTrumpSet(1);
					System.out.println("computer3");

					}
//				else if(Hold.getComPla3Went() ==0  && turns <6) {
//					Card a =Hold.retAIPlayer().get(2).playAICard(Hold.retAIPlayer().get(2).getAIhand(), Hold.getTrump());//now play second player and retur
//					Hold.setComPla3Went(1);
//					Drawcom3.clear();
//					Hold.addTableCards(a);;
//					Drawcom3.setText(a.toString());
//					System.out.println("computer3");
//
//				}
				humanTurn.clear();
				DrawHuman.clear();
				humanTurn.setText("Your Turn Click A Card");
			  
		  }
		  
		System.out.println("and now returning to bid");		
				
	}
	public String parseString(Button b, Pitch Hold, int index) {// to return the make
		
		int t =0;
		String s = b.toString();
		String[] tokens = s.split("'");
		int i =0;
		String save = null;
		for (String t1 : tokens) {
			i++;
			if(i ==2) {
		  System.out.println(t1);
		  save = t1;
			}
		}
		//System.out.println(save);
		for(Card a:Hold.retPlayer().get(0).getHand()) {
			if(a == null) {
				continue;
			}
			System.out.println(a.toString());

				if(a.toString().equals(save)) {
					Card temp =a;
					
					Hold.addTableCards(a);
					Hold.retPlayer().get(0).setCardPlayed(a);
					Hold.retPlayer().get(0).getHand().set(t, null);
//					Hold.addTableCards(temp, index);
				break;
				}
			t++;
			}	
		return save;
	}
	
}
