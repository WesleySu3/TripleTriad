public class SettingsGUI extends GUI {

	public SettingsGUI() {

		boxes = new Box[4];

		for (int i = 0; i < 4; i++) {
			boxes[i] = new Box(3, 3.5-i, 7, 4.5-i, i);
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
		StdDraw.text(5, 6.75, "Settings");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 4, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 4.05, "Rules");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 3, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 3.05, "Choose Sides");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 2, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 2.05, "Adjust Decks");

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(5, 1, 2, 0.4);
		StdDraw.setFont(papyrus32);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(5, 1.05, "Back");


		StdDraw.show();

	}
}