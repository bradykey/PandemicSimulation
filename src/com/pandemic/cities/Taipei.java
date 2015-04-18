package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Taipei.
 * 
 * @author BKey
 */
public class Taipei extends City {

	/**
	 * The default constructor for {@code Taipei}.
	 */
	public Taipei() {
	}

	/**
	 * The constructor for {@code Taipei}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Taipei(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Taipei}.
	 */
	private void init(int infectionLevel) {
		this.setName("Taipei");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.SHANGHAI);
		neighbors.add(CityEnum.OSAKA);
		neighbors.add(CityEnum.MANILA);
	}
}
