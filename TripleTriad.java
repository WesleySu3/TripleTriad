public class TripleTriad {
	public static void main(String[] args) {

		StdDraw.setCanvasSize(1350,787);
		StdDraw.enableDoubleBuffering();

		// ********************************
		// Game Elements

		TriadBoard gameBoard = new TriadBoard();
		TriadPlayer[] players = new TriadPlayer[2];


		// ********************************
		// GUI Elements

		RulesGUI rulesGUI = new RulesGUI();
		int rules;
		TripleTriadGUI tripleTriadGUI = new TripleTriadGUI();
		int tripleTriad;
		MainMenuGUI mainMenuGUI = new MainMenuGUI();
		int mainMenu;
		SettingsGUI settingsGUI = new SettingsGUI();
		int settings;




		// ********************************
		// Begin Master loop for menus

		Menu curMenu = Menu.MAIN;
		while (curMenu != Menu.PLAY) {

			switch(curMenu) {


				// *****************************
				// Main Menu
				case MAIN:

					mainMenu = -1;
					mainMenuGUI.draw();

					while (mainMenu < 0) {
						mainMenu = mainMenuGUI.getMove();
					}
					System.out.println(curMenu + " " + mainMenu);
					switch (mainMenu) {
						case 0:
							curMenu = Menu.PLAY;
							break;
						case 1:
							curMenu = Menu.SETTINGS;
							break;
						case 2:
							System.exit(0);
							break;
					}

					break; // Repeat Master Loop



				// *****************************
				// Settings Menu
				case SETTINGS:

					settings = -1;
					settingsGUI.draw();

					while (settings < 0) {
						settings = settingsGUI.getMove();
					}
					System.out.println(curMenu + " " + settings);
					switch (settings) {
						case 0:
							curMenu = Menu.RULES;
							break;
						case 1:
							curMenu = Menu.PLAYER_SELECT;
							break;
						case 2:
							curMenu = Menu.DECKS;
							break;
						case 3:
							curMenu = Menu.MAIN;
							break;
					}

					break; // Repeat Master Loop

				// *****************************
				// Rules Menu
				case RULES:

					
					do {
						rules = -1;
						rulesGUI.draw(gameBoard.open,
							          gameBoard.elemental,
							          gameBoard.plus,
							          gameBoard.same,
							          gameBoard.sameWall,
							          gameBoard.suddenDeath
				      				 );
			
						while (rules < 0) {
							rules = rulesGUI.getMove();
						}
						System.out.println(curMenu + " " + rules);

						switch(rules) {
							case 0:
								gameBoard.elemental = !gameBoard.elemental;
								break;
							case 1:
								gameBoard.plus = !gameBoard.plus;
								break;
							case 2:
								gameBoard.same = !gameBoard.same;
								break;
							case 3:
								gameBoard.sameWall = !gameBoard.sameWall;
								break;
							case 4:
								gameBoard.suddenDeath = !gameBoard.suddenDeath;
								break;
							case 5: curMenu = Menu.SETTINGS;
								break;
						}

									
					} while (rules < 5);

					break; // Repeat Master Loop


				case PLAYER_SELECT:
					System.out.println("Reached Player Select");
					curMenu = Menu.SETTINGS;
					break; // Repeat Master Loop

				case DECKS:
					System.out.println("Reached Decks");
					curMenu = Menu.SETTINGS;
					break; // Repeat Master Loop
				case PLAY:
					curMenu = Menu.PLAY;
					break; // Repeat Master Loop
			}
		}


		tripleTriadGUI.draw(gameBoard, players[0]);




	}
}