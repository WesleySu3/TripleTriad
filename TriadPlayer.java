abstract class TriadPlayer {
	
	abstract String tag();

	abstract int decideMove(TriadBoard _b);

	Card[] cards = new Card[5];

}