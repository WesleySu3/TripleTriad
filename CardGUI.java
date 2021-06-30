public class CardGUI extends GUI {
	
	public CardGUI() {

		/**********************
		|  index  |   box     |
		|---------------------|
		|    0    |  top      |
		|    1    |  left     |
		|    2    |  right    |
		|    3    |  bottom   |
		|    4    |  element  |
		|    5    |  Confirm  |
		**********************/

		boxes = new Box[6];

		// Top
		boxes[0] = new Box(4.4, 4.3, 4.6, 4.6, 0);
		// Left
		boxes[1] = new Box(3.4, 3.3, 3.6, 3.7, 1);
		// Right
		boxes[2] = new Box(5.4, 3.3, 5.6, 3.7, 2);
		// Bottom
		boxes[3] = new Box(4.4, 2.3, 4.6, 2.6, 3);

		// Element
		boxes[4] = new Box(3.9, 3.4, 5.1, 3.6, 4);

		// Confirm button
		boxes[5] = new Box(3.75, 0.6, 5.25, 1.4, 5);
	}

	public void draw(){
	}

	public void draw(Card _c) {

		StdDraw.setXscale(0,9);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(4.5,3.5,4.5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(4.5, 6.25, "Modify Card");

		_c.display(papyrus32, 5, StdDraw.LIGHT_GRAY,
			StdDraw.BLACK, StdDraw.BLACK,
			3, 2, 6, 5);

		// Confirm Button
		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(4.5, 1, 0.75, 0.4);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(4.5, 1.05, "Confirm");

		StdDraw.show();


	}

}