package com.pandemic.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * This is the main simulator for the CA part of the Pandemic board game
 * project. This is the entry point into the project and is the only class that
 * contains a main();
 * 
 * @author BKey
 */
public class InfectionSimulator {
	private List<CityEnum> initialInfections;
	private int currWeek;
	private Map<CityEnum, City> worldMap;
	
	// final vars representing the simulation
	private final int MAX_TURNS = 60;
	private final int INFECTION_RATE = 2;

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

		currWeek = 0;
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
	 */
	private void runSimulation(List<Turn> path) {
		
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
