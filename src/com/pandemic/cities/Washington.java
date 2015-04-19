package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Washington.
 * 
 * @author BKey
 */
public class Washington extends City {

	/**
	 * The default constructor for {@code Washington}.
	 */
	public Washington() {
	}

	/**
	 * The constructor for {@code Washington}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Washington(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Washington}.
	 */
	private void init(int infectionLevel) {
		name = "Washington";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.MIAMI);
		neighbors.add(CityEnum.ATLANTA);
		neighbors.add(CityEnum.MONTREAL);
		neighbors.add(CityEnum.NEW_YORK);
	}
}
