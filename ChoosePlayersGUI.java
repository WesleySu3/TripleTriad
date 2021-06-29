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



	}

	public void draw() {
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,7);
		StdDraw.clear();


	}

}