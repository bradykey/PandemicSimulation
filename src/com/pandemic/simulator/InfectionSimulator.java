package com.pandemic.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.pandemic.DataCollection;
import com.pandemic.cities.Algiers;
import com.pandemic.cities.Atlanta;
import com.pandemic.cities.Baghdad;
import com.pandemic.cities.Bangkok;
import com.pandemic.cities.Beijing;
import com.pandemic.cities.Bogota;
import com.pandemic.cities.BuenosAires;
import com.pandemic.cities.Cairo;
import com.pandemic.cities.Chennai;
import com.pandemic.cities.Chicago;
import com.pandemic.cities.City;
import com.pandemic.cities.CityEnum;
import com.pandemic.cities.Delhi;
import com.pandemic.cities.Essen;
import com.pandemic.cities.HoChiMinhCity;
import com.pandemic.cities.HongKong;
import com.pandemic.cities.Istanbul;
import com.pandemic.cities.Jakarta;
import com.pandemic.cities.Johannesburg;
import com.pandemic.cities.Karachi;
import com.pandemic.cities.Khartoum;
import com.pandemic.cities.Kinshasa;
import com.pandemic.cities.Kolkata;
import com.pandemic.cities.Lagos;
import com.pandemic.cities.Lima;
import com.pandemic.cities.London;
import com.pandemic.cities.LosAngeles;
import com.pandemic.cities.Madrid;
import com.pandemic.cities.Manila;
import com.pandemic.cities.MexicoCity;
import com.pandemic.cities.Miami;
import com.pandemic.cities.Milan;
import com.pandemic.cities.Montreal;
import com.pandemic.cities.Moscow;
import com.pandemic.cities.Mumbai;
import com.pandemic.cities.NewYork;
import com.pandemic.cities.Osaka;
import com.pandemic.cities.Paris;
import com.pandemic.cities.Riyadh;
import com.pandemic.cities.SanFransisco;
import com.pandemic.cities.Santiago;
import com.pandemic.cities.SaoPaulo;
import com.pandemic.cities.Seoul;
import com.pandemic.cities.Shanghai;
import com.pandemic.cities.StPetersburg;
import com.pandemic.cities.Sydney;
import com.pandemic.cities.Taipei;
import com.pandemic.cities.Tehran;
import com.pandemic.cities.Tokyo;
import com.pandemic.cities.Washington;
import com.pandemic.simulator.GA.GAUtility;
import com.pandemic.simulator.actions.Action;
import com.pandemic.simulator.actions.MoveAction;
import com.pandemic.simulator.actions.TreatDiseaseAction;

/**
 * This is the main simulator for the CA part of the Pandemic board game
 * project. This is the entry point into the project and is the only class that
 * contains a main();
 * 
 * @author BKey
 */
public class InfectionSimulator {
	private Random prng;
	private int currTurn;
	private World world;
	private List<CityEnum> citiesInfectedDuringCurrTurn;
	private List<CityEnum> cityInfectionOrder;
	private List<CityEnum> initiallyInfectedCities;
	private CityEnum playerLocation;

	/**
	 * Constructor for a simulation of the Pandemic board game.
	 * 
	 * @param prng
	 *            this seeded {@code Random} number generator will allow for
	 *            deterministic play based on the GAME_SEED. i.e. the same exact
	 *            spread of the virus (which cities get infected and in what
	 *            order, what cities are initially infected) will be determined
	 *            by this {@code Random} number generator.
	 */
	public InfectionSimulator(Random prng) {
		this.prng = prng;

		initSimulation();
	}

	/**
	 * Initialize the board game simulation.
	 */
	private void initSimulation() {
		world = new World(new HashMap<CityEnum, City>());
		cityInfectionOrder = new ArrayList<CityEnum>();

		fillWorldMap();
		infectInitialCities();
		loadCityInfectionOrder();

		citiesInfectedDuringCurrTurn = new ArrayList<CityEnum>();
		currTurn = 0;

		playerLocation = SimVars.START_CITY;
	}

