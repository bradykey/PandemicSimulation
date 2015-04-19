package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Atlanta.
 * 
 * @author BKey
 */
public class Atlanta extends City {

	/**
	 * The default constructor for {@code Atlanta}.
	 */
	public Atlanta() {
	}

	/**
	 * The constructor for {@code Atlanta}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Atlanta(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Atlanta}.
	 */
	private void init(int infectionLevel) {
		name = "Atlanta";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CHICAGO);
		neighbors.add(CityEnum.WASHINGTON);
		neighbors.add(CityEnum.MIAMI);
	}
}
