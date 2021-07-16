import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class Card {

	static Element[] elements = Element.values();
	int elementTest;

	Random rnd = new Random();

	// Triple Triad values
	int top;
	int left;
	int right;
	int bottom;
	Element element;

	

	// Coordinates on the
	// playing board.
	// Default (-1, -1)
	int slot;

	// 1 or 2, the player who
	// currently owns the card
	int player;

	// Whether the card has been
	// placed on the board
	boolean played = false;


	// Default Card Constructor
	// sets coordinates (-1,-1).
	public Card() {
		top = rnd.nextInt(10) + 1;
		left = rnd.nextInt(10) + 1;
		right = rnd.nextInt(10) + 1;
		bottom = rnd.nextInt(10) + 1;
		elementTest = rnd.nextInt(4);
		if (elementTest == 0) {
			element = elements[rnd.nextInt(elements.length - 2)];
		} else {
			element = Element.NORMAL;
		}

		slot = -1;
	}

	// Randomizes the numbers and element of
	public void randomize() {
		top = rnd.nextInt(10) + 1;
		left = rnd.nextInt(10) + 1;
		right = rnd.nextInt(10) + 1;
		bottom = rnd.nextInt(10) + 1;
		elementTest = rnd.nextInt(4);
		if (elementTest == 0) {
			element = elements[rnd.nextInt(elements.length - 2)];
		} else {
			element = Element.NORMAL;
		}
		
	}

	// Displays a card within the given
	// font, colors, and coordinates
	public void display(Font _font, int _highlight, Color _cardColor,
						Color _boundaryColor, Color _textColor,
						double x0, double y0,
						double x1, double y1) {

		

		// Draw card background
		StdDraw.setPenColor(_cardColor);
		StdDraw.filledRectangle((x1+x0)/2, (y1+y0)/2,
			(x1-x0)/2, (y1-y0)/2);

		// Draw card boundary
		StdDraw.setPenColor(_boundaryColor);
		StdDraw.rectangle((x1+x0)/2, (y1+y0)/2,
			(x1-x0)/2, (y1-y0)/2);

		// Draw card values
		StdDraw.setFont(_font);
		StdDraw.setPenColor(_textColor);


		if (_highlight == 0) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.text((x1+x0)/2, ((y1+y0)/2)+(.35*(y1-y0)) + .05,
			top == 10 ? "A" : String.valueOf(top));
		StdDraw.setPenColor(_textColor);

		if (_highlight == 1) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.text(((x1+x0)/2)-(.35*(x1-x0)), (y1+y0)/2 + .05,
			left == 10 ? "A" : String.valueOf(left));
		StdDraw.setPenColor(_textColor);

		if (_highlight == 2) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.text(((x1+x0)/2)+(.35*(x1-x0)), (y1+y0)/2 + .05,
			right == 10 ? "A" : String.valueOf(right));
		StdDraw.setPenColor(_textColor);

		if (_highlight == 3) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.text((x1+x0)/2, ((y1+y0)/2)-(.35*(y1-y0)) + .05,
			bottom == 10 ? "A" : String.valueOf(bottom));
		StdDraw.setPenColor(_textColor);

		// Draw card element
		if (_highlight == 4) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		String elem = TriadBoard.getElementName(element);
		StdDraw.text((x1+x0)/2, (y1+y0)/2 + .05, elem);

	}


}