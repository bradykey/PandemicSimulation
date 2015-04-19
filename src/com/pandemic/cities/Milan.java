package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Milan.
 * 
 * @author BKey
 */
public class Milan extends City {

	/**
	 * The default constructor for {@code Milan}.
	 */
	public Milan() {
	}

	/**
	 * The constructor for {@code Milan}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Milan(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Milan}.
	 */
	private void init(int infectionLevel) {
		name = "Milan";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.PARIS);
		neighbors.add(CityEnum.ESSEN);
		neighbors.add(CityEnum.ISTANBUL);
	}
}
