package hw4;
/**
 * @author Josh Seeley
 */
import api.Hand;
import api.IEvaluator;
import util.SubsetFinder;

import java.util.ArrayList;

import api.Card;

/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 * 
 * TODO: Expand this comment with an explanation of how your class hierarchy is
 * organized.
 * 
 * IEvaluator is parent interface- AbstractEvaluator extends IEvaluator-
 * AbstractEvaluator is extended by - FourOfAKindEvaluator,
 * ThreeOfAKindEvaluator, OnePairEvaluator, AllPrimesEvaluator,
 * CatchAllEvaluator, FullHouseEvaluator, StraightEvaluator and
 * StraightFlushEvaluator.
 * 
 * 
 */
public abstract class AbstractEvaluator implements IEvaluator {
	/**
	 * Name of hand evaluator
	 */
	private String name;
	/**
	 * The ranking of hand
	 */
	private int ranking;
	/**
	 * The handSize. Returns the number of cards in a hand. This value is generally
	 * defined by a game
	 */
	private int handSize;
	/**
	 * This is the amount of cards required to make a hand for the given evaluator
	 * type
	 */
	private int requiredCards;
	/**
	 * This is the max card rank. gives the highest rank possible for the card
	 */
	private int maxCardR;

	/**
	 * @param ranking
	 * @param handSize
	 * @param name
	 * @param requiredCards
	 * 
	 */
	protected AbstractEvaluator(int ranking, int handSize, String name, int requiredCards) {
		this.name = name;
		this.handSize = handSize;
		this.ranking = ranking;
		this.requiredCards = requiredCards;

	}

	/**
	 * 
	 * @param ranking
	 * @param handSize
	 * @param name
	 * @param requiredCards
	 * @param maxCardR
	 * 
	 */
	protected AbstractEvaluator(int ranking, int handSize, String name, int requiredCards, int maxCardR) {
		this.name = name;
		this.handSize = handSize;
		this.ranking = ranking;
		this.requiredCards = requiredCards;
		this.maxCardR = maxCardR;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {

		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getRanking() {

		return ranking;
	}

	/**
	 * {@inheritDoc}
	 */
	public int cardsRequired() {

		return requiredCards;
	}

	/**
	 * {@inheritDoc}
	 */
	public int handSize() {

		return handSize;
	}

	/**
	 * @return maxCardR returns the maximum rank of the card
	 */
	private int maxCardRank() {

		return maxCardR;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canSatisfy(Card[] mainCards) {

		if (mainCards.length == requiredCards) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canSubsetSatisfy(Card[] allCards) {

		if (allCards.length >= cardsRequired() && canSatisfy(allCards)) {

			return true;
		}

		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	public Hand createHand(Card[] allCards, int[] subset) {
		Card[] mainCards = new Card[subset.length];
		Card[] sideCards = new Card[allCards.length - subset.length];
		int count = 0;
		boolean isSideCard = true;
		for (int i = 0; i < subset.length; i++) {
			mainCards[i] = allCards[subset[i]];
		}
		for (int i = 0; i < allCards.length - 1; i++) {
			for (int j = 0; j < subset.length; j++) {
				if (subset[j] == i) {
					isSideCard = false;
				}
			}
			if (isSideCard) {
				sideCards[count] = allCards[i];
				count++;
			} else {
				isSideCard = true;
			}
		}

		Hand oneHand = new Hand(mainCards, sideCards, this);
		return oneHand;

	}

	/**
	 * {@inheritDoc}
	 */
	public Hand getBestHand(Card[] allCards) {
		ArrayList<Hand> newHand = new ArrayList<Hand>();
		ArrayList<int[]> subSetFind = SubsetFinder.findSubsets(allCards.length, requiredCards);

		for (int i = 0; i < subSetFind.size(); i++) {
			Hand newH = createHand(allCards, subSetFind.get(i));
			newHand.add(newH);
		}
		Hand bHand = newHand.get(0);

		for (int i = 1; i < newHand.size(); i++) {
			if (bHand.compareTo(newHand.get(i)) > 0 && canSatisfy(bHand.getMainCards())) {
				bHand = newHand.get(i);
			}
		}

		return bHand;

	}
}
