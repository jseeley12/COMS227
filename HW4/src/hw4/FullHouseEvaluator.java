package hw4;

import api.Card;
import api.Hand;

/**
 *@author Josh Seeley 
 * 
 * Evaluator for a generalized full house. The number of required cards is equal
 * to the hand size. If the hand size is an odd number n, then there must be (n
 * / 2) + 1 cards of the matching rank and the remaining (n / 2) cards must be
 * of matching rank. In this case, when constructing a hand, the larger group
 * must be listed first even if of lower rank than the smaller group</strong>
 * (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]). If the hand size is even, then
 * half the cards must be of matching rank and the remaining half of matching
 * rank. Any group of cards, all of which are the same rank, always satisfies
 * this evaluator.
 * 
 * The name of this evaluator is "Full House".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */
	public FullHouseEvaluator(int ranking, int handSize) {
		// TODO: call appropriate superclass constructor and
		// perform other initialization
		super(ranking, handSize, "Full House", handSize);
	}

	public boolean canSatisfy(Card[] mainCards) {
		boolean isFullHouse = false;
		for (int i = 0; i < mainCards.length - 1; i++) {
			if (mainCards[i].getRank() == mainCards[i + 1].getRank()) {
				for (int j = i; j < mainCards.length - 1; j++) {
					if (mainCards[i].getRank() == mainCards[j + 1].getRank()) {
						isFullHouse = true;
					}
				}
			}
		}
		for (int i = 3; i < mainCards.length - 1; i++) {
			if (mainCards[i].getRank() == mainCards[i + 1].getRank()) {
				isFullHouse = true;
			}
		}

		return isFullHouse;

	}
}