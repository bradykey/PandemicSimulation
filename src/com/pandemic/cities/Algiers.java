package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Algiers.
 * 
 * @author BKey
 */
public class Algiers extends City {

	/**
	 * The default constructor for {@code Algiers}.
	 */
	public Algiers() {
	}

	/**
	 * The constructor for {@code Algiers}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Algiers(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Algiers}.
	 */
	private void init(int infectionLevel) {
		this.setName("Algiers");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.MADRID);
		neighbors.add(CityEnum.PARIS);
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.CAIRO);
	}
}
