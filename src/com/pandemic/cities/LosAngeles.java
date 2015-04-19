package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Los Angeles.
 * 
 * @author BKey
 */
public class LosAngeles extends City {

	/**
	 * The default constructor for {@code LosAngeles}.
	 */
	public LosAngeles() {
	}

	/**
	 * The constructor for {@code LosAngeles}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public LosAngeles(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code LosAngeles}.
	 */
	private void init(int infectionLevel) {
		name = "Los Angeles";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SYDNEY);
		neighbors.add(CityEnum.SAN_FRANSISCO);
		neighbors.add(CityEnum.CHICAGO);
		neighbors.add(CityEnum.MEXICO_CITY);
	}
}
