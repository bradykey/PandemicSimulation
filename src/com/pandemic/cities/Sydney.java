package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Sydney.
 * 
 * @author BKey
 */
public class Sydney extends City {

	/**
	 * The default constructor for {@code Sydney}.
	 */
	public Sydney() {
	}

	/**
	 * The constructor for {@code Sydney}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Sydney(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Sydney}.
	 */
	private void init(int infectionLevel) {
		name = "Sydney";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.JAKARTA);
		neighbors.add(CityEnum.MANILA);
		neighbors.add(CityEnum.LOS_ANGELES);
	}
}
