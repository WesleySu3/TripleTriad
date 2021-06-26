public class Card {

	// Triple Triad values
	int top;
	int left;
	int right;
	int bottom;
	Element element;

	

	// Coordinates
	Coordinates cx;

	// 1 or 2, the player who
	// currently owns the card
	int player;

	public Card(int _t, int _l, int _r, int _b,
		Element _e) {
		top = _t;
		left = _l;
		right = _r;
		bottom = _b;
		element = _e;
		cx = new Coordinates();
	}


}