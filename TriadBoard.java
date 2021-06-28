import java.util.ArrayList;

public class TriadBoard {


	// ****************************
	// Bookkeeping

	int turn = 1; // Whose turn it is (1 or 2)
	int totTurns = 0; // Game ends at 9
	ArrayList<Integer> historyCX = new ArrayList<Integer>();

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


	// ****************************
	// Board elements
	Slot[][] board = new Slot[3][3]; // The board
	Card[][] cards = new Card[3][3]; // Cards placed in slots


	// ****************************
	// Board Methods

	public TriadBoard() {

	}

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

	public Card getCard(Coordinates _cx) {
		return cards[_cx.x][_cx.y];
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



}