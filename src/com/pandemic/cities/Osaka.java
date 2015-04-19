package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Osaka.
 * 
 * @author BKey
 */
public class Osaka extends City {

	/**
	 * The default constructor for {@code Osaka}.
	 */
	public Osaka() {
	}

	/**
	 * The constructor for {@code Osaka}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Osaka(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Osaka}.
	 */
	private void init(int infectionLevel) {
		name = "Osaka";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.TAIPEI);
		neighbors.add(CityEnum.TOKYO);
	}
}
