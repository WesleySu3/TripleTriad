import java.util.Random;

public class Slot {

	// Coordinates
	int x;
	int y;

	static Element[] elements = Element.values();
	Element element;
	int elementTest;
	Random rnd = new Random();


	boolean hasCard;
	Card card;

	// Constructs a Slot
	// with given coordinates
	public Slot(int _x, int _y) {
		x = _x;
		y = _y;
		hasCard = false;
	}

	// Has a 1/4 probability of
	// assigning a random element
	// to the Slot
	public void addRandElement() {
		elementTest = rnd.nextInt(4);
		if (elementTest == 0) {
			element = elements[rnd.nextInt(elements.length - 2)];
		} else {
			element = Element.NORMAL;
		}
	}
}