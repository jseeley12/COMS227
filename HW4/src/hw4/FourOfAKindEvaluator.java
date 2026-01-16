package hw4;

import java.util.ArrayList;

import api.Card;
import api.Hand;

/**
 * @author Josh Seeley
 * Evaluator for a hand containing (at least) four cards of the same rank. The
 * number of cards required is four.
 * 
 * The name of this evaluator is "Four of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */
	public FourOfAKindEvaluator(int ranking, int handSize) {
		// TODO: call appropriate superclass constructor and
		// perform other initialization
		super(ranking, handSize, "Four of a Kind", 4);
	}

	@Override
	public boolean canSatisfy(Card[] mainCards) {
		
		for (int i = 0; i < mainCards.length - 1; i++) {
			if (mainCards.length >= 4 && mainCards[i].getRank() == mainCards[i + 1].getRank()) {
				i++;
				if(mainCards[i].getRank() == mainCards[i+1].getRank()) {
					i++;
					if(mainCards[i].getRank() == mainCards[i+1].getRank()) {
						return true;
					}
				}
			}
		}
		return false;
	}

}