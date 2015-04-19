package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Baghdad.
 * 
 * @author BKey
 */
public class Moscow extends City {

	/**
	 * The default constructor for {@code Moscow}.
	 */
	public Moscow() {
	}

	/**
	 * The constructor for {@code Moscow}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Moscow(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Moscow}.
	 */
	private void init(int infectionLevel) {
		name = "Moscow";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.ST_PETERSBURG);
		neighbors.add(CityEnum.TEHRAN);
		neighbors.add(CityEnum.BAGHDAD);
	}
}
