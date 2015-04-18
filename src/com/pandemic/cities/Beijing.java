package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Beijing.
 * 
 * @author BKey
 */
public class Beijing extends City {

	/**
	 * The default constructor for {@code Beijing}.
	 */
	public Beijing() {
	}

	/**
	 * The constructor for {@code Beijing}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Beijing(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Beijing}.
	 */
	private void init(int infectionLevel) {
		this.setName("Beijing");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SHANGHAI);
		neighbors.add(CityEnum.SEOUL);
	}
}