	/**
	 * Create one object for each city and place it in the {@code world}.
	 */
	private void fillWorldMap() {
		// create all cities
		world.getWorldMap().put(CityEnum.ALGIERS, new Algiers(0));
		world.getWorldMap().put(CityEnum.ATLANTA, new Atlanta(0));
		world.getWorldMap().put(CityEnum.BAGHDAD, new Baghdad(0));
		world.getWorldMap().put(CityEnum.BANGKOK, new Bangkok(0));
		world.getWorldMap().put(CityEnum.BEIJING, new Beijing(0));
		world.getWorldMap().put(CityEnum.BOGOTA, new Bogota(0));
		world.getWorldMap().put(CityEnum.BUENOS_AIRES, new BuenosAires(0));
		world.getWorldMap().put(CityEnum.CAIRO, new Cairo(0));
		world.getWorldMap().put(CityEnum.CHENNAI, new Chennai(0));
		world.getWorldMap().put(CityEnum.CHICAGO, new Chicago(0));
		world.getWorldMap().put(CityEnum.DELHI, new Delhi(0));
		world.getWorldMap().put(CityEnum.ESSEN, new Essen(0));
		world.getWorldMap()
				.put(CityEnum.HO_CHI_MINH_CITY, new HoChiMinhCity(0));
		world.getWorldMap().put(CityEnum.HONG_KONG, new HongKong(0));
		world.getWorldMap().put(CityEnum.ISTANBUL, new Istanbul(0));
		world.getWorldMap().put(CityEnum.JAKARTA, new Jakarta(0));
		world.getWorldMap().put(CityEnum.JOHANNESBURG, new Johannesburg(0));
		world.getWorldMap().put(CityEnum.KARACHI, new Karachi(0));
		world.getWorldMap().put(CityEnum.KHARTOUM, new Khartoum(0));
		world.getWorldMap().put(CityEnum.KINSHASA, new Kinshasa(0));
		world.getWorldMap().put(CityEnum.KOLKATA, new Kolkata(0));
		world.getWorldMap().put(CityEnum.LAGOS, new Lagos(0));
		world.getWorldMap().put(CityEnum.LIMA, new Lima(0));
		world.getWorldMap().put(CityEnum.LONDON, new London(0));
		world.getWorldMap().put(CityEnum.LOS_ANGELES, new LosAngeles(0));
		world.getWorldMap().put(CityEnum.MADRID, new Madrid(0));
		world.getWorldMap().put(CityEnum.MANILA, new Manila(0));
		world.getWorldMap().put(CityEnum.MEXICO_CITY, new MexicoCity(0));
		world.getWorldMap().put(CityEnum.MIAMI, new Miami(0));
		world.getWorldMap().put(CityEnum.MILAN, new Milan(0));
		world.getWorldMap().put(CityEnum.MONTREAL, new Montreal(0));
		world.getWorldMap().put(CityEnum.MOSCOW, new Moscow(0));
		world.getWorldMap().put(CityEnum.MUMBAI, new Mumbai(0));
		world.getWorldMap().put(CityEnum.NEW_YORK, new NewYork(0));
		world.getWorldMap().put(CityEnum.OSAKA, new Osaka(0));
		world.getWorldMap().put(CityEnum.PARIS, new Paris(0));
		world.getWorldMap().put(CityEnum.RIYADH, new Riyadh(0));
		world.getWorldMap().put(CityEnum.SAN_FRANSISCO, new SanFransisco(0));
		world.getWorldMap().put(CityEnum.SANTIAGO, new Santiago(0));
		world.getWorldMap().put(CityEnum.SAO_PAULO, new SaoPaulo(0));
		world.getWorldMap().put(CityEnum.SEOUL, new Seoul(0));
		world.getWorldMap().put(CityEnum.SHANGHAI, new Shanghai(0));
		world.getWorldMap().put(CityEnum.ST_PETERSBURG, new StPetersburg(0));
		world.getWorldMap().put(CityEnum.SYDNEY, new Sydney(0));
		world.getWorldMap().put(CityEnum.TAIPEI, new Taipei(0));
		world.getWorldMap().put(CityEnum.TEHRAN, new Tehran(0));
		world.getWorldMap().put(CityEnum.TOKYO, new Tokyo(0));
		world.getWorldMap().put(CityEnum.WASHINGTON, new Washington(0));
	}

