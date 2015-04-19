package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Lagos.
 * 
 * @author BKey
 */
public class Lagos extends City {

	/**
	 * The default constructor for {@code Lagos}.
	 */
	public Lagos() {
	}

	/**
	 * The constructor for {@code Lagos}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Lagos(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Lagos}.
	 */
	private void init(int infectionLevel) {
		name = "Lagos";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SAO_PAULO);
		neighbors.add(CityEnum.KINSHASA);
		neighbors.add(CityEnum.KHARTOUM);
	}
}
