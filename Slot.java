public class Slot {

	// Coordinates
	int x;
	int y;

	Element element;

	boolean hasCard;
	Card card;

	public Slot(int _x, int _y, Element _e) {
		x = _x;
		y = _y;
		element = _e;
		hasCard = false;
	}
}