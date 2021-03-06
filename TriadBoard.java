import java.util.Random;
import java.util.ArrayList;

public class TriadBoard {

	Random rnd = new Random();
	static Element[] elements = Element.values();

	// ****************************
	// Gameplay Bookkeeping Variables

	int turn = 1; // Whose turn it is (1 or 2)
	int totTurns = 0; // Game ends at 9
	ArrayList<Integer> historyCX = new ArrayList<Integer>();

	// ****************************
	// Configuration Variables

	// Player types
	PlayerType p1Type = PlayerType.HUMAN; // default
	PlayerType p2Type = PlayerType.MEDIUM; // default
	
	// Rules
	boolean open = true; // This implementation will
						 // always be open. I'm leaving
						 // this toggle here in case I
						 // decide to implement closed
						 // in the future.
	boolean elemental = false;
	boolean plus = false;
	boolean same = false;
	boolean sameWall = false;
	boolean suddenDeath = false;

	// Decks
	Card[] p1Deck = new Card[5];
	Card[] p2Deck = new Card[5];

	// Used in deck config menus
	int playerChosen; 
	int cardChosen;
	Card curCard = new Card();

	


	// ****************************
	// The board
	Slot[][] board = new Slot[3][3];

	// Board Indexing
	/*-----------------------
	| (0,2) | (1,2) | (2,2) |
	|-------|-------|-------|
	| (0,1) | (1,1) | (2,1) |
	|-------|-------|-------|
	| (0,0) | (1,0) | (2,0) |
	|----------------------*/
	


	// ****************************
	// Constructor

	// Constructor tasks:
	//
	// 1. Fill out both decks with
	//    randomized cards
	//
	// 2. TBD
	public TriadBoard() {
		for (int i = 0; i < 5; i++) {
			Card c1 = new Card();
			Card c2 = new Card();
			p1Deck[i] = c1;
			p2Deck[i] = c2;
		}

	}


	// ****************************
	// Gameplay Methods

	public boolean isValidMove(Card _c, Coordinates _cx) {
		boolean valid = true;

		// If the slot is already taken
		// or the card has already been played,
		// return false
		if (board[_cx.x][_cx.y].hasCard) {
			return false;
		}
		if (_c.cx.x != -1)
			return false;
		return true;
	}

	public boolean makeMove(Card _c, Coordinates _cx) {
		if (!isValidMove(_c, _cx)) {
			return false;
		}

		/****************************
		TODO
		
		1. Put card on board
		2. Check
			A. Element
			B. Same/SameWall/Plus
			C. Direct Wins
		3. Flips (update history)
		****************************/

		return true;

	}

	// ****************************
	// Configuration methods

	public void randomizeDecks() {
		for (int i = 0; i < 5; i++) {
			p1Deck[i].randomize();
			p2Deck[i].randomize();
		}
	}

	public static String getElementName(Element _elem) {
		switch (_elem) {
			case EARTH:
				return "Earth";
			case FIRE:
				return "Fire";
			case WATER:
				return "Water";
			case POISON:
				return "Poison";
			case HOLY:
				return "Holy";
			case LIGHTNING:
				return "Elec";
			case WIND:
				return "Wind";
			case ICE:
				return "Ice";
			case NORMAL:
				return "Normal";
			case SLOTNULL:
				return "";
		}
		return "";
	}

	public static Element getElement(int _id) {
		return elements[_id];
	}



}