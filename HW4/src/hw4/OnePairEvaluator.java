package hw4;
import api.Card;
import api.Hand;
import api.IEvaluator;

/**
 * @author Josh Seeley
 * 
 * Evaluator for a hand containing (at least) two cards of the same rank.
 * The number of cards required is two.
 * 
 * The name of this evaluator is "One Pair".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public OnePairEvaluator(int ranking, int handSize)
  {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	super(ranking, handSize, "One Pair", 2);
  }
@Override
  public boolean canSatisfy(Card[] mainCards) {
	for(int i = 0; i < mainCards.length-1; i++) {
	if(mainCards.length >= 2 && mainCards[i].getRank() == mainCards[i+1].getRank()) {		
	return true;
}
	
}
	return false; 
}
}