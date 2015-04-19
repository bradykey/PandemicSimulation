package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Miami.
 * 
 * @author BKey
 */
public class Miami extends City {

	/**
	 * The default constructor for {@code Miami}.
	 */
	public Miami() {
	}

	/**
	 * The constructor for {@code Miami}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Miami(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Miami}.
	 */
	private void init(int infectionLevel) {
		name = "Miami";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BOGOTA);
		neighbors.add(CityEnum.MEXICO_CITY);
		neighbors.add(CityEnum.ATLANTA);
		neighbors.add(CityEnum.WASHINGTON);
	}
}
