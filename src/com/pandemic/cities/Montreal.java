package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Montreal.
 * 
 * @author BKey
 */
public class Montreal extends City {

	/**
	 * The default constructor for {@code Montreal}.
	 */
	public Montreal() {
	}

	/**
	 * The constructor for {@code Montreal}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Montreal(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Montreal}.
	 */
	private void init(int infectionLevel) {
		name = "Montreal";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CHICAGO);
		neighbors.add(CityEnum.WASHINGTON);
		neighbors.add(CityEnum.NEW_YORK);
	}
}