	/**
	 * Set the infection level of each of the initially infected cities.
	 */
	private void infectInitialCities() {
		initiallyInfectedCities = loadInitialInfections();

		int ctr = 0;
		for (CityEnum city : initiallyInfectedCities) {
			if (ctr < 3)
				world.getWorldMap().get(city).setInfectionLevel(3);
			else if (ctr >= 3 && ctr < 6)
				world.getWorldMap().get(city).setInfectionLevel(2);
			else
				world.getWorldMap().get(city).setInfectionLevel(1);

			ctr++;
		}
	}

	/**
	 * Create the initial configuration of the specific board game simulation.
	 * That is, the 9 cities that will initially start with some amount of
	 * infection.
	 * 
	 * @return the {@code List<CityEnum>} that contain those 9 {@link CityEnum}s
	 *         that will start with an infection level.
	 */
	private List<CityEnum> loadInitialInfections() {
		List<CityEnum> initiallyInfectedCities = new ArrayList<CityEnum>();
		CityEnum currCityEnum;

		for (int i = 0; i < SimVars.NUM_INITIALLY_INFECTED; i++) {
			// 0 - number of cities, inclusive, no dupes
			currCityEnum =
					SimVars.CITY_ALPHA_ORDER_LIST.get(prng
							.nextInt(SimVars.NUM_CITIES));

			if (!initiallyInfectedCities.contains(currCityEnum))
				initiallyInfectedCities.add(currCityEnum);
			else
				// can't add duplicates, try again
				i--;
		}

		return initiallyInfectedCities;
	}

	/**
	 * This method runs the simulation with the passed in player's path.
	 * 
	 * @param path
	 *            the Path that represents the path in which the player played
	 *            the game. The path must be equal to the maximum number of
	 *            weeks ({@code Turn}s) in a single game/simulation.
	 * 
	 * @return the {@code List} containing the snapshot {@link World}s after
	 *         every turn of the game.
	 */
	private List<World> runSimulation(Path path) {
		List<World> worldSnapshots = new ArrayList<World>();

		// System.out.println("INITIAL CONFIGURATION:\n");
		// printWorldMap(world);
		// add the initial configuration first
		worldSnapshots.add(snapshotTheWorld());

		while (currTurn < SimVars.MAX_TURNS) {
			// System.out.println("\nTurn #" + currTurn + "\n");

			if (path != null) {
				City playerCity;
				for (Action action : path.getTurns().get(currTurn).getActions()) {
					// run player's actions
					if (action instanceof MoveAction)
						playerLocation = ((MoveAction) action).getMoveTo();
					else {
						// cure at the current city
						playerCity = world.getWorldMap().get(playerLocation);
						// only if it isn't already at 0 (can't go negative)
						if (playerCity.getInfectionLevel() > 0)
							playerCity.setInfectionLevel(playerCity
									.getInfectionLevel() - 1);
					}
				}
			}

			infect();

			// snapshot the world map; must be a deep copy
			worldSnapshots.add(snapshotTheWorld());

			// XXX print for debugging purposes
			// printWorldMap(worldMapSnapshots.get(currTurn));

			// increment week
			currTurn++;
		}

		return worldSnapshots;
	}

