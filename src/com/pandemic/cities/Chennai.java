package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Chennai.
 * 
 * @author BKey
 */
public class Chennai extends City {

	/**
	 * The default constructor for {@code Chennai}.
	 */
	public Chennai() {
	}

	/**
	 * The constructor for {@code Chennai}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Chennai(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Chennai}.
	 */
	private void init(int infectionLevel) {
		name = "Chennai";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.MUMBAI);
		neighbors.add(CityEnum.DELHI);
		neighbors.add(CityEnum.KOLKATA);
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.JAKARTA);
	}
}
