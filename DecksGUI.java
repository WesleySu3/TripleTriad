public class DecksGUI extends GUI {

	public DecksGUI() {

		/****************************
		|   index   |     box       |
		|---------------------------|
		|   0 - 4   |  P1 cards     |
		|   5 - 9   |  P2 cards     |
		|    10     |  randomize    |
		|    11     |  back button  |
		****************************/

		boxes = new Box[12];

		// P1 cards
		for (int i = 0; i < 5; i++) {
			boxes[i] = new Box(i+2.5, 4, i+3.5, 5, i);
		}

		// P2 cards
		for (int i = 5; i < 10; i++) {
			boxes[i] = new Box(i-2.5, 1, i-1.5, 2, i);
		}

		// Randomize button
		boxes[10] = new Box(4, 2.5, 5.5, 3.5, 10);

		// Back button
		boxes[11] = new Box(0, 6.5, 1, 7, 11);
	}




	public void draw() {
	}

	public void draw(Card[] _p1Deck,
					 Card[] _p2Deck) {

		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(5,3.5,5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(5, 6.5, "Player Select");

		StdDraw.setFont(papyrus48);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(1.25, 4.55, "Player 1");
		StdDraw.text(1.25, 1.55, "Player 2");

		for (int i = 0; i < 5; i++) {
			_p1Deck[i].display(papyrus24,
				StdDraw.LIGHT_GRAY, StdDraw.BLACK, StdDraw.BLACK,
				i+2.5, 4, i+3.5, 5);
			_p2Deck[i].display(papyrus24,
				StdDraw.LIGHT_GRAY, StdDraw.BLACK, StdDraw.BLACK,
				i+2.5, 1, i+3.5, 2);
		}

		StdDraw.setFont(papyrus32);

		// Randomize button
		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(4.75, 3, 0.75, 0.5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(4.75, 3.05, "Randomize");


		// Back Button
		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(.5, 6.75, .5, .25);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(.5, 6.8, "Back");

		StdDraw.show();

	}

}