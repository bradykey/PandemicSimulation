package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Buenos Aires.
 * 
 * @author BKey
 */
public class BuenosAires extends City {

	/**
	 * The default constructor for {@code BuenosAires}.
	 */
	public BuenosAires() {
	}

	/**
	 * The constructor for {@code BuenosAires}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public BuenosAires(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code BuenosAires}.
	 */
	private void init(int infectionLevel) {
		this.setName("Buenos Aires");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BOGOTA);
		neighbors.add(CityEnum.SAO_PAULO);
	}
}
