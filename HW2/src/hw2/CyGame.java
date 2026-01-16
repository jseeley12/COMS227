package hw2;

import java.lang.String;

/**
 * Model of a Monopoly-like game. Two players take turns rolling dice to move
 * around a board. The game ends when one of the players has at least
 * MONEY_TO_WIN money or one of the players goes bankrupt (has negative money).
 * 
 * @author Josh Seeley
 */
public class CyGame {
	/**
	 * Do nothing square type.
	 */
	public static final int DO_NOTHING = 0;
	/**
	 * Pass go square type.
	 */
	public static final int PASS_GO = 1;
	/**
	 * Cyclone square type.
	 */
	public static final int CYCLONE = 2;
	/**
	 * Pay the other player square type.
	 */
	public static final int PAY_PLAYER = 3;
	/**
	 * Get an extra turn square type.
	 */
	public static final int EXTRA_TURN = 4;
	/**
	 * Jump forward square type.
	 */
	public static final int JUMP_FORWARD = 5;
	/**
	 * Stuck square type.
	 */
	public static final int STUCK = 6;
	/**
	 * Points awarded when landing on or passing over go.
	 */
	public static final int PASS_GO_PRIZE = 200;
	/**
	 * The amount payed to the other player per unit when landing on a PAY_PLAYER
	 * square.
	 */
	public static final int PAYMENT_PER_UNIT = 20;
	/**
	 * The amount of money required to win.
	 */
	public static final int MONEY_TO_WIN = 400;
	/**
	 * The cost of one unit.
	 */
	public static final int UNIT_COST = 50;
	/**
	 * Current Player of game. Starts at player 1.
	 */
	private int currentPlayer = 1;
	/**
	 * Current money of player 1.
	 */
	private int money1;
	/**
	 * Current money of player 2.
	 */
	private int money2;
	/**
	 * Current property units of player 1.
	 */
	private int propertyUnits1 = 1;
	/**
	 * Current property units of player 2.
	 */
	private int propertyUnits2 = 1;
	/**
	 * Checks if game is over depending on MONEY_TO_WIN OR if money is in the
	 * negative.
	 */
	private boolean gameOver;
	/**
	 * Current square of player 1. initialized to 0 for beginning of game
	 */
	private int currentSquare1 = 0;
	/**
	 * Current square of player 2. initializes to 0 for beginning of game.
	 */
	private int currentSquare2 = 0;
	/**
	 * The total amount of board squares on the board. Set by the user
	 */
	private int numSquares;
	// TODO: EVERTHING ELSE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The method below is provided for you and you should not modify it.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.

