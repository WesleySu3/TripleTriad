public class NumberGUI extends GUI {

	public NumberGUI() {

		/***********************
		|  index  |   box      |
		|----------------------|
		|    0    |  Assign 1  |
		|    1    |  Assign 2  |
		|    2    |  Assign 3  |
		|    3    |  Assign 4  |
		|    4    |  Assign 5  |
		|    5    |  Assign 6  |
		|    6    |  Assign 7  |
		|    7    |  Assign 8  |
		|    8    |  Assign 8  |
		|    9    |  Assign A  |
		***********************/

		boxes = new Box[10];

		for (int i = 0; i < 10; i++) {
			boxes[i] = new Box((i%2) + 6, 5 - (i/2),
				(i%2) + 7, 6 - (i/2), i);
		}
		
	}

	public void draw(){
	}

	public void draw(Card _c, int value) {

		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(5,3.5,5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(3.5, 6.25, "Set Value");

		_c.display(papyrus32, value, StdDraw.LIGHT_GRAY,
			StdDraw.BLACK, StdDraw.BLACK,
			2, 2, 5, 5);

		for (int i = 0; i < 9; i++) {
			boxes[i].display(papyrus24, String.valueOf(i+1),
				StdDraw.LIGHT_GRAY, StdDraw.BLACK, StdDraw.BLACK);
		}
		// Last box is done seperately because
		// 10 is represented with an A
		boxes[9].display(papyrus24, "A",
				StdDraw.LIGHT_GRAY, StdDraw.BLACK, StdDraw.BLACK);

		StdDraw.show();

	}


}