	/**
	 * This "draws" the cities to infect for each of the turns of the game.
	 * Since it's based on the pseudo {@code Random} number generator, the same
	 * cards will be drawn at each turn unless the global prng is changed.
	 * Duplicate cities can be chosen here since there are multiple cards of the
	 * same city in the game deck.
	 * 
	 * @return a List<CityEnum>s that contains the cities to infect at each
	 *         turn. This list will be of length {@code MAX_TURNS} *
	 *         {@code INFECTION_RATE}.
	 */
	private void loadCityInfectionOrder() {
		for (int i = 0; i < SimVars.MAX_TURNS * SimVars.INFECTION_RATE; i++)
			cityInfectionOrder.add(SimVars.CITY_ALPHA_ORDER_LIST.get(prng
					.nextInt(SimVars.NUM_CITIES)));
	}

	/**
	 * Infect the world. This includes infecting the {@code INFECTION_RATE}
	 * number of cities.
	 */
	private void infect() {
		CityEnum currCityEnumToInfect;

		for (int i = 0; i < SimVars.INFECTION_RATE; i++) {
			// the current turn multiplied by the infection rate will always
			// give the index of the first city to infect at that turn, and add
			// 1 to get the second.
			currCityEnumToInfect =
					cityInfectionOrder.get((currTurn * SimVars.INFECTION_RATE)
							+ i);

			increaseCityInfection(currCityEnumToInfect);

			// reset the cities infected on this turn
			citiesInfectedDuringCurrTurn.clear();
		}
	}

	/**
	 * Increase the infection level of the passed in city by 1. If it is already
	 * at the max infection level, recursively spread to its neighbors. Note
	 * that a city can only have its infection increased once per infection.
	 * 
	 * @param cityEnum
	 *            the {@link CityEnum} of the {@link City} to infect.
	 */
	private void increaseCityInfection(CityEnum cityEnum) {
		City cityToInfect = world.getWorldMap().get(cityEnum);

		// mark it as infected on this turn
		citiesInfectedDuringCurrTurn.add(cityEnum);

		if (cityToInfect.getInfectionLevel() < SimVars.MAX_INFECTION_OF_CITY)
			// just add 1 infection level
			cityToInfect
					.setInfectionLevel(cityToInfect.getInfectionLevel() + 1);
		else
			// infect all of its neighbor cities
			for (CityEnum neighborCityEnum : cityToInfect.getNeighbors())
				// only if they haven't been infected on this turn
				if (!citiesInfectedDuringCurrTurn.contains(neighborCityEnum))
					increaseCityInfection(neighborCityEnum);
	}

