package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Santiago.
 * 
 * @author BKey
 */
public class Santiago extends City {

	/**
	 * The default constructor for {@code Santiago}.
	 */
	public Santiago() {
	}

	/**
	 * The constructor for {@code Santiago}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Santiago(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Santiago}.
	 */
	private void init(int infectionLevel) {
		name = "Santiago";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.LIMA);
	}
}
