package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Essen.
 * 
 * @author BKey
 */
public class Essen extends City {

	/**
	 * The default constructor for {@code Essen}.
	 */
	public Essen() {
	}

	/**
	 * The constructor for {@code Essen}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Essen(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Essen}.
	 */
	private void init(int infectionLevel) {
		name = "Essen";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.LONDON);
		neighbors.add(CityEnum.PARIS);
		neighbors.add(CityEnum.MILAN);
		neighbors.add(CityEnum.ST_PETERSBURG);
	}
}
