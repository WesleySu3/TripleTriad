public class DecksGUI extends GUI {

	public DecksGUI(Card[] _p1Cards,
						Card[] _p2Cards) {

		/*****************************
		|   index    |     box       |
		|----------------------------|
		|   0 - 4    |  P1 cards     |
		|   5 - 9    |  P2 cards     |
		|    10      |  play button  |
		|    11      |  back button  |
		*****************************/

		boxes = new Box[12];

		for (int i = 0; i < 5; i++) {
			boxes[i] = new Box(i+1, 3, i+2 , 4, i);
		}

	}




	public void draw() {
	}

}