	/**
	 * Create a deep copy of the world map in its current state.
	 * 
	 * @return the "snapshot" that is the deep copy of the {@code world}.
	 */
	private World snapshotTheWorld() {
		World copiedWorldMap = new World(new HashMap<CityEnum, City>());

		// loop through all of the cities and create new cities inside of the
		// new hashmap.
		for (CityEnum cityEnum : world.getWorldMap().keySet()) {
			City copiedCity = null;
			City currCity = world.getWorldMap().get(cityEnum);

			switch (cityEnum) {
			case ALGIERS:
				copiedCity = new Algiers(currCity.getInfectionLevel());
				break;
			case ATLANTA:
				copiedCity = new Atlanta(currCity.getInfectionLevel());
				break;
			case BAGHDAD:
				copiedCity = new Baghdad(currCity.getInfectionLevel());
				break;
			case BANGKOK:
				copiedCity = new Bangkok(currCity.getInfectionLevel());
				break;
			case BEIJING:
				copiedCity = new Beijing(currCity.getInfectionLevel());
				break;
			case BOGOTA:
				copiedCity = new Bogota(currCity.getInfectionLevel());
				break;
			case BUENOS_AIRES:
				copiedCity = new BuenosAires(currCity.getInfectionLevel());
				break;
			case CAIRO:
				copiedCity = new Cairo(currCity.getInfectionLevel());
				break;
			case CHENNAI:
				copiedCity = new Chennai(currCity.getInfectionLevel());
				break;
			case CHICAGO:
				copiedCity = new Chicago(currCity.getInfectionLevel());
				break;
			case DELHI:
				copiedCity = new Delhi(currCity.getInfectionLevel());
				break;
			case ESSEN:
				copiedCity = new Essen(currCity.getInfectionLevel());
				break;
			case HO_CHI_MINH_CITY:
				copiedCity = new HoChiMinhCity(currCity.getInfectionLevel());
				break;
			case HONG_KONG:
				copiedCity = new HongKong(currCity.getInfectionLevel());
				break;
			case ISTANBUL:
				copiedCity = new Istanbul(currCity.getInfectionLevel());
				break;
			case JAKARTA:
				copiedCity = new Jakarta(currCity.getInfectionLevel());
				break;
			case JOHANNESBURG:
				copiedCity = new Johannesburg(currCity.getInfectionLevel());
				break;
			case KARACHI:
				copiedCity = new Karachi(currCity.getInfectionLevel());
				break;
			case KHARTOUM:
				copiedCity = new Khartoum(currCity.getInfectionLevel());
				break;
			case KINSHASA:
				copiedCity = new Kinshasa(currCity.getInfectionLevel());
				break;
			case KOLKATA:
				copiedCity = new Kolkata(currCity.getInfectionLevel());
				break;
			case LAGOS:
				copiedCity = new Lagos(currCity.getInfectionLevel());
				break;
			case LIMA:
				copiedCity = new Lima(currCity.getInfectionLevel());
				break;
			case LONDON:
				copiedCity = new London(currCity.getInfectionLevel());
				break;
			case LOS_ANGELES:
				copiedCity = new LosAngeles(currCity.getInfectionLevel());
				break;
			case MADRID:
				copiedCity = new Madrid(currCity.getInfectionLevel());
				break;
			case MANILA:
				copiedCity = new Manila(currCity.getInfectionLevel());
				break;
			case MEXICO_CITY:
				copiedCity = new MexicoCity(currCity.getInfectionLevel());
				break;
			case MIAMI:
				copiedCity = new Miami(currCity.getInfectionLevel());
				break;
			case MILAN:
				copiedCity = new Milan(currCity.getInfectionLevel());
				break;
			case MONTREAL:
				copiedCity = new Montreal(currCity.getInfectionLevel());
				break;
			case MOSCOW:
				copiedCity = new Moscow(currCity.getInfectionLevel());
				break;
			case MUMBAI:
				copiedCity = new Mumbai(currCity.getInfectionLevel());
				break;
			case NEW_YORK:
				copiedCity = new NewYork(currCity.getInfectionLevel());
				break;
			case OSAKA:
				copiedCity = new Osaka(currCity.getInfectionLevel());
				break;
			case PARIS:
				copiedCity = new Paris(currCity.getInfectionLevel());
				break;
			case RIYADH:
				copiedCity = new Riyadh(currCity.getInfectionLevel());
				break;
			case SAN_FRANSISCO:
				copiedCity = new SanFransisco(currCity.getInfectionLevel());
				break;
			case SANTIAGO:
				copiedCity = new Santiago(currCity.getInfectionLevel());
				break;
			case SAO_PAULO:
				copiedCity = new SaoPaulo(currCity.getInfectionLevel());
				break;
			case SEOUL:
				copiedCity = new Seoul(currCity.getInfectionLevel());
				break;
			case SHANGHAI:
				copiedCity = new Shanghai(currCity.getInfectionLevel());
				break;
			case ST_PETERSBURG:
				copiedCity = new StPetersburg(currCity.getInfectionLevel());
				break;
			case SYDNEY:
				copiedCity = new Sydney(currCity.getInfectionLevel());
				break;
			case TAIPEI:
				copiedCity = new Taipei(currCity.getInfectionLevel());
				break;
			case TEHRAN:
				copiedCity = new Tehran(currCity.getInfectionLevel());
				break;
			case TOKYO:
				copiedCity = new Tokyo(currCity.getInfectionLevel());
				break;
			case WASHINGTON:
				copiedCity = new Washington(currCity.getInfectionLevel());
				break;
			default:
				// NOT POSSIBLE
				break;
			}

			copiedWorldMap.getWorldMap().put(cityEnum, copiedCity);
		}

		return copiedWorldMap;
	}

	/**
	 * The main entry point to run the {@link InfectionSimulator}.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// deterministic value representing this game; i.e. changing this will
		// give you a different set of initially infected cities as well as a
		// different infection order.
		// If you don't change it, the same game will be simulated every time.
		final int GAME_SEED = 4;

		// random number generator that dictates the game
		Random prng = new Random(GAME_SEED);

		InfectionSimulator simulator = new InfectionSimulator(prng);

		// Figure 1 & 4/GIFS
		for (int gameNum = 0; gameNum < 10; gameNum++) {
			resetSim(simulator, gameNum);
			List<World> currPathResult = simulator.runSimulation(null);

			DataCollection.saveDiseaseSpreadNoPlayer(currPathResult, gameNum);
		}

		resetSim(simulator, GAME_SEED);
		// Figure 4/GIFS.1 - NoPlayer spread
		// only do this figure once
		DataCollection
				.saveWorldAtEachTurn(
						simulator.runSimulation(null),
						null,
						simulator.cityInfectionOrder,
						"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig4GIFS\\NoPlayer\\worldStatePerTurn.txt");

		resetSim(simulator, GAME_SEED);
		runGA(simulator, GAME_SEED);
	}

	/**
	 * Run the genetic algorithm on the {@link InfectionSimulator}.
	 * 
	 * @param simulator
	 *            the {@link InfectionSimulator} that contains the game in which
	 *            to run the GA on.
	 * 
	 * @param GAME_SEED
	 *            deterministic value representing this game
	 */
	private static void runGA(InfectionSimulator simulator, int GAME_SEED) {
		List<Integer> bestFitnessPerGeneration = new ArrayList<Integer>();
		List<Path> population = new ArrayList<Path>();
		List<Path> elitePaths;
		List<Path> offspring;

		for (int pathNum = 0; pathNum < SimVars.PATH_POPULATION_SIZE; pathNum++)
			population.add(GAUtility.generateRandomPath());

		int currGeneration = 0;
		List<World> currPathResult;

		while (currGeneration < 50) {
			// XXX debugging
			System.out.println("Start Generation #: " + (currGeneration + 1));

			// run simulation on entire population of paths
			for (Path path : population) {
				currPathResult = simulator.runSimulation(path);

				// calculate fitness; that is the amount of infection in the
				// world at the final snapshot
				path.setFitness(GAUtility.calcTotalInfectionLevel(GAUtility
						.getFinalWorldMapSnapshot(currPathResult)));

				resetSim(simulator, GAME_SEED);
			}

			// sort based on fitness
			Collections.sort(population);
			bestFitnessPerGeneration.add(population.get(0).getFitness());

			// get the elite paths
			elitePaths = new ArrayList<Path>();
			for (int i = 0; i < SimVars.NUM_ELITE; i++)
				elitePaths.add(population.get(i));

			// crossover
			offspring = crossoverTheElite(elitePaths);

			// prepare population for next generation
			// NOTE: must just replace the non-elite elements in the population
			// structure with the offspring. The offspring start at the
			// NUM_ELITE'th idx and go to the end.
			int offIdx = 0;
			for (int idx = SimVars.NUM_ELITE; idx < SimVars.PATH_POPULATION_SIZE; idx++) {
				population.set(idx, offspring.get(offIdx));

				offIdx++;
			}

			currGeneration++;
		}

		// Figure 2
		DataCollection.saveBestFitnessPerGeneration(bestFitnessPerGeneration);

		// Figure 3
		DataCollection.saveAvgInfectionLevelPerCity(
				simulator.runSimulation(population.get(0)), "BEST");
		resetSim(simulator, GAME_SEED);
		DataCollection.saveAvgInfectionLevelPerCity(
				simulator.runSimulation(GAUtility
						.generateRandomPath(SimVars.WORST_SEED)), "Random");
		resetSim(simulator, GAME_SEED);

		// Figure 4/GIFS.2 - BEST
		DataCollection
				.saveWorldAtEachTurn(
						simulator.runSimulation(population.get(0)),
						population.get(0),
						simulator.cityInfectionOrder,
						"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig4GIFS\\Best\\worldStatePerTurn.txt");
		resetSim(simulator, GAME_SEED);
		// WORST/RANDOM
		Path randomPath = GAUtility.generateRandomPath(SimVars.WORST_SEED);
		DataCollection
				.saveWorldAtEachTurn(
						simulator.runSimulation(randomPath),
						randomPath,
						simulator.cityInfectionOrder,
						"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig4GIFS\\Random\\worldStatePerTurn.txt");
		resetSim(simulator, GAME_SEED);

		// Figure 5 - BEST
		DataCollection
				.saveActionDistributionPerTurn(
						population.get(0),
						"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig5\\actionDistributionPerTurnBEST.txt");
		resetSim(simulator, GAME_SEED);
		// Worst/Random
		DataCollection
				.saveActionDistributionPerTurn(
						randomPath,
						"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig5\\actionDistributionPerTurnRANDOM.txt");
		resetSim(simulator, GAME_SEED);
	}

