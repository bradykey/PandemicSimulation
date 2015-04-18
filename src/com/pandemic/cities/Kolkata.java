package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Kolkata.
 * 
 * @author BKey
 */
public class Kolkata extends City {

	/**
	 * The default constructor for {@code Kolkata}.
	 */
	public Kolkata() {
	}

	/**
	 * The constructor for {@code Kolkata}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Kolkata(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Kolkata}.
	 */
	private void init(int infectionLevel) {
		this.setName("Kolkata");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.DELHI);
		neighbors.add(CityEnum.CHENNAI);
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.HONG_KONG);
	}
}
