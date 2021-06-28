public class ChoosePlayersGUI extends GUI {

	public ChoosePlayersGUI(boolean _humanP1,
							boolean _humanP2) {

		/***************************
		|  index  |     box        |
		|--------------------------|
		|  0 - 3  |  P1 toggle     |
		|  4 - 7  |  P2 toggle     |
		|   10    |  back button   |
		****************************/

		boxes = new Box[11];

		for (int i = 0; i < 4; i++) {
			boxes[i] = new Box(i+1, 4, i+2, 5, i);
		}

	}

	public void draw() {
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		// ****************************************
		// Checkered background
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.GRAY);
                }
                StdDraw.filledRectangle(j+.5,i+.5,.5,.5);
            }
        }
	}

}