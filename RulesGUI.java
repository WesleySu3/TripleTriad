public class RulesGUI extends GUI {

	public RulesGUI() {

		/***************************
		|   index  |    box        |
		| -----------------------  |
		|     0    |  Elemental    |
		|     1    |  Plus         |
		|     2    |  Same         |
		|     3    |  Same Wall    |
		|     4    |  Sudden Death |
		|     5    |  back button  |
		***************************/

		boxes = new Box[7];
		for (int i = 0; i < 5; i++) {
			boxes[i] = new Box(7, 5-i, 8, 6-i, i); // Rule toggles
		}

		// No longer using play button in this menu
		// boxes[5] = new Box(9,6,10,7,5); // Play
		boxes[5] = new Box(0,6,1,7,5); // Back
	}

	public void draw() {
	}

	public void draw(boolean open_,
					 boolean elem_,
					 boolean plus_,
					 boolean same_,
					 boolean wall_,
					 boolean sudden_
					) {

		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();

		StdDraw.setFont(papyrus32);

		// ****************************************
		// Checkered background
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledRectangle(j+.5,i+.5,.5,.5);
            }
        }


        // ****************************************
		// Toggles


		// Elemental
		StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,5.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.setFont(papyrus32);
    	StdDraw.text(5,5.55,"Elemental");
    	StdDraw.setPenColor(elem_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,5.5,0.25);
    	StdDraw.setPenColor(elem_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.setFont(papyrus16);
    	StdDraw.text(7.5,5.55, elem_ ? "ON" : "OFF");

    	// Plus
		StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,4.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.setFont(papyrus32);
    	StdDraw.text(5,4.55,"Plus");
    	StdDraw.setPenColor(plus_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,4.5,0.25);
    	StdDraw.setPenColor(plus_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.setFont(papyrus16);
    	StdDraw.text(7.5,4.55, plus_ ? "ON" : "OFF");

    	// Same
		StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,3.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.setFont(papyrus32);
    	StdDraw.text(5,3.55,"Same");
    	StdDraw.setPenColor(same_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,3.5,0.25);
    	StdDraw.setPenColor(same_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.setFont(papyrus16);
    	StdDraw.text(7.5,3.55, same_ ? "ON" : "OFF");

    	// SameWall
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,2.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.setFont(papyrus32);
    	StdDraw.text(5,2.55,"Same Wall");
    	StdDraw.setPenColor(wall_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,2.5,0.25);
    	StdDraw.setPenColor(wall_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.setFont(papyrus16);
    	StdDraw.text(7.5,2.55, wall_ ? "ON" : "OFF");

    	// SuddenDeath
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,1.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.setFont(papyrus32);
    	StdDraw.text(5,1.55,"Sudden Death");
    	StdDraw.setPenColor(sudden_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,1.5,0.25);
    	StdDraw.setPenColor(sudden_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.setFont(papyrus16);
    	StdDraw.text(7.5,1.55, sudden_ ? "ON" : "OFF");

    	// ***************************************
    	// Control Sequences

    	// No longer using play button in this menu
    	// Play button
    	// StdDraw.setPenColor(StdDraw.BLUE);
    	// StdDraw.filledRectangle(9.5,6.75,.5,.25);
    	// StdDraw.setPenColor(StdDraw.WHITE);
    	// StdDraw.setFont(papyrus32);
    	// StdDraw.text(9.5,6.8,"Play");

    	// Quit button
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(0.5,6.75,.5,.25);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(0.5,6.8,"Back");

    	StdDraw.show();

	}

}