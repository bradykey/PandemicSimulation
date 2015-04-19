package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Cairo.
 * 
 * @author BKey
 */
public class Cairo extends City {

	/**
	 * The default constructor for {@code Cairo}.
	 */
	public Cairo() {
	}

	/**
	 * The constructor for {@code Cairo}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Cairo(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Cairo}.
	 */
	private void init(int infectionLevel) {
		name = "Cairo";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.ALGIERS);
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.BAGHDAD);
		neighbors.add(CityEnum.RIYADH);
		neighbors.add(CityEnum.KHARTOUM);
	}
}
