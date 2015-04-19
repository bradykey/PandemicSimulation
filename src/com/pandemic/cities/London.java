package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents London.
 * 
 * @author BKey
 */
public class London extends City {

	/**
	 * The default constructor for {@code London}.
	 */
	public London() {
	}

	/**
	 * The constructor for {@code London}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public London(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code London}.
	 */
	private void init(int infectionLevel) {
		name = "London";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.NEW_YORK);
		neighbors.add(CityEnum.MADRID);
		neighbors.add(CityEnum.PARIS);
		neighbors.add(CityEnum.ESSEN);
	}
}
