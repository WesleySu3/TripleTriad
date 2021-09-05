import java.util.Random;
import java.util.ArrayList;

public class TriadBoard {

	Random rnd = new Random();
	static Element[] elements = Element.values();

	// ****************************
	// Gameplay Bookkeeping Variables

	int curPlayer = 1; // Whose turn it is (1 or 2)
	int totTurns = 0; // Game ends at 9
	ArrayList<Integer> history = new ArrayList<Integer>();

	// ****************************
	// Configuration Variables

	// Player types
	PlayerType p1Type = PlayerType.HUMAN; // default
	PlayerType p2Type = PlayerType.HUMAN; // default
	
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
	Slot[] board = new Slot[9];

	// Board Indexing
	/*-----------
	| 6 | 7 | 8 |
	|-------|---|
	| 3 | 4 | 5 |
	|-------|---|
	| 0 | 1 | 2 |
	|----------*/
	


	// ****************************
	// Constructor

	// Constructor tasks:
	//
	// 1. Fill out both decks with
	//    randomized cards
	//
	// 2. Initialize the board with
	//    empty slots
	public TriadBoard() {
		for (int i = 0; i < 5; i++) {
			Card c1 = new Card();
			Card c2 = new Card();
			p1Deck[i] = c1;
			p2Deck[i] = c2;
		}

		for (int i = 0; i < 9; i++) {
			board[i] = new Slot();
		}

	}


	// ****************************
	// Gameplay Methods

	// public boolean isValidMove(Card _c, int _slot) {
	public boolean isValidMove(int _mv) {

		// decode player number
		int curPlayer = _mv / 100;

		// decode card
		Card curCard = new Card();
		if (curPlayer == 1) {
			curCard = p1Deck[(_mv / 10) % 10];
		} else {
			curCard = p2Deck[(_mv / 10) % 10];
		}

		// decode slot
		int curSlot = _mv % 10;
		
		// If the slot is already taken
		// or the card has already been played,
		// return false
		return (!(board[curSlot].hasCard || curCard.played));
		
		
	}

	// public boolean makeMove(Card _c, int _slot) {
	public boolean makeMove(int _mv) {

		// decode player number
		int curPlayer = _mv / 100;

		// decode card
		Card curCard = new Card();
		if (curPlayer == 1) {
			curCard = p1Deck[(_mv / 10) % 10];
		} else {
			curCard = p2Deck[(_mv / 10) % 10];
		}

		// decode slot
		int curSlot = _mv % 10;

		if (!isValidMove(_mv)) {
			return false;
		}
		history.add(_mv);

		// 1. Put card on board
		board[curSlot].card = curCard;
		board[curSlot].hasCard = true;

		curCard.player = curPlayer;
		curCard.played = true;
		curCard.slot = curSlot;

		// 2. TODO
		// Check Element, Plus/Same

		// 3. Flips
		if ((curSlot % 3) > 0 && board[curSlot - 1].hasCard) {
			if (curCard.left > board[curSlot - 1].card.right) {
				board[curSlot - 1].card.player = curPlayer;
			}
		}

		if ((curSlot % 3) < 2 && board[curSlot + 1].hasCard) {
			if (curCard.right > board[curSlot + 1].card.left) {
				board[curSlot + 1].card.player = curPlayer;
			}
		}

		if ((curSlot / 3) > 0 && board[curSlot - 3].hasCard) {
			if (curCard.bottom > board[curSlot - 3].card.top) {
				board[curSlot - 3].card.player = curPlayer;
			}
		}

		if ((curSlot / 3) < 2 && board[curSlot + 3].hasCard) {
			if (curCard.top > board[curSlot + 3].card.bottom) {
				board[curSlot + 3].card.player = curPlayer;
			}
		}

		totTurns++;
		curPlayer = 3 - curPlayer;
		return true;

	}

	public int numTotalMoves() {
    	return history.size();
	}

	public int nextTurn() {
    	return (((history.size() % 2) == 0) ? 1 : 2);
	}

	// Returns 0 if the game ended in a draw
	// Returns 1 or 2 if player 1 or 2 won,
	// Returns 3 if the game is not over,
	// Returns -1 as default, should never occur.
	public int isWinning() {
		if (history.size() < 9) {
			return 3;
		}

		int numP1cards = 0;
		for (int i = 0; i < 9; i++) {
			if (board[i].card.player == 1) {
				numP1cards++;
			}
		}
		if (numP1cards >= 6) {
			return 1;
		} else if (numP1cards == 5) {
			return 0;
		} else if (numP1cards <= 4) {
			return 2;
		}

		return -1;

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