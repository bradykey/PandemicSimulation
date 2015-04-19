package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Madrid.
 * 
 * @author BKey
 */
public class Madrid extends City {

	/**
	 * The default constructor for {@code Madrid}.
	 */
	public Madrid() {
	}

	/**
	 * The constructor for {@code Madrid}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Madrid(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Madrid}.
	 */
	private void init(int infectionLevel) {
		name = "Madrid";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SAO_PAULO);
		neighbors.add(CityEnum.NEW_YORK);
		neighbors.add(CityEnum.LONDON);
		neighbors.add(CityEnum.PARIS);
		neighbors.add(CityEnum.ALGIERS);
	}
}
