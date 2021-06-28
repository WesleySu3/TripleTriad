public class LookAheadPlayer extends TriadPlayer {
	
	int number; // 1 or 2
  	int lookahead;

  	public LookAheadAIPlayer(int _number, int _lookahead) {
	    number = _number;
	    lookahead = _lookahead;
  	}

    public String callSign() {
  		switch(lookahead) {
		    case(2): return "Easy AI";
		    case(4): return "Medium AI";
		    case(6): return "Hard AI";
    	}
    }

    public Move decideMove(TriadBoard _b) {

		// TODO
		// After GUI is working,
		// click on card, then slot

	}

}