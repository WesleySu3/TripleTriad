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
		ChoosePlayersGUI choosePlayersGUI = new ChoosePlayersGUI();
		int choosePlayers;
		DecksGUI decksGUI = new DecksGUI();
		int decks;
		CardGUI cardGUI = new CardGUI();
		int card = -1;
		NumberGUI numberGUI = new NumberGUI();
		int number;
		ElementGUI elementGUI = new ElementGUI();
		int elementG;




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

				// *****************************
				// Player Select Menu
				case PLAYER_SELECT:
					do {
						choosePlayers = -1;
						choosePlayersGUI.draw(gameBoard.p1Type,
											  gameBoard.p2Type);

						while (choosePlayers < 0) {
							choosePlayers = choosePlayersGUI.getMove();
						}

						switch (choosePlayers) {
							case 0:
								gameBoard.p1Type = PlayerType.HUMAN;
								break;
							case 1:
								gameBoard.p1Type = PlayerType.EASY;
								break;
							case 2:
								gameBoard.p1Type = PlayerType.MEDIUM;
								break;
							case 3:
								gameBoard.p1Type = PlayerType.HARD;
								break;
							case 4:
								gameBoard.p2Type = PlayerType.HUMAN;
								break;
							case 5:
								gameBoard.p2Type = PlayerType.EASY;
								break;
							case 6:
								gameBoard.p2Type = PlayerType.MEDIUM;
								break;
							case 7:
								gameBoard.p2Type = PlayerType.HARD;
								break;
							case 8:
								curMenu = Menu.SETTINGS;
						}

					} while (choosePlayers < 8);

					break; // Repeat Master Loop

				// *****************************
				// Decks Menu
				case DECKS:
					do {
						decks = -1;
						decksGUI.draw(gameBoard.p1Deck,
									  gameBoard.p2Deck);

						while (decks < 0) {
							decks = decksGUI.getMove();
						}
						switch(decks) {
							case 10:
								gameBoard.randomizeDecks();
								break;
							case 11:
								curMenu = Menu.SETTINGS;
								break;
							default:
								gameBoard.playerChosen = decks / 5;
								gameBoard.cardChosen = decks % 5;
								if (gameBoard.playerChosen == 0) {
									gameBoard.curCard = gameBoard.p1Deck[gameBoard.cardChosen];
								} else {
									gameBoard.curCard = gameBoard.p2Deck[gameBoard.cardChosen];
								}
								curMenu = Menu.CARD;
								break;
						}
					} while (decks == 10);
					break; // Repeat Master Loop

				// *****************************
				// Modify-Card Menu
				case CARD:

					card = -1;
					cardGUI.draw(gameBoard.curCard);

					while (card < 0) {
						card = cardGUI.getMove();
					}

					if (0 <= card && card <= 3) {
						curMenu = Menu.CARD_VALUE;
						break;
					} else if (card == 4) {
						curMenu = Menu.CARD_ELEMENT;
						break;
					} else if (card == 5) {
						curMenu = Menu.DECKS;
						break;
					}
					break;
				// *****************************
				// Modify Card(numbers) Menu
				case CARD_VALUE:
					number = -1;
					numberGUI.draw(gameBoard.curCard, card);
					while (number < 0) {
						number = numberGUI.getMove();
					}
					// "card" will be in range [0,3]
					// representing top, left, right,
					// or bottom. This value comes
					// from the CardGUI above.
					switch (card) {
						case 0:
							gameBoard.curCard.top = number+1;
							break;
						case 1:
							gameBoard.curCard.left = number+1;
							break;
						case 2:
							gameBoard.curCard.right = number+1;
							break;
						case 3:
							gameBoard.curCard.bottom = number+1;
							break;
					}
					curMenu = Menu.CARD;
					break;
				// *****************************
				// Modify Card(element) Menu
				case CARD_ELEMENT:
					elementG = -1;
					elementGUI.draw(gameBoard.curCard, card);
					while (elementG < 0) {
						elementG = elementGUI.getMove();
					}
					gameBoard.curCard.element = TriadBoard.getElement(elementG);
					curMenu = Menu.CARD;
					break;
				case PLAY:
					System.out.println("Play Menu");
					break; // Repeat Master Loop
			}
		}

		if (gameBoard.p1Type == PlayerType.HUMAN) {
			players[0] = new HumanPlayer(1, tripleTriadGUI);
		} else if (gameBoard.p1Type == PlayerType.EASY) {
			players[0] = new LookAheadPlayer(1, 2);
		} else if (gameBoard.p1Type == PlayerType.MEDIUM) {
			players[0] = new LookAheadPlayer(1, 4);
		} else if (gameBoard.p1Type == PlayerType.HARD) {
			players[0] = new LookAheadPlayer(1, 8);
		}

		if (gameBoard.p2Type == PlayerType.HUMAN) {
			players[1] = new HumanPlayer(2, tripleTriadGUI);
		} else if (gameBoard.p2Type == PlayerType.EASY) {
			players[1] = new LookAheadPlayer(2, 2);
		} else if (gameBoard.p2Type == PlayerType.MEDIUM) {
			players[1] = new LookAheadPlayer(2, 4);
		} else if (gameBoard.p2Type == PlayerType.HARD) {
			players[1] = new LookAheadPlayer(2, 8);
		}

		tripleTriadGUI.draw(gameBoard, players[0]);

		int winner = play(gameBoard, tripleTriadGUI, players);


	}

	// Returns 0 if the game is a draw,
	// returns 1 or 2 if player 1 or 2 won.
	public static int play(TriadBoard _b, TripleTriadGUI _g,
		TriadPlayer[] _players) {

		Move curMove;
		do {
			StdDraw.clear();
			_g.draw(_b, _players[_b.nextTurn()-1]);
			StdDraw.show();
			while (true) {
				curMove = _players[_b.nextTurn()-1].decideMove(_b);
				_b.makeMove(curMove.card, curMove.cx);
				break;
			}



		} while (_b.isWinning() == 3);

		return _b.isWinning();













	}
}