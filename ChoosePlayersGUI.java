public class ChoosePlayersGUI extends GUI {

	public ChoosePlayersGUI() {

		/***************************
		|  index  |     box        |
		|--------------------------|
		|  0 - 3  |  P1 toggles    |
		|  4 - 7  |  P2 toggles    |
		|    8    |  back button   |
		****************************/

		boxes = new Box[9];

		double start = 2.5;
		double end;
		for (int i = 0; i < 4; i++) {
			end = start + 1.5;
			boxes[i] = new Box(start, 4, end, 5, i);
			start = end;
		}

		start = 2.5;
		for (int i = 4; i < 8; i++) {
			end = start + 1.5;
			boxes[i] = new Box(start, 1, end, 2, i);
			start = end;
		}

		boxes[8] = new Box(0, 6.5, 1, 7, 8);
	}

	public void draw() {
	}

	public void draw(PlayerType _p1, PlayerType _p2) {
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setPenColor(background);
		StdDraw.filledRectangle(5,3.5,5,3.5);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(heading);
		StdDraw.text(5, 6.5, "Player Select");

		// P1 Toggles

		StdDraw.setFont(papyrus48);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(1.5, 4.55, "Player 1");

		StdDraw.setFont(papyrus32);

		StdDraw.setPenColor(_p1 == PlayerType.HUMAN ? selected : button);
		StdDraw.filledRectangle(3.25, 4.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(3.25, 4.55, "Human");

		StdDraw.setPenColor(_p1 == PlayerType.EASY ? selected : button);
		StdDraw.filledRectangle(4.75, 4.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(4.75, 4.55, "Easy AI");

		StdDraw.setPenColor(_p1 == PlayerType.MEDIUM ? selected : button);
		StdDraw.filledRectangle(6.25, 4.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(6.25, 4.55, "Medium AI");

		StdDraw.setPenColor(_p1 == PlayerType.HARD ? selected : button);
		StdDraw.filledRectangle(7.75, 4.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(7.75, 4.55, "Hard AI");

		StdDraw.setFont(heading);
		StdDraw.text(5, 3.15, "VS");

		// P2 Toggles

		StdDraw.setFont(papyrus48);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(1.5, 1.55, "Player 2");

		StdDraw.setFont(papyrus32);

		StdDraw.setPenColor(_p2 == PlayerType.HUMAN ? selected : button);
		StdDraw.filledRectangle(3.25, 1.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(3.25, 1.55, "Human");

		StdDraw.setPenColor(_p2 == PlayerType.EASY ? selected : button);
		StdDraw.filledRectangle(4.75, 1.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(4.75, 1.55, "Easy AI");

		StdDraw.setPenColor(_p2 == PlayerType.MEDIUM ? selected : button);
		StdDraw.filledRectangle(6.25, 1.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(6.25, 1.55, "Medium AI");

		StdDraw.setPenColor(_p2 == PlayerType.HARD ? selected : button);
		StdDraw.filledRectangle(7.75, 1.5, .75, .5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(7.75, 1.55, "Hard AI");

		// Back Button

		StdDraw.setPenColor(button);
		StdDraw.filledRectangle(.5, 6.75, .5, .25);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(.5, 6.8, "Back");

		StdDraw.show();

	}

}