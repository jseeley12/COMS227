package hw4;
/**
 * @author Josh Seeley
 */
import java.util.ArrayList;

import api.Card;
import api.Hand;

/**
 * Evaluator for a hand in which the rank of each card is a prime number. The
 * number of cards required is equal to the hand size.
 * 
 * The name of this evaluator is "All Primes".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class AllPrimesEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */
	public AllPrimesEvaluator(int ranking, int handSize) {
		// TODO: call appropriate superclass constructor and
		// perform other initialization

		super(ranking, handSize, "All Primes", handSize);
	}

	@Override
	public boolean canSatisfy(Card[] mainCards) {
		int[] primeNums = { 2, 3, 5, 7, 11, 13 };
		int count = 0;
		for (int i = 0; i < mainCards.length; i++) {
			for (int j = 0; j < primeNums.length - 1; j++) {
				if (mainCards[i].getRank() == primeNums[j]) {
					count++;
					break;
				}
			}
			if (count == handSize()) {
				return true;
			}
		}
		return false;
	}
}
	