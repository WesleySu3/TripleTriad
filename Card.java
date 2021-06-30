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
	Coordinates cx = new Coordinates();

	// 1 or 2, the player who
	// currently owns the card
	int player;


	// Default Card Constructor
	// sets coordinates (-1,-1).
	public Card() {
		top = rnd.nextInt(10) + 1;
		left = rnd.nextInt(10) + 1;
		right = rnd.nextInt(10) + 1;
		bottom = rnd.nextInt(10) + 1;
		elementTest = rnd.nextInt(3);
		if (elementTest == 0) {
			element = elements[rnd.nextInt(elements.length - 2)];
		}
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
			element = Element.CARDNULL;
		}
		
	}

	// Displays a card within the given
	// font, colors, and coordinates
	public void display(Font _font, Color _cardColor,
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

		StdDraw.text((x1+x0)/2, ((y1+y0)/2)+(.35*(y1-y0)) + .05,
			top == 10 ? "A" : String.valueOf(top));

		StdDraw.text(((x1+x0)/2)-(.35*(x1-x0)), (y1+y0)/2 + .05,
			left == 10 ? "A" : String.valueOf(left));

		StdDraw.text(((x1+x0)/2)+(.35*(x1-x0)), (y1+y0)/2 + .05,
			right == 10 ? "A" : String.valueOf(right));

		StdDraw.text((x1+x0)/2, ((y1+y0)/2)-(.35*(y1-y0)) + .05,
			bottom == 10 ? "A" : String.valueOf(bottom));

		// Draw card element
		String elem = "";
		switch (element) {
			case EARTH:
				elem = "Earth";
				break;
			case FIRE:
				elem = "Fire";
				break;
			case WATER:
				elem = "Water";
				break;
			case POISON:
				elem = "Poison";
				break;
			case HOLY:
				elem = "Holy";
				break;
			case LIGHTNING:
				elem = "Elec";
				break;
			case WIND:
				elem = "Wind";
				break;
			case ICE:
				elem = "Ice";
				break;
			case CARDNULL:
				elem = "Normal";
				break;
		}

		StdDraw.text((x1+x0)/2, (y1+y0)/2 + .05, elem);

	}


}