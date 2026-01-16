package hw4;

import java.util.ArrayList;

import api.Card;
import api.Hand;

/**
 * @author Josh Seeley
 * 
 *         Evaluator for a hand containing (at least) three cards of the same
 *         rank. The number of cards required is three.
 * 
 *         The name of this evaluator is "Three of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class ThreeOfAKindEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */
	public ThreeOfAKindEvaluator(int ranking, int handSize) {
		// TODO: call appropriate superclass constructor and
		// perform other initialization
		super(ranking, handSize, "Three of a Kind", 3);
	}
@Override
	public boolean canSatisfy(Card[] mainCards) {
	for (int i = 0; i < mainCards.length - 1; i++) {
		if (mainCards.length == 3 && mainCards[i].getRank() == mainCards[i + 1].getRank()) {
			i++;
			if(mainCards[i].getRank() == mainCards[i-1].getRank()) {				
					return true;
			}
		}
	}
	return false;
	}

}
