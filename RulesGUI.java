import java.awt.Font;

public class RulesGUI extends GUI {

	Font largeFont = new Font("Arial", Font.BOLD, 32);

	public RulesGUI() {

		/***************************
		|   index  |    box        |
		| -----------------------  |
		|     0    |  Elemental    |
		|     1    |  Plus         |
		|     2    |  Same         |
		|     3    |  Same Wall    |
		|     4    |  Sudden Death |
		|     5    |  Confirm      |
		|     6    |  Quit button  |
		***************************/

		boxes = new Box[7];
		for (int i = 0; i < 5; i++) {
			boxes[i] = new Box(7, 5-i, 8, 6-i, i); // Rule toggles
		}
		boxes[5] = new Box(9,6,10,7,5); // Confirm
		boxes[6] = new Box(0,6,1,7,6); // Quit
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

		StdDraw.setFont(largeFont);

		// ****************************************
		// Checkered background
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.WHITE);
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
    	StdDraw.text(5,5.5,"Elemental");
    	StdDraw.setPenColor(elem_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,5.5,0.25);
    	StdDraw.setPenColor(elem_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.text(7.5,5.5, elem_ ? "ON" : "OFF");

    	// Plus
		StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,4.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(5,4.5,"Plus");
    	StdDraw.setPenColor(plus_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,4.5,0.25);
    	StdDraw.setPenColor(plus_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.text(7.5,4.5, plus_ ? "ON" : "OFF");

    	// Same
		StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,3.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(5,3.5,"Same");
    	StdDraw.setPenColor(same_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,3.5,0.25);
    	StdDraw.setPenColor(same_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.text(7.5,3.5, same_ ? "ON" : "OFF");

    	// SameWall
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,2.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(5,2.5,"Same Wall");
    	StdDraw.setPenColor(wall_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,2.5,0.25);
    	StdDraw.setPenColor(wall_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.text(7.5,2.5, wall_ ? "ON" : "OFF");

    	// SuddenDeath
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(5,1.5,3,.4);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(5,1.5,"Sudden Death");
    	StdDraw.setPenColor(sudden_ ? StdDraw.GREEN : StdDraw.RED);
    	StdDraw.filledCircle(7.5,1.5,0.25);
    	StdDraw.setPenColor(sudden_ ? StdDraw.WHITE : StdDraw.BLACK);
    	StdDraw.text(7.5,1.5, sudden_ ? "ON" : "OFF");

    	// ***************************************
    	// Control Sequences

    	// Confirm button
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(9.5,6.75,.5,.25);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(9.5,6.75,"Confirm");

    	// Quit button
    	StdDraw.setPenColor(StdDraw.BLUE);
    	StdDraw.filledRectangle(0.5,6.75,.5,.25);
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.text(0.5,6.75,"Quit");

    	StdDraw.show();

	}

}