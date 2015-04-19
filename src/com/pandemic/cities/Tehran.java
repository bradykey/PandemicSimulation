package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Tehran.
 * 
 * @author BKey
 */
public class Tehran extends City {

	/**
	 * The default constructor for {@code Tehran}.
	 */
	public Tehran() {
	}

	/**
	 * The constructor for {@code Tehran}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Tehran(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Tehran}.
	 */
	private void init(int infectionLevel) {
		name = "Tehran";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.MOSCOW);
		neighbors.add(CityEnum.BAGHDAD);
		neighbors.add(CityEnum.KARACHI);
		neighbors.add(CityEnum.DELHI);
	}
}
