package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents St. Petersburg.
 * 
 * @author BKey
 */
public class StPetersburg extends City {

	/**
	 * The default constructor for {@code StPetersburg}.
	 */
	public StPetersburg() {
	}

	/**
	 * The constructor for {@code StPetersburg}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public StPetersburg(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code StPetersburg}.
	 */
	private void init(int infectionLevel) {
		this.setName("St. Petersburg");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.ESSEN);
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.MOSCOW);
	}
}
