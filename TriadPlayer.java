abstract class TriadPlayer {
	
	abstract String tag();

	abstract Move decideMove(TriadBoard _b);

	Card[] cards = new Card[5];

}