public class MainMenuGUI extends GUI {

	public MainMenuGUI() {

		/**********************
		|  index  |   box     |
		|---------------------|
		|    0    |  play     |
		|    1    |  settings |
		|    2    |  quit     |
		***********************/

		boxes = new Box[3];

		for (int i = 0; i < 3; i++) {
			boxes[i] = new Box(3, 3-i, 7, 4-i, i);
		}
		
	}

	public void draw() {

		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(5,3.5,5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(5, 6.25, "Triple Triad");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 3.5, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 3.55, "Play");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 2.5, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 2.55, "Settings");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 1.5, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 1.55, "Quit");


		StdDraw.show();

	}



}