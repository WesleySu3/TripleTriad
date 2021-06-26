public class TripleTriadGUI extends GUI {


	// Each of these has a box
	static int BOARD_SIZE = 9;
	static int PLAYER_1_CARDS = 5;
	static int PLAYER_2_CARDS = 5;
	static int UNDO = 1;
	static int QUIT = 1;
	static int NUM_BOXES = BOARD_SIZE +
						   PLAYER_1_CARDS +
						   PLAYER_2_CARDS +
						   UNDO +
						   QUIT;

	public TripleTriadGUI() {


		/***************************
		|   index    |    box      |
		| -----------------------  |
		|   0 - 8    |    grid     |
		|   9 - 13   |  P1 cards   |
		|  14 - 18   |  P2 cards   |
		|    19      | undo button |
		|    20      | quit button |
		***************************/

		boxes = new Box[NUM_BOXES];

		for (int i = 0; i < BOARD_SIZE; i++)
			boxes[i] = new Box( ((i%3) + 3) * 4,     // x0
								(i/3) * 5 + 3,       // y0
								((i%3) + 3) * 4 + 4, // x1
								(i/3) * 5 + 3 + 5,   // y1
								i // Boxcode
							  );

		for (int i = 1; i <= PLAYER_1_CARDS; i++)
			boxes[i+8] = new Box(5,   	  // x0
								 i*3, 	  // y0
								 8,	  	  // x1
								 (i+1)*3, // y1
								 i+8  	  // Boxcode
							    );

		for (int i = 1; i <= PLAYER_2_CARDS; i++)
			boxes[i+13] = new Box(28,   	  // x0
								 i*3, 	  	  // y0
								 31,	  	  // x1
								 (i+1)*3,     // y1
								 i+13  	      // Boxcode
							    );

		boxes[19] = new Box(32, 19.5, 36, 21, 19); // UNDO
		boxes[20] = new Box(32, 0, 36, 1.5, 20);   // QUIT
	}

	// Abstract draw from GUI.java needs to be overriden
	public void draw() {
    	return;
  	}

	public void draw(TriadBoard _board, TriadPlayer _player) {

		StdDraw.setXscale(0,36);
    	StdDraw.setYscale(0,21);
        StdDraw.clear();

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < NUM_BOXES; i++) {
        	System.out.println("Boxcode " + i
        		+ ": " + boxes[i].x0
        		+ " " + boxes[i].y0
        		+ " " + boxes[i].x1
        		+ " " + boxes[i].y1);
        	StdDraw.rectangle(
        		(boxes[i].x0+boxes[i].x1)/2,
        		(boxes[i].y0+boxes[i].y1)/2,
        		(boxes[i].x1-boxes[i].x0)/2,
        		(boxes[i].y1-boxes[i].y0)/2
        	);
        }

        StdDraw.show();
	}
}