	/**
	 * Constructs a game.
	 *  Starts a game given squares and starting money and both players on square 0
	 *  Both players also are given 1 property unit each
	 * 	Initially player 1's turn to start.
	 * 
	 * @param numSquares    the total amount of squares in the game
	 * @param startingMoney the amount of money each player starts with
	 * 
	 */
	public CyGame(int numSquares, int startingMoney) {
		this.numSquares = numSquares;
		money1 = startingMoney;
		money2 = startingMoney;
	}

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player 1*: (0, 0, $0) Player 2: (0, 0, $0)</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which players turn it is.
	 * The numbers (0, 0, $0) indicate which square the player is on, how many units
	 * the player has, and how much money the player has respectively.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player 1%s: (%d, %d, $%d) Player 2%s: (%d, %d, $%d)";
		String player1Turn = "";
		String player2Turn = "";
		if (getCurrentPlayer() == 1) {
			player1Turn = "*";
		} else {
			player2Turn = "*";
		}
		return String.format(fmt, player1Turn, getPlayer1Square(), getPlayer1Units(), getPlayer1Money(), player2Turn,
				getPlayer2Square(), getPlayer2Units(), getPlayer2Money());
	}

	/**
	 * This method checks for many variables to see if the player is qualified to
	 * buy a unit. If so, unit is bought and money is deducted from their money
	 * count.
	 * 
	 */

	public void buyUnit() {

		if (gameOver == false && money1 < 400 && money2 < 400) {
			int buy = getSquareType(currentSquare1);
			int bu = getSquareType(currentSquare2);
			if (buy == DO_NOTHING || bu == DO_NOTHING) {

				if (currentPlayer == 1 && money1 > 49) {
					money1 = money1 - UNIT_COST;
					propertyUnits1 += 1;
				}
				if (currentPlayer != 1 && money2 > 49) {
					money2 = money2 - UNIT_COST;
					propertyUnits2 += 1;
				}
			}
			if (currentPlayer == 1 && money1 >= 1 && money1 <= 49) {
				endTurn();
			} else if (currentPlayer != 1 && money2 >= 1 && money2 <= 49) {
				endTurn();
			}
			endTurn();
		}

	}

	/**
	 * Ends turn of currentPlayer. Switches player.
	 */
	public void endTurn() {
		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else {
			currentPlayer = 1;
		}

	}

	/**
	 * @return currentPlayer the current player of the game.
	 */
	public int getCurrentPlayer() {

		return currentPlayer;
	}

	/**
	 * @return money1 The total money of player 1.
	 */
	public int getPlayer1Money() {

		return money1;
	}

	/**
	 * @return money2 The total money of player 2.
	 */
	public int getPlayer2Money() {

		return money2;
	}

	/**
	 * @return propertyUnits1 The total property units of player 1.
	 */
	public int getPlayer1Units() {

		return propertyUnits1;
	}

	/**
	 * @return propertyUnits2 The total property units of player 2.
	 */
	public int getPlayer2Units() {

		return propertyUnits2;
	}

	/**
	 * @return currentSquare1 The current square player 1 is on depending on actions
	 *         taken during turn
	 */
	public int getPlayer1Square() {

		return currentSquare1;
	}

	/**
	 * @return currentSquare2 The current square player 2 is on depending on actions
	 *         taken during turn
	 */
	public int getPlayer2Square() {

		return currentSquare2;
	}

	/**
	 * This method finds the square type of the current square your on given the
	 * roll. Each square is assigned a single type.
	 * 
	 * @param square This value takes an input and finds what square does what to
	 *               the current player.
	 * @return square returns the type of square the player is on.
	 */
	public int getSquareType(int square) {

		int five = square % 5;
		int seven = square % 7;
		int three = square % 3;
		int two = square % 2;
		int eleven = square % 11;
		int nSquares = numSquares - 1;
		if (square == 0) {
			square = PASS_GO;
		} else if (square == nSquares) {
			square = CYCLONE;
		} else if (five == 0) {
			square = PAY_PLAYER;
		} else if (seven == 0 || eleven == 0) {
			square = EXTRA_TURN;
		} else if (three == 0) {
			square = STUCK;
		} else if (two == 0) {
			square = JUMP_FORWARD;
		} else {
			square = DO_NOTHING;
		}

		return square;

	}

	/**
	 *This method is called to indicate dice has been rolled. It advances
	 *the current player forward by the a number of squares determined by the number rolled.
	 *If current player is on STUCK, player has to roll an even number.
	 *PASS_GO square if passed by a player gets PASS_GO_PRIZE.
	 *Applies the action of the square the player lands on.
	 * 
	 * @param value The value is the number rolled from the dice 1-6.
	 * 
	 */
	public void roll(int value) {
//checks if stuck and checks if roll is even
		if (gameOver == false && money1 < 400 && money2 < 400) {

			int cSt = getSquareType(currentSquare1);
			int vSt = getSquareType(currentSquare2);
			if (cSt == STUCK && currentPlayer == 1) {
				int i = value % 2;
				if (i == 0) {

				} else {
					currentSquare1 -= value;
				}
			}
			if (vSt == STUCK && currentPlayer != 1) {
				int i = value % 2;
				if (i == 0) {
				} else {
					currentSquare2 -= value;

				}
			}

//incrementing and PASS_GO method for player 1
			if (currentPlayer == 1 && currentSquare1 != STUCK) {

				currentSquare1 += value;
				int nSquares = numSquares;
				if (currentSquare1 >= nSquares) {
					money1 += PASS_GO_PRIZE;
					if (currentSquare1 == 0) {
						currentSquare1 = PASS_GO;
					}
					int rSquares = currentSquare1 - nSquares;
					currentSquare1 = rSquares;
				}

			}
//incrementing and PASS_GO method for player 2
			if (currentPlayer != 1 && currentSquare2 != STUCK) {

				currentSquare2 += value;
				int nSquares = numSquares - 1;
				if (currentSquare2 > nSquares) {
					money2 += PASS_GO_PRIZE;

					if (currentSquare2 == 0) {
						currentSquare2 = PASS_GO;
					}
					int rSquares = currentSquare2 - nSquares;
					currentSquare2 = rSquares;

				}
			}

			// player 1 turn
			if (currentPlayer == 1) {
				int check = getSquareType(currentSquare1);
				if (check == JUMP_FORWARD && check != STUCK) {
					currentSquare1 += 4;
					int nSquares = numSquares;
					if (currentSquare1 > nSquares) {
						money1 += PASS_GO_PRIZE;
						if (currentSquare1 == 0) {
							currentSquare1 = PASS_GO;
						}
						int rSquares = currentSquare1 - nSquares;
						currentSquare1 = rSquares;
					}
				}
				if (check == PAY_PLAYER && check != STUCK) {
					int payment = PAYMENT_PER_UNIT * propertyUnits2;
					money1 = money1 - payment;
					money2 = money2 + payment;
				}
				if (check == CYCLONE && check != STUCK) {
					currentSquare1 = currentSquare2;
				}
				if (check == EXTRA_TURN && check != STUCK) {
					if (currentPlayer == 1) {
						currentPlayer = 1;
					}
					if (currentPlayer != 1) {
						currentPlayer = 2;
					}
				}
			}
// player 2 turn
			if (currentPlayer != 1) {
				int check = getSquareType(currentSquare2);
				if (check == JUMP_FORWARD && currentSquare2 != STUCK) {
					currentSquare2 += 4;
					int nSquares = numSquares;
					if (currentSquare1 >= nSquares) {
						money1 += PASS_GO_PRIZE;
						if (currentSquare1 == 0) {
							currentSquare1 = PASS_GO;
						}
						int rSquares = currentSquare1 - nSquares;
						currentSquare1 = rSquares;
					}
				}
				if (check == PAY_PLAYER && currentSquare2 != STUCK) {
					int payment = PAYMENT_PER_UNIT * propertyUnits1;
					money2 = money2 - payment;
					money1 = money1 + payment;
				}
				if (check == CYCLONE && check != STUCK) {
					currentSquare2 = currentSquare1;
				}
				if (check == EXTRA_TURN) {
					if (currentPlayer == 1) {
						currentPlayer = 1;
					}
					if (currentPlayer != 1) {
						currentPlayer = 2;
					}
				}
			}
//check for extra turn
			int yes = getSquareType(currentSquare2);
			int no = getSquareType(currentSquare1);
			if (yes != EXTRA_TURN && no != EXTRA_TURN) {
				endTurn();
			}
		}
	}

	/**
	 * This method checks if the game has ended.
	 * Game is over when either player has at least MONEY_TO_WIN or either player has
	 * a negative amount of money.
	 * @return gameOver returns either true or false. True if game is over and false
	 *         if it isn't.
	 */

	public boolean isGameEnded() {

		if (money1 >= MONEY_TO_WIN || money1 < 0 || money2 >= MONEY_TO_WIN || money2 < 0) {
			gameOver = true;
		} else {
			gameOver = false;
		}
		return gameOver;
	}

	/**
	 * This method sells a property unit given if the player passes the
	 * conditionals. If allowed the current player gets paid the UNIT_COST.
	 * If the current player successfully sells a unit their turn ends.
	 * if not they still have their turn.
	 */
	public void sellUnit() {
		if (propertyUnits1 > 0 && propertyUnits2 > 0) {
			if (gameOver == false && money1 < 400 && money2 < 400) {
				if (propertyUnits1 >= 1) {
					if (currentPlayer == 1) {
						money1 = money1 + UNIT_COST;
						propertyUnits1 -= 1;

					}
				}
				if (propertyUnits2 >= 1) {
					if (currentPlayer != 1) {
						money2 = money2 + UNIT_COST;
						propertyUnits2 -= 1;
					}
				}
			}
			endTurn();
		}
	}
}
