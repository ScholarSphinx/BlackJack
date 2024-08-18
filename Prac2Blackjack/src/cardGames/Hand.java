package cardGames; /**
 * 
 */

public class Hand {
	private Card[] hand;
	private int numCards;
	
	//creates a hand to hold 10 cards
	public Hand() {
		hand = new Card[10];
		numCards = 0;
	}
	
	//create a hand to hold num cards
	public Hand(int num) {
		hand = new Card[num];
		numCards = 0;
	}
	
	//add a card to this hand
	public void addCard(Card card) {
		if (numCards < hand.length) {
			hand[numCards] = card;
			numCards++;
		}else {
			System.out.println("Hand is already full. Discard a card first.");
		}
		
	}

	//remove the card at index i from this hand
	public void removeCard(int index) {
		if (index >= 0 && index < numCards) {
            hand[index] = null;
            for (int j = index; j < numCards; j++) {
        	    hand[j] = hand[j + 1];
            }
            numCards--;
		}else {
			System.out.println("Invalid card index selected.");
		}
	}
	
	//return the value of the cards in this hand
	public int value() {
		int sum = 0;
		boolean aceFound = false;
		int aceValue = 0;
		//Adds the value of each card to sum unless its an Ace 
		for (int i=0; i < hand.length; i++) { 
			if (!(hand[i] == null)) {
			int card = hand[i].getValue();
		    if (card == 1) {
		       aceFound = true; 
		       aceValue++;
		    } else if (card >= 2&& card <= 10) {
		        sum += card;
		    } else {
		    	sum += 10;
		    }
			}
		}
		boolean firstAce = true;
		//Adds the value of Ace to sum, 11 if its the first ace else 1 thereafter 
		for (int j = aceValue; j > 0; j--) {
		    if (aceFound) {
		        if ((sum + 11 ) <= 21 && firstAce) {
		            sum += 11;
		            firstAce= false;
		        } else {
		            sum += 1;
		        }
		    }
		}
		return sum;
	}
		
	
	public Card[] getHand() {
		return hand;
	}
	
}
