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
		
		Move mv = new Move();
		return mv;
		// TODO
		// After GUI is working,
		// click on card, then slot

	}

	

	



}