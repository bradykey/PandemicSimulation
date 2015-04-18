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
	private List<CityEnum> initialInfections;
	private int currTurn;
	private Map<CityEnum, City> worldMap;

	// final vars representing the simulation
	private final int MAX_TURNS = 60;
	private final int INFECTION_RATE = 2;
	private final int NUM_CITIES = 49;
	private final int MAX_INFECTION_OF_CITY = 3;
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
	 * @param initialInfections
	 *            the {@code List<CityEnum>} that contains the initial state of
	 *            the game. The first 3 cities in the list will contain 3
	 *            infection levels each, the next 3 will have an infection level
	 *            of 2 and the final 3 will have an infection level of 1.
	 *            Therefore, the list must be of length 9.
	 * @throws Exception
	 */
	public InfectionSimulator(List<CityEnum> initialInfections)
			throws Exception {
		if (initialInfections.size() != 9)
			throw new Exception(
					"The list of initial infections must be equal to 9.");

		this.initialInfections = initialInfections;

		initSimulation();
	}

	/**
	 * Initialize the board game simulation.
	 */
	private void initSimulation() {
		worldMap = new HashMap<CityEnum, City>();

		fillWorldMap();

		infectInitialCities();

		currTurn = 0;
	}

	/**
	 * Create one object for each city and place it in the {@code worldMap}.
	 */
	private void fillWorldMap() {
		// create all cities
		worldMap.put(CityEnum.ALGIERS, new Algiers());
		worldMap.put(CityEnum.ATLANTA, new Atlanta());
		worldMap.put(CityEnum.BAGHDAD, new Baghdad());
		worldMap.put(CityEnum.BANGKOK, new Bangkok());
		worldMap.put(CityEnum.BEIJING, new Beijing());
		worldMap.put(CityEnum.BOGOTA, new Bogota());
		worldMap.put(CityEnum.BUENOS_AIRES, new BuenosAires());
		worldMap.put(CityEnum.CAIRO, new Cairo());
		worldMap.put(CityEnum.CHENNAI, new Chennai());
		worldMap.put(CityEnum.CHICAGO, new Chicago());
		worldMap.put(CityEnum.DELHI, new Delhi());
		worldMap.put(CityEnum.ESSEN, new Essen());
		worldMap.put(CityEnum.HO_CHI_MINH_CITY, new HoChiMinhCity());
		worldMap.put(CityEnum.HONG_KONG, new HongKong());
		worldMap.put(CityEnum.ISTANBUL, new Istanbul());
		worldMap.put(CityEnum.JAKARTA, new Jakarta());
		worldMap.put(CityEnum.JOHANNESBURG, new Johannesburg());
		worldMap.put(CityEnum.KARACHI, new Karachi());
		worldMap.put(CityEnum.KHARTOUM, new Khartoum());
		worldMap.put(CityEnum.KINSHASA, new Kinshasa());
		worldMap.put(CityEnum.KOLKATA, new Kolkata());
		worldMap.put(CityEnum.LAGOS, new Lagos());
		worldMap.put(CityEnum.LIMA, new Lima());
		worldMap.put(CityEnum.LONDON, new London());
		worldMap.put(CityEnum.LOS_ANGELES, new LosAngeles());
		worldMap.put(CityEnum.MADRID, new Madrid());
		worldMap.put(CityEnum.MANILA, new Manila());
		worldMap.put(CityEnum.MEXICO_CITY, new MexicoCity());
		worldMap.put(CityEnum.MIAMI, new Miami());
		worldMap.put(CityEnum.MILAN, new Milan());
		worldMap.put(CityEnum.MONTREAL, new Montreal());
		worldMap.put(CityEnum.MOSCOW, new Moscow());
		worldMap.put(CityEnum.MUMBAI, new Mumbai());
		worldMap.put(CityEnum.NEW_YORK, new NewYork());
		worldMap.put(CityEnum.OSAKA, new Osaka());
		worldMap.put(CityEnum.PARIS, new Paris());
		worldMap.put(CityEnum.RIYADH, new Riyadh());
		worldMap.put(CityEnum.SAN_FRANSISCO, new SanFransisco());
		worldMap.put(CityEnum.SANTIAGO, new Santiago());
		worldMap.put(CityEnum.SAO_PAULO, new SaoPaulo());
		worldMap.put(CityEnum.SEOUL, new Seoul());
		worldMap.put(CityEnum.SHANGHAI, new Shanghai());
		worldMap.put(CityEnum.ST_PETERSBURG, new StPetersburg());
		worldMap.put(CityEnum.SYDNEY, new Sydney());
		worldMap.put(CityEnum.TAIPEI, new Taipei());
		worldMap.put(CityEnum.TEHRAN, new Tehran());
		worldMap.put(CityEnum.TOKYO, new Tokyo());
		worldMap.put(CityEnum.WASHINGTON, new Washington());
	}

	/**
	 * Set the infection level of each of the initially infected cities.
	 */
	private void infectInitialCities() {
		int ctr = 0;
		for (CityEnum city : initialInfections) {
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
	 *            board game scenario.
	 */
	private List<HashMap<CityEnum, City>> runSimulation(List<Turn> path,
			List<Integer> prngSeeds) {
		List<HashMap<CityEnum, City>> worldMapSnapshots = new ArrayList<HashMap<CityEnum, City>>();

		while (currTurn < MAX_TURNS) {
			if (path != null)
				for (Action action : path.get(currTurn).getActions()) {
					// run player's actions
				}

			// infect
			infect(prngSeeds.get(currTurn));

			// snapshot the world map; must be a deep copy of the map. This is
			// best done by using a copy constructor rather than clone();
			// TODO write a deep copy...
			worldMapSnapshots.add(new HashMap<CityEnum, City>(worldMap));

			// increment week
			currTurn++;
		}

		return worldMapSnapshots;
	}

	/**
	 * Infect the world. This includes randomly choosing {@code INFECTION_RATE}
	 * number of cities to add 1 disease cube to. If the {@link City} already
	 * has a maximum number of disease cubes, spread the infection to its
	 * connected cities.
	 * 
	 * @param seed
	 *            the {@code Integer} that will deterministically choose the
	 *            random cities to infect at this specific turn.
	 */
	private void infect(Integer seed) {
		CityEnum randCityEnum;
		Random prng = new Random(seed);

		for (int i = 0; i < INFECTION_RATE; i++) {
			// 0 - number of cities, inclusive
			randCityEnum = CITY_ALPHA_ORDER_LIST.get(prng.nextInt(NUM_CITIES));

			increaseCityInfection(worldMap.get(randCityEnum));
		}
	}

	/**
	 * Increase the infection level of the passed in city by 1. If it is already
	 * at the max infection level, recursively spread to the neighbors.
	 * 
	 * @param cityToInfect
	 *            the {@link City} to infect.
	 */
	private void increaseCityInfection(City cityToInfect) {
		if (cityToInfect.getInfectionLevel() < MAX_INFECTION_OF_CITY)
			// just add 1 infection level
			cityToInfect
					.setInfectionLevel(cityToInfect.getInfectionLevel() + 1);
		else
			// infect all of its neighbor cities
			for (CityEnum neighborCityEnum : cityToInfect.getNeighbors())
				increaseCityInfection(worldMap.get(neighborCityEnum));
	}

	/**
	 * The main entry point to run the {@link InfectionSimulator}.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		InfectionSimulator simulator = new InfectionSimulator(
				loadInitialInfections());

		// TODO call this correctly.
		simulator.runSimulation(null, null);

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
	private static List<CityEnum> loadInitialInfections() {
		return new ArrayList<CityEnum>(Arrays.asList(CityEnum.SAN_FRANSISCO,
				CityEnum.LOS_ANGELES, CityEnum.CHICAGO, CityEnum.MEXICO_CITY,
				CityEnum.ATLANTA, CityEnum.MONTREAL, CityEnum.MIAMI,
				CityEnum.WASHINGTON, CityEnum.NEW_YORK));
	}
}
