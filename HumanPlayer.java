public class HumanPlayer extends TriadPlayer {

	int number; // 1 or 2

	TripleTriadGUI myGUI;

	public HumanPlayer(int _n, TripleTriadGUI _myGUI) {
		number = _n;
		myGUI = _myGUI;
	}

	public String tag() {
		return "Player " + number;
	}

	public Move decideMove(TriadBoard _b) {

		if (this.number == 1) {
			while (true) {

				int getCard = -1;
				int min = 9;
				int max = 13;
				while (getCard < 0) {
					getCard = myGUI.getMove();
					if (getCard < min || getCard > max) {
						getCard = -1;
					}
				}

				int getSlot = -1;
				while (getSlot < 0) {
					getSlot = myGUI.getMove();
					if (getSlot < 0 || getSlot > 8) {
						getSlot = -1;
					}
				}

				Coordinates cx = new Coordinates(getSlot/3, getSlot%3);

				Move mv = new Move(_b.p1Deck[getCard-9], cx);
				return mv;
				

			}
		} else {
			while (true) {
				int getCard = -1;
				int min = 14;
				int max = 18;
				while (getCard < 0) {
					getCard = myGUI.getMove();
					if (getCard < min || getCard > max) {
						getCard = -1;
					}
				}

				int getSlot = -1;
				while (getSlot < 0) {
					getSlot = myGUI.getMove();
					if (getSlot < 0 || getSlot > 8) {
						getSlot = -1;
					}
				}

				Coordinates cx = new Coordinates(getSlot/3, getSlot%3);

				Move mv = new Move(_b.p2Deck[getCard-14], cx);
				return mv;
			}
		}
		
		

	}

	

	



}