package cardGames;

public class Deck {

	/** An array of 52 Cards, representing the deck. */
	private Card[] deck;
	/** How many cards have been dealt from the deck. */
	private int cardsUsed;

	/**
	 * Constructs an unshuffled deck of cards. Creates and stores 52 cards
	 */
	public Deck() {

		deck = new Card[52];
		int cardCt = 0; // How many cards have been created so far.
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				deck[cardCt] = new Card(suit, value);
				cardCt++;
			}
		}
		cardsUsed = 0;
	}

	/**
	 * Puts all the used cards back into the deck, and shuffles it into a random
	 * order.
	 */
	public void shuffle() {

		for (int i = 51; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}

	/**
	 * As cards are dealt from the deck, the number of cards left decreases. This
	 * function returns the number of cards that are still left in the deck.
	 * 
	 * @return Number of cards left in deck
	 */
	public int cardsLeft() {

		return 52 - cardsUsed;
	}

	/**
	 * Check if the deck is empty.
	 * 
	 * @return True if this deck as no cards else return false.
	 */
	public boolean isEmpty() {
		if (cardsLeft() == 0) {
			return true;
		} else
			return false;

	}

	/**
	 * Deals one card from the deck and returns it.
	 * 
	 * @return <tt>cardGames.Card</tt> dealt
	 */
	public Card dealCard() {

		if (cardsUsed == 52)
			shuffle();
		cardsUsed++;
		return deck[cardsUsed - 1];
	}

}
