package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Mumbai.
 * 
 * @author BKey
 */
public class Mumbai extends City {

	/**
	 * The default constructor for {@code Mumbai}.
	 */
	public Mumbai() {
	}

	/**
	 * The constructor for {@code Mumbai}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Mumbai(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Mumbai}.
	 */
	private void init(int infectionLevel) {
		name = "Mumbai";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.KARACHI);
		neighbors.add(CityEnum.DELHI);
		neighbors.add(CityEnum.CHENNAI);
	}
}
