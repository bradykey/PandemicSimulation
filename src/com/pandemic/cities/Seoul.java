package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Seoul.
 * 
 * @author BKey
 */
public class Seoul extends City {

	/**
	 * The default constructor for {@code Seoul}.
	 */
	public Seoul() {
	}

	/**
	 * The constructor for {@code Seoul}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Seoul(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Seoul}.
	 */
	private void init(int infectionLevel) {
		name = "Seoul";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BEIJING);
		neighbors.add(CityEnum.SHANGHAI);
		neighbors.add(CityEnum.TOKYO);
	}
}
