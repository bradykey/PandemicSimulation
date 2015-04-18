package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Shanghai.
 * 
 * @author BKey
 */
public class Shanghai extends City {

	/**
	 * The default constructor for {@code Shanghai}.
	 */
	public Shanghai() {
	}

	/**
	 * The constructor for {@code Shanghai}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Shanghai(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Shanghai}.
	 */
	private void init(int infectionLevel) {
		this.setName("Shanghai");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BEIJING);
		neighbors.add(CityEnum.SEOUL);
		neighbors.add(CityEnum.TOKYO);
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.TAIPEI);
	}
}
