package com.pandemic.simulator.GA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pandemic.cities.CityEnum;
import com.pandemic.simulator.SimVars;
import com.pandemic.simulator.Turn;
import com.pandemic.simulator.actions.Action;
import com.pandemic.simulator.actions.MoveAction;
import com.pandemic.simulator.actions.TreatDiseaseAction;

/**
 * This class contains static utility methods used in the Genetic Algorithm.
 * 
 * @author Brady
 */
public class GAUtility {

	/**
	 * Generate a random {@code MAX_TURNS} set of {@link Turn}s that defines a
	 * single path for a game.
	 * 
	 * @param seed
	 *            the seed for the {@code Random} number generator
	 * 
	 * @return the {@code List<Turn>}s that is the "genome" which represents a
	 *         path played by a player on a certain game.
	 */
	public static List<Turn> generateRandomPath(int seed) {
		return createPath(new Random(seed));
	}

	/**
	 * Overloaded method without a seed defined.
	 * 
	 * Generate a random {@code MAX_TURNS} set of {@link Turn}s that defines a
	 * single path for a game.
	 * 
	 * @return the {@code List<Turn>}s that is the "genome" which represents a
	 *         path played by a player on a certain game.
	 */
	public static List<Turn> generateRandomPath() {
		return createPath(new Random());
	}

	/**
	 * Based on the {@code Random} number generator passed in, create
	 * {@link SimVars.MAX_TURNS} number of turns and place it into a list.
	 * 
	 * @param prng
	 *            the {@code Random} number generator.
	 * 
	 * @return the {@code List<Turn>} that is the path of the game.
	 */
	private static List<Turn> createPath(Random prng) {
		List<Turn> path = new ArrayList<Turn>();

		for (int turnNum = 0; turnNum < SimVars.MAX_TURNS; turnNum++)
			path.add(generateTurn(prng));

		return path;
	}

	/**
	 * Generate a single {@link Turn} containing 4 {@link Action}s.
	 * 
	 * @param prng
	 *            the {@code Random} number generator.
	 * @return the {@link Turn}.
	 */
	private static Turn generateTurn(Random prng) {
		List<Action> actions = new ArrayList<Action>();

		for (int actionNum = 0; actionNum < SimVars.NUM_ACTIONS_PER_TURN; actionNum++) {
			if (prng.nextInt(2) == 0)
				// treat
				actions.add(new TreatDiseaseAction());
			else {
				// select a random city to move to
				CityEnum moveToCity = SimVars.CITY_ALPHA_ORDER_LIST.get(prng
						.nextInt(SimVars.NUM_CITIES));
				actions.add(new MoveAction(moveToCity));
			}
		}

		return new Turn(actions);
	}
}
