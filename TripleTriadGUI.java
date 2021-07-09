import java.awt.Color;
import java.awt.Font;

public class TripleTriadGUI extends GUI {

	Color playerColor = StdDraw.RED;

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
		|   14 - 18  |  P2 cards   |
		|   19       | undo button |
		|   20       | quit button |
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

        StdDraw.setPenColor(background);
		StdDraw.filledRectangle(18, 10.5, 18, 10.5);


		// Player 1's unplayed cards on left
		// side of screen
		for (int i = 1; i <= PLAYER_1_CARDS; i++) {
			if (!_board.p1Deck[i-1].played) {
				_board.p1Deck[i-1].display(papyrus16, 5, cardRed,
					StdDraw.BLACK, StdDraw.BLACK,
					5, i*3,
					8, (i+1)*3);
			}
		}

		// Player 2's unplayed cards on right
		// side of screen
		for (int i = 1; i <= PLAYER_2_CARDS; i++) {
			if (!_board.p2Deck[i-1].played) {
				_board.p2Deck[i-1].display(papyrus16, 5, cardBlue,
					StdDraw.BLACK, StdDraw.BLACK,
					28, i*3,
					31, (i+1)*3);
			}
		}

		// 3x3 playing grid
		for (int i = 0; i < BOARD_SIZE; i++) {
			boxes[i].display(papyrus32, "slot " + i, StdDraw.LIGHT_GRAY,
				StdDraw.BLACK, StdDraw.BLACK);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				_board.board[i][j].display(
					boxes[(i*3)+j].x0,
					boxes[(i*3)+j].y0,
					boxes[(i*3)+j].x1,
					boxes[(i*3)+j].y1);
			}
		}



        boxes[19].display(papyrus32, "Undo", button,
        	StdDraw.BLACK, StdDraw.BLACK);

        boxes[20].display(papyrus32, "Quit", button,
        	StdDraw.BLACK, StdDraw.BLACK);

        StdDraw.show();
	}
}