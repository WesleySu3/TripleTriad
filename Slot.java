import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class Slot {

	Font papyrus24 = new Font("Papyrus", Font.BOLD, 24);
	Color cardRed = new Color(240, 128, 128);
    Color cardBlue = new Color(0, 191, 255);

	static Element[] elements = Element.values();
	Element element;
	int elementTest;
	Random rnd = new Random();


	boolean hasCard;
	Card card;
	Color cardColor;

	// Constructs a Slot
	// with no element
	public Slot() {
		hasCard = false;
		element = Element.SLOTNULL;
	}

	// Has a 1/4 probability of
	// assigning a random element
	// to the Slot
	public void addRandElement() {
		elementTest = rnd.nextInt(4);
		if (elementTest == 0) {
			element = elements[rnd.nextInt(elements.length - 2)];
		} else {
			element = Element.SLOTNULL;
		}
	}

	public void display(double x0, double y0, double x1, double y1) {
		if (this.hasCard) {
			cardColor = (this.card.player == 1) ?
				cardRed : cardBlue;
			this.card.display(papyrus24, 5, cardColor,
				StdDraw.BLACK, StdDraw.BLACK,
				x0, y0, x1, y1);
		} else {
			StdDraw.text((x0+x1)/2, (y0+y1)/2,
				TriadBoard.getElementName(this.element));
		}
	}
}