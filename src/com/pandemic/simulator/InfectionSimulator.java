package com.pandemic.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.pandemic.simulator.actions.Action;

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
	private Map<CityEnum, City> worldMap;
	private List<CityEnum> citiesInfectedDuringCurrTurn;
	private List<CityEnum> cityInfectionOrder;

	/* FINAL VARS REPRESENTING THE SIMULATION */
	private final int MAX_TURNS = 60;
	private final int INFECTION_RATE = 2;
	private final int NUM_CITIES = 48;
	private final int MAX_INFECTION_OF_CITY = 3;
	private final int NUM_INITIALLY_INFECTED = 9;
	// used as a lookup table
	private final List<CityEnum> CITY_ALPHA_ORDER_LIST = new ArrayList<CityEnum>(
			Arrays.asList(CityEnum.ALGIERS, CityEnum.ATLANTA, CityEnum.BAGHDAD,
					CityEnum.BANGKOK, CityEnum.BEIJING, CityEnum.BOGOTA,
					CityEnum.BUENOS_AIRES, CityEnum.CAIRO, CityEnum.CHENNAI,
					CityEnum.CHICAGO, CityEnum.DELHI, CityEnum.ESSEN,
					CityEnum.HO_CHI_MINH_CITY, CityEnum.HONG_KONG,
					CityEnum.ISTANBUL, CityEnum.JAKARTA, CityEnum.JOHANNESBURG,
					CityEnum.KARACHI, CityEnum.KHARTOUM, CityEnum.KINSHASA,
					CityEnum.KOLKATA, CityEnum.LAGOS, CityEnum.LIMA,
					CityEnum.LONDON, CityEnum.LOS_ANGELES, CityEnum.MADRID,
					CityEnum.MANILA, CityEnum.MEXICO_CITY, CityEnum.MIAMI,
					CityEnum.MILAN, CityEnum.MONTREAL, CityEnum.MOSCOW,
					CityEnum.MUMBAI, CityEnum.NEW_YORK, CityEnum.OSAKA,
					CityEnum.PARIS, CityEnum.RIYADH, CityEnum.SAN_FRANSISCO,
					CityEnum.SANTIAGO, CityEnum.SAO_PAULO, CityEnum.SEOUL,
					CityEnum.SHANGHAI, CityEnum.ST_PETERSBURG, CityEnum.SYDNEY,
					CityEnum.TAIPEI, CityEnum.TEHRAN, CityEnum.TOKYO,
					CityEnum.WASHINGTON));

	/**
	 * Constructor for a simulation of the Pandemic board game.
	 * 
	 * @param prng
	 *            this seeded {@code Random} number generator will allow for
	 *            deterministic play based on the GAME_SEED. i.e. the same exact
	 *            spread of the virus (which cities get infected and in what
	 *            order, what cities are initially infected etc.) will be
	 *            determined by this {@code Random} number generator.
	 */
	public InfectionSimulator(Random prng) {
		this.prng = prng;

		initSimulation();
	}

	/**
	 * Initialize the board game simulation.
	 */
	private void initSimulation() {
		worldMap = new HashMap<CityEnum, City>();
		cityInfectionOrder = new ArrayList<CityEnum>();

		fillWorldMap();
		infectInitialCities();
		loadCityInfectionOrder();

		citiesInfectedDuringCurrTurn = new ArrayList<CityEnum>();
		currTurn = 0;
	}

	/**
	 * Create one object for each city and place it in the {@code worldMap}.
	 */
	private void fillWorldMap() {
		// create all cities
		worldMap.put(CityEnum.ALGIERS, new Algiers(0));
		worldMap.put(CityEnum.ATLANTA, new Atlanta(0));
		worldMap.put(CityEnum.BAGHDAD, new Baghdad(0));
		worldMap.put(CityEnum.BANGKOK, new Bangkok(0));
		worldMap.put(CityEnum.BEIJING, new Beijing(0));
		worldMap.put(CityEnum.BOGOTA, new Bogota(0));
		worldMap.put(CityEnum.BUENOS_AIRES, new BuenosAires(0));
		worldMap.put(CityEnum.CAIRO, new Cairo(0));
		worldMap.put(CityEnum.CHENNAI, new Chennai(0));
		worldMap.put(CityEnum.CHICAGO, new Chicago(0));
		worldMap.put(CityEnum.DELHI, new Delhi(0));
		worldMap.put(CityEnum.ESSEN, new Essen(0));
		worldMap.put(CityEnum.HO_CHI_MINH_CITY, new HoChiMinhCity(0));
		worldMap.put(CityEnum.HONG_KONG, new HongKong(0));
		worldMap.put(CityEnum.ISTANBUL, new Istanbul(0));
		worldMap.put(CityEnum.JAKARTA, new Jakarta(0));
		worldMap.put(CityEnum.JOHANNESBURG, new Johannesburg(0));
		worldMap.put(CityEnum.KARACHI, new Karachi(0));
		worldMap.put(CityEnum.KHARTOUM, new Khartoum(0));
		worldMap.put(CityEnum.KINSHASA, new Kinshasa(0));
		worldMap.put(CityEnum.KOLKATA, new Kolkata(0));
		worldMap.put(CityEnum.LAGOS, new Lagos(0));
		worldMap.put(CityEnum.LIMA, new Lima(0));
		worldMap.put(CityEnum.LONDON, new London(0));
		worldMap.put(CityEnum.LOS_ANGELES, new LosAngeles(0));
		worldMap.put(CityEnum.MADRID, new Madrid(0));
		worldMap.put(CityEnum.MANILA, new Manila(0));
		worldMap.put(CityEnum.MEXICO_CITY, new MexicoCity(0));
		worldMap.put(CityEnum.MIAMI, new Miami(0));
		worldMap.put(CityEnum.MILAN, new Milan(0));
		worldMap.put(CityEnum.MONTREAL, new Montreal(0));
		worldMap.put(CityEnum.MOSCOW, new Moscow(0));
		worldMap.put(CityEnum.MUMBAI, new Mumbai(0));
		worldMap.put(CityEnum.NEW_YORK, new NewYork(0));
		worldMap.put(CityEnum.OSAKA, new Osaka(0));
		worldMap.put(CityEnum.PARIS, new Paris(0));
		worldMap.put(CityEnum.RIYADH, new Riyadh(0));
		worldMap.put(CityEnum.SAN_FRANSISCO, new SanFransisco(0));
		worldMap.put(CityEnum.SANTIAGO, new Santiago(0));
		worldMap.put(CityEnum.SAO_PAULO, new SaoPaulo(0));
		worldMap.put(CityEnum.SEOUL, new Seoul(0));
		worldMap.put(CityEnum.SHANGHAI, new Shanghai(0));
		worldMap.put(CityEnum.ST_PETERSBURG, new StPetersburg(0));
		worldMap.put(CityEnum.SYDNEY, new Sydney(0));
		worldMap.put(CityEnum.TAIPEI, new Taipei(0));
		worldMap.put(CityEnum.TEHRAN, new Tehran(0));
		worldMap.put(CityEnum.TOKYO, new Tokyo(0));
		worldMap.put(CityEnum.WASHINGTON, new Washington(0));
	}

	/**
	 * Set the infection level of each of the initially infected cities.
	 */
	private void infectInitialCities() {
		int ctr = 0;
		for (CityEnum city : loadInitialInfections()) {
			if (ctr < 3)
				worldMap.get(city).setInfectionLevel(3);
			else if (ctr >= 3 && ctr < 6)
				worldMap.get(city).setInfectionLevel(2);
			else
				worldMap.get(city).setInfectionLevel(1);

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

		for (int i = 0; i < NUM_INITIALLY_INFECTED; i++) {
			// 0 - number of cities, inclusive
			initiallyInfectedCities.add(CITY_ALPHA_ORDER_LIST.get(prng
					.nextInt(NUM_CITIES)));
		}

		return initiallyInfectedCities;
	}

	/**
	 * This method runs the simulation with the passed in player's path.
	 * 
	 * @param path
	 *            the List<Turn> that represents the path in which the player
	 *            played the game. The path must be equal to the maximum number
	 *            of weeks ({@code Turn}s) in a single game/simulation.
	 * 
	 * @param prngSeeds
	 *            a List<Integer> that contains the seeds which will be used to
	 *            define the cities that will be infected during this specific
	 *            game. This needs to be of length MAX_TURNS.
	 */
	private List<Map<CityEnum, City>> runSimulation(List<Turn> path) {
		List<Map<CityEnum, City>> worldMapSnapshots = new ArrayList<Map<CityEnum, City>>();

		while (currTurn < MAX_TURNS) {
			System.out.println("\nTurn #" + currTurn + "\n");

			if (path != null)
				for (Action action : path.get(currTurn).getActions()) {
					// run player's actions
				}

			infect();

			// snapshot the world map; must be a deep copy of the map
			worldMapSnapshots.add(snapshotTheWorld());

			// XXX print for debugging purposes
			for (CityEnum cityEnum : worldMapSnapshots.get(currTurn).keySet())
				System.out.println(cityEnum.toString()
						+ ": "
						+ worldMapSnapshots.get(currTurn).get(cityEnum)
								.getInfectionLevel());

			// increment week
			currTurn++;
		}

		return worldMapSnapshots;
	}

	/**
	 * This "draws" the cities to infect for each of the turns of the game.
	 * Since it's based on the pseudo {@code Random} number generator, the same
	 * cards will be drawn at each turn unless the prng is changed.
	 * 
	 * @return a List<CityEnum>s that contains the cities to infect at each
	 *         turn. This list will be of length {@code MAX_TURNS} *
	 *         {@code INFECTION_RATE}.
	 */
	private void loadCityInfectionOrder() {
		for (int i = 0; i < MAX_TURNS * INFECTION_RATE; i++)
			cityInfectionOrder.add(CITY_ALPHA_ORDER_LIST.get(prng
					.nextInt(NUM_CITIES)));
	}

	/**
	 * Infect the world. This includes infecting the {@code INFECTION_RATE}
	 * number of cities by adding 1 disease cube to. If the {@link City} already
	 * has a maximum number of disease cubes, spread the infection to its
	 * neighboring cities.
	 */
	private void infect() {
		CityEnum currCityEnumToInfect;

		for (int i = 0; i < INFECTION_RATE; i++) {
			// TODO turn 0 I need 0 and 1, turn 1 I need 2 and 3, turn 2 I need
			// 4 and 5, turn 3 I need 6 and 7
			currCityEnumToInfect = cityInfectionOrder.get((currTurn * 2) + i);

			increaseCityInfection(currCityEnumToInfect);

			// reset the cities infected on this turn
			citiesInfectedDuringCurrTurn.clear();
		}
	}

	/**
	 * Increase the infection level of the passed in city by 1. If it is already
	 * at the max infection level, recursively spread to the neighbors.
	 * 
	 * @param cityEnum
	 *            the {@link CityEnum} of the {@link City} to infect.
	 */
	private void increaseCityInfection(CityEnum cityEnum) {
		City cityToInfect = worldMap.get(cityEnum);

		// mark it as infected on this turn
		citiesInfectedDuringCurrTurn.add(cityEnum);

		if (cityToInfect.getInfectionLevel() < MAX_INFECTION_OF_CITY)
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
	 * @return the "snapshot" that is the deep copy of the {@code worldMap}.
	 */
	private Map<CityEnum, City> snapshotTheWorld() {
		Map<CityEnum, City> copiedWorldMap = new HashMap<CityEnum, City>();

		// loop through all of the cities and create new cities inside of the
		// new hashmap.
		for (CityEnum cityEnum : worldMap.keySet()) {
			City copiedCity = null;
			City currCity = worldMap.get(cityEnum);

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

			copiedWorldMap.put(cityEnum, copiedCity);
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
		// give you a different initial condition and outcome of the game. If
		// you don't change it, the same game will be simulated every time.
		final int GAME_SEED = 1;

		// random number generator that dictates the game
		Random prng = new Random(GAME_SEED);

		InfectionSimulator simulator = new InfectionSimulator(prng);

		simulator.runSimulation(null);

		// Map<CityEnum, City> copiedWorld = simulator.snapshotTheWorld();
		// copiedWorld.get(CityEnum.SAN_FRANSISCO).setInfectionLevel(1000);
		//
		// System.out.println(simulator.worldMap.get(CityEnum.SAN_FRANSISCO)
		// .getInfectionLevel());
		// System.out.println(copiedWorld.get(CityEnum.SAN_FRANSISCO)
		// .getInfectionLevel());

		// Map<CityEnum, City> mapA = new HashMap<CityEnum, City>();
		// mapA.put(CityEnum.ALGIERS, new Algiers(10));
		//
		// Map<CityEnum, City> mapB = new HashMap<CityEnum, City>(mapA);
		// mapB.put(CityEnum.ATLANTA, new Atlanta(5));
		// mapB.get(CityEnum.ALGIERS).setInfectionLevel(9);
		//
		// mapA.get(CityEnum.ALGIERS).setInfectionLevel(10);
		// System.out.println("MAP A: ");
		// for (City val : mapA.values()) {
		// System.out.println(val.getInfectionLevel());
		// }
		//
		// System.out.println("MAP B: ");
		// for (City val : mapB.values()) {
		// System.out.println(val.getInfectionLevel());
		// }
	}

	/**
	 * Create the initial configuration of the specific board game simulation.
	 * That is, the 3 cities with an infection level of 3, 3 cities with an
	 * infection level of 2 and 3 cities with an infection level of 1.
	 */
	// private static List<CityEnum> loadInitialInfections() {
	// return new ArrayList<CityEnum>(Arrays.asList(CityEnum.SAN_FRANSISCO,
	// CityEnum.LOS_ANGELES, CityEnum.CHICAGO, CityEnum.MEXICO_CITY,
	// CityEnum.ATLANTA, CityEnum.MONTREAL, CityEnum.MIAMI,
	// CityEnum.WASHINGTON, CityEnum.NEW_YORK));
	// }
}
