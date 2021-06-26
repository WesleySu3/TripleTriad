public class TripleTriad {
	public static void main(String[] args) {

		StdDraw.setCanvasSize(1800,1050);
		StdDraw.enableDoubleBuffering();

		TripleTriadGUI playGUI = new TripleTriadGUI();
		TriadBoard gameBoard = new TriadBoard();
		TriadPlayer[] players = new TriadPlayer[2];

		playGUI.draw(gameBoard, players[0]);

	}
}