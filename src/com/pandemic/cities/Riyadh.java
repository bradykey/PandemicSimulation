package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Riyadh.
 * 
 * @author BKey
 */
public class Riyadh extends City {

	/**
	 * The default constructor for {@code Riyadh}.
	 */
	public Riyadh() {
	}

	/**
	 * The constructor for {@code Riyadh}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Riyadh(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Riyadh}.
	 */
	private void init(int infectionLevel) {
		this.setName("Riyadh");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CAIRO);
		neighbors.add(CityEnum.BAGHDAD);
		neighbors.add(CityEnum.KARACHI);
	}
}
