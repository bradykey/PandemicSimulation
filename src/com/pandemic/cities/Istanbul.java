package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Istanbul.
 * 
 * @author BKey
 */
public class Istanbul extends City {

	/**
	 * The default constructor for {@code Istanbul}.
	 */
	public Istanbul() {
	}

	/**
	 * The constructor for {@code Istanbul}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Istanbul(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Istanbul}.
	 */
	private void init(int infectionLevel) {
		name = "Istanbul";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.ALGIERS);
		neighbors.add(CityEnum.MILAN);
		neighbors.add(CityEnum.ST_PETERSBURG);
		neighbors.add(CityEnum.MOSCOW);
		neighbors.add(CityEnum.CAIRO);
	}
}
