package cardGames;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	System.out.println("-------------------------");
    	System.out.println("WELCOME TO BLACKJACK");
    	System.out.println("-------------------------");
    	
    	Scanner sc = new Scanner(System.in);
    	
        Deck d = new Deck();
        
        int num = 2;
        Hand player = new Hand();
        Hand dealer = new Hand();
        
        d.shuffle();
        
        for (int i = 0; i < num; i++) {
        	player.addCard(d.dealCard());
        	dealer.addCard(d.dealCard());
        }
        
        boolean firstDeal = true;
        boolean notGameOver = true;
        
        while(notGameOver) {
        while(firstDeal) {
        	displayGame(player, dealer, false);
        	
        	if (true) {
        		if (player.value() == 21 && dealer.value() != 21) {
        			displayGame(player, dealer, true);
        			System.out.println("The player won blackjack");
        			break;
        		} else if (player.value() != 21 && dealer.value() == 21) {
        			displayGame(player, dealer, true);
        			System.out.println("The dealer won blackjack");
        			break;
        		} else if (player.value() == 21 && dealer.value() == 21){
        			displayGame(player, dealer, true);
        			System.out.println("Its a tie");
        			break;
        		}
        		firstDeal = false;
        	}
        }
        	
        	System.out.print("Do you want to HIT or STAY: ");
        	String input = sc.nextLine();
        	
        	if (input.equalsIgnoreCase("H")) {
        		player.addCard(d.dealCard());	
        		if (player.value() > 21) {
        			displayGame(player, dealer, true);
        			System.out.println("The player lost");
        			notGameOver = false;
        			break;
        		} else if (player.value() == 21) {
        			displayGame(player, dealer, true);
        			System.out.println("BlackJack!! The player won.");
        			notGameOver = false;
        			break;
        		} 
        		dealer.addCard(d.dealCard());
        		if (dealer.value() > 21) {
        			displayGame(player, dealer, true);
        			System.out.println("The dealer lost.");
        			notGameOver = false;
        			break;
        		} else if (dealer.value() == 21) {
        			displayGame(player, dealer, true);
        			System.out.println("BlackJack!! The dealer won.");
        			notGameOver = false;
        			break;
        		}else if (dealer.value() == 21 && player.value() == 21) {
        			displayGame(player, dealer, true);
        			System.out.println("It's a tie.");
        			notGameOver = false;
        			break;
        		} else {
        			displayGame(player, dealer, true);
        		}
        	} else if (input.equalsIgnoreCase("S")){
        		displayGame(player, dealer, true);
        		System.out.println(compareHand(player, dealer));
        		break;
        	}
        	
        }
        
    }
    
    public static void displayGame(Hand player, Hand dealer, boolean dVis) {
    	System.out.println("-------------------------");
    	System.out.println("Dealer Hand");
    	Card[] dHand = dealer.getHand();
    	for (int i = 0; i < dHand.length; i++) {
    		if (!(dHand[i] == null)) {
    		    if (i == 0 && !dVis) {
    			    System.out.println("- -");
    		    } else {
    		    	System.out.println(dHand[i]);
    		    }
    		}
        }
    	if (dVis) {
    		System.out.println("Value of dealer hand: " + dealer.value());
    	}
    	System.out.println("-------------------------");
    	
    	System.out.println("Player Hand");
    	for (Card hand : player.getHand()) {
        	System.out.println(hand);
        }
    	
    	System.out.println("Value of player hand: " + player.value());
    	System.out.println("-------------------------");
    }
    
    public static String compareHand(Hand player, Hand dealer) {
    	int playerValue = player.value();
    	int dealerValue = dealer.value();
    	
    	String output = "";
    	//0 - player wins, 1 - dealer wins, 2 - tie
    	if (playerValue > dealerValue && playerValue <= 21) {
    		if (playerValue == 21) {
    			output = "BlackJack!! The player won the game";
    		}else {
    			output = "The player won the game";
    		}
    	} else if (playerValue < dealerValue) {
    		if (dealerValue == 21) {
    			output = "BlackJack!! The dealer won the game";
    		}else {
    			output = "The dealer won the game";
    		}
    	} else if (playerValue == dealerValue) {
    		output = "Its a tie";
    	}
		return output;
    }
}
