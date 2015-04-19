package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Delhi.
 * 
 * @author BKey
 */
public class Delhi extends City {

	/**
	 * The default constructor for {@code Delhi}.
	 */
	public Delhi() {
	}

	/**
	 * The constructor for {@code Delhi}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Delhi(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Delhi}.
	 */
	private void init(int infectionLevel) {
		name = "Delhi";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.TEHRAN);
		neighbors.add(CityEnum.KARACHI);
		neighbors.add(CityEnum.MUMBAI);
		neighbors.add(CityEnum.CHENNAI);
		neighbors.add(CityEnum.KOLKATA);
	}
}
