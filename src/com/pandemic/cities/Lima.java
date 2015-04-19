package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Lima.
 * 
 * @author BKey
 */
public class Lima extends City {

	/**
	 * The default constructor for {@code Lima}.
	 */
	public Lima() {
	}

	/**
	 * The constructor for {@code Lima}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Lima(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Lima}.
	 */
	private void init(int infectionLevel) {
		name = "Lima";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SANTIAGO);
		neighbors.add(CityEnum.MEXICO_CITY);
		neighbors.add(CityEnum.BOGOTA);
	}
}
