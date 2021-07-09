public class ElementGUI extends GUI {

	public ElementGUI() {

		/*************************
		|  index  |    box       |
		|------------------------|
		|    0    |  Normal    	 |
		|    1    |  Earth       |
		|    2    |  Fire        |
		|    3    |  Water       |
		|    4    |  Poison      |
		|    5    |  Holy        |
		|	 6	  |  Lightning   |
		|	 7	  |  Wind        |
		|	 8    |  Ice         |
		**************************/

		boxes = new Box[9];

		for (int i = 0; i < 9; i++) {
			boxes[i] = new Box((i%3) + 5.5, 4 - (i/3),
				(i%3) + 6.5, 5 - (i/3), i);
		}

	}

	public void draw() {
	}

	public void draw(Card _c, int value) {

		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(5,3.5,5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(5, 6.25, "Set Element");

		_c.display(papyrus32, 4, StdDraw.LIGHT_GRAY,
			StdDraw.BLACK, StdDraw.BLACK,
			1.5, 2, 4.5, 5);

		for (int i = 0; i < 9; i++) {
			boxes[i].display(papyrus24,
				TriadBoard.getElementName(TriadBoard.getElement(i)),
				StdDraw.LIGHT_GRAY, StdDraw.BLACK, StdDraw.BLACK);
		}


		StdDraw.show();

	}
}