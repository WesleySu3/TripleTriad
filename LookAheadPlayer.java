public class LookAheadPlayer extends TriadPlayer {
	
	int number; // 1 or 2
  	int lookahead;

  	public LookAheadPlayer(int _number, int _lookahead) {
	    number = _number;
	    lookahead = _lookahead;
  	}

    public String tag() {
  		switch(lookahead) {
		    case(2): return "Easy AI";
		    case(4): return "Medium AI";
		    case(8): return "Hard AI";
    	}
    	return "Mystery AI";
    }

    public Move decideMove(TriadBoard _b) {

    	Move mv = new Move();
		return mv;

	}

}