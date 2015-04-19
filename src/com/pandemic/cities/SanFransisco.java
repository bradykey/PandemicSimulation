package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents San Fransisco.
 * 
 * @author BKey
 */
public class SanFransisco extends City {

	/**
	 * The default constructor for {@code SanFransisco}.
	 */
	public SanFransisco() {
	}

	/**
	 * The constructor for {@code SanFransisco}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public SanFransisco(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code SanFransisco}.
	 */
	private void init(int infectionLevel) {
		name = "San Fransisco";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.TOKYO);
		neighbors.add(CityEnum.MANILA);
		neighbors.add(CityEnum.LOS_ANGELES);
		neighbors.add(CityEnum.CHICAGO);
	}
}
