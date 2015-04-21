package com.pandemic.simulator.GA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pandemic.cities.City;
import com.pandemic.cities.CityEnum;
import com.pandemic.simulator.Path;
import com.pandemic.simulator.SimVars;
import com.pandemic.simulator.Turn;
import com.pandemic.simulator.World;
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
	 * @return the {@code Path} that is the "genome" which represents a path
	 *         played by a player on a certain game.
	 */
	public static Path generateRandomPath(int seed) {
		return createPath(new Random(seed));
	}

	/**
	 * Overloaded method without a seed defined.
	 * 
	 * Generate a random {@code MAX_TURNS} set of {@link Turn}s that defines a
	 * single path for a game.
	 * 
	 * @return the {@code Path} that is the "genome" which represents a path
	 *         played by a player on a certain game.
	 */
	public static Path generateRandomPath() {
		return createPath(new Random());
	}

	/**
	 * Based on the {@code Random} number generator passed in, create
	 * {@link SimVars.MAX_TURNS} number of turns and place it into a list.
	 * 
	 * @param prng
	 *            the {@code Random} number generator.
	 * 
	 * @return the {@code Path} that is the path of the game.
	 */
	private static Path createPath(Random prng) {
		Path path = new Path(new ArrayList<Turn>());

		for (int turnNum = 0; turnNum < SimVars.MAX_TURNS; turnNum++)
			path.getTurns().add(generateTurn(prng));

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

	/**
	 * Loop through the {@link World} and sum up the infection levels of each
	 * city.
	 * 
	 * @return the total infection level of the world
	 */
	public static int calcTotalInfectionLevel(World world) {
		int totalInfection = 0;
		for (City city : world.getWorldMap().values())
			totalInfection += city.getInfectionLevel();

		return totalInfection;
	}

	/**
	 * Just get the final {@link World} from the result of a single path
	 * simulation on the game.
	 * 
	 * @param pathResult
	 *            the {@code List<World>} that contains all of the snapshots
	 *            from the {@link Path} that was run on the game.
	 * @return the last {@link World} in the {@code List<World>}s.
	 */
	public static World getFinalWorldMapSnapshot(List<World> pathResult) {
		return pathResult.get(pathResult.size() - 1);
	}
}