	/**
	 * Perform a single point crossover from 2 random elite parents to create
	 * the {@code SimVars.NUM_OFFSPRING} offspring to fill the rest of the
	 * population.
	 * 
	 * @param elitePaths
	 *            the {@code List} of elite paths that will be the parents.
	 * 
	 * @return the {@code List} of paths that is the offspring of this
	 *         generation.
	 */
	private static List<Path> crossoverTheElite(List<Path> elitePaths) {
		Random prng = new Random();
		int parent1Idx, parent2Idx, crossoverPt;
		Path parent1, parent2;

		List<Path> offspring = new ArrayList<Path>();

		for (int offCtr = 0; offCtr < SimVars.NUM_OFFSPRING / 2; offCtr++) {
			// pick 2 random parents to be the offspring
			parent1Idx = prng.nextInt(SimVars.NUM_ELITE);
			parent2Idx = prng.nextInt(SimVars.NUM_ELITE);
			parent1 = elitePaths.get(parent1Idx);
			parent2 = elitePaths.get(parent2Idx);

			// pick a random crossover point
			crossoverPt = prng.nextInt(SimVars.MAX_TURNS);

			// create two offspring; must create deep copy of the parent's
			// "genome". First half parent 1 with second half parent 2 and first
			// half parent 2 with second half parent 1.
			List<Turn> fHalf1SHalf2Turns = new ArrayList<Turn>();
			List<Turn> fHalf2SHalf1Turns = new ArrayList<Turn>();

			// FIRST HALVES
			for (int fHalf = 0; fHalf < crossoverPt; fHalf++) {
				List<Action> fHalf1SHalf2Actions = new ArrayList<Action>();
				List<Action> fHalf2SHalf1Actions = new ArrayList<Action>();

				for (int actionIdx = 0; actionIdx < SimVars.NUM_ACTIONS_PER_TURN; actionIdx++) {
					Action par1CurrAction =
							parent1.getTurns().get(fHalf).getActions()
									.get(actionIdx);
					Action par2CurrAction =
							parent2.getTurns().get(fHalf).getActions()
									.get(actionIdx);

					if (par1CurrAction instanceof MoveAction)
						fHalf1SHalf2Actions.add(new MoveAction(
								((MoveAction) par1CurrAction).getMoveTo()));
					else
						// treat action
						fHalf1SHalf2Actions.add(new TreatDiseaseAction());

					if (par2CurrAction instanceof MoveAction)
						fHalf2SHalf1Actions.add(new MoveAction(
								((MoveAction) par2CurrAction).getMoveTo()));
					else
						// treat action
						fHalf2SHalf1Actions.add(new TreatDiseaseAction());
				}

				fHalf1SHalf2Turns.add(new Turn(fHalf1SHalf2Actions));
				fHalf2SHalf1Turns.add(new Turn(fHalf2SHalf1Actions));
			}

			// SECOND HALVES
			for (int sHalf = crossoverPt; sHalf < SimVars.MAX_TURNS; sHalf++) {
				List<Action> fHalf1SHalf2Actions = new ArrayList<Action>();
				List<Action> fHalf2SHalf1Actions = new ArrayList<Action>();

				for (int actionIdx = 0; actionIdx < SimVars.NUM_ACTIONS_PER_TURN; actionIdx++) {
					Action par1CurrAction =
							parent1.getTurns().get(sHalf).getActions()
									.get(actionIdx);
					Action par2CurrAction =
							parent2.getTurns().get(sHalf).getActions()
									.get(actionIdx);

					if (par1CurrAction instanceof MoveAction)
						fHalf1SHalf2Actions.add(new MoveAction(
								((MoveAction) par1CurrAction).getMoveTo()));
					else
						// treat action
						fHalf1SHalf2Actions.add(new TreatDiseaseAction());

					if (par2CurrAction instanceof MoveAction)
						fHalf2SHalf1Actions.add(new MoveAction(
								((MoveAction) par2CurrAction).getMoveTo()));
					else
						// treat action
						fHalf2SHalf1Actions.add(new TreatDiseaseAction());
				}

				fHalf1SHalf2Turns.add(new Turn(fHalf1SHalf2Actions));
				fHalf2SHalf1Turns.add(new Turn(fHalf2SHalf1Actions));
			}

			// randomly mutate
			int mutateIdx;
			Turn mutateTurn1, mutateTurn2;
			for (int i = 0; i < SimVars.NUM_MUTATIONS; i++) {
				mutateIdx = prng.nextInt(SimVars.MAX_TURNS);
				mutateTurn1 = fHalf1SHalf2Turns.get(mutateIdx);

				mutateIdx = prng.nextInt(SimVars.MAX_TURNS);
				mutateTurn2 = fHalf2SHalf1Turns.get(mutateIdx);

				// randomly choose new set of actions
				for (int actionIdx = 0; actionIdx < SimVars.NUM_ACTIONS_PER_TURN; actionIdx++) {

					// CHILD 1
					if (prng.nextInt(2) == 0)
						// treat
						mutateTurn1.getActions().set(actionIdx,
								new TreatDiseaseAction());
					else {
						// select a random city to move to
						CityEnum moveToCity =
								SimVars.CITY_ALPHA_ORDER_LIST.get(prng
										.nextInt(SimVars.NUM_CITIES));
						mutateTurn1.getActions().set(actionIdx,
								new MoveAction(moveToCity));
					}

					// CHILD 2
					if (prng.nextInt(2) == 0)
						// treat
						mutateTurn2.getActions().set(actionIdx,
								new TreatDiseaseAction());
					else {
						// select a random city to move to
						CityEnum moveToCity =
								SimVars.CITY_ALPHA_ORDER_LIST.get(prng
										.nextInt(SimVars.NUM_CITIES));
						mutateTurn2.getActions().set(actionIdx,
								new MoveAction(moveToCity));
					}
				}
			}

			// add the children to the offspring list
			offspring.add(new Path(fHalf1SHalf2Turns));
			offspring.add(new Path(fHalf2SHalf1Turns));
		}

		return offspring;
	}

	/**
	 * Reset the prng and re-init the simulator for a new path run
	 * 
	 * @param simulator
	 *            the {@link InfectionSimulator} to reset.
	 * @param GAME_SEED
	 *            the {@code int} set to reset the prng with.
	 */
	private static void resetSim(InfectionSimulator simulator, int GAME_SEED) {
		simulator.prng.setSeed(GAME_SEED);
		simulator.initSimulation();
	}
}