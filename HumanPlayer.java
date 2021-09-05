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

	public int decideMove(TriadBoard _b) {

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

				int mv = 100 + ((getCard - 9) * 10) + getSlot;
				// Move mv = new Move(_b.p1Deck[getCard-9], getSlot);
				
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

				int mv = 200 + ((getCard - 14) * 10) + getSlot;
				// Move mv = new Move(_b.p2Deck[getCard-14], getSlot);
				return mv;
			}
		}
		
		

	}

	

	



}