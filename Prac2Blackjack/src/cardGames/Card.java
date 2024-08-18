package cardGames; /**
 * 
 */

public class Card {

	public static final int HEARTS = 0;
	public static final int CLUBS = 1;
	public static final int SPADES = 2;
	public static final int DIAMONDS = 3;

	private int suit;
	private int value;

	/**
	 * @param suit
	 * @param value
	 */
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String getSuitAsString() {
		if (suit == HEARTS) {
			return "H";
		}else if (suit == CLUBS) {
			return "C";
		}else if (suit == SPADES) {
			return "S";
		}else {
			return "D";
		}
	}
	
	public String getValueAsString() {
		if (value == 1) {
			return "A";
		}else if (value == 11) {
			return "J";
		}else if (value == 12) {
			return "Q";
		}else if (value == 13) {
			return "K";
		}else {
			return String.valueOf(value);
		}
			
	}

	/**
	 * Represent the card as string for printing Now the cardGames.Card can be printed with
	 * println
	 */
	public String toString() {
		return getSuitAsString() + " " + getValueAsString();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the suit
	 */
	public int getSuit() {
		return suit;
	}

}
