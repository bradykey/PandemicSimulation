package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Baghdad.
 * 
 * @author BKey
 */
public class Baghdad extends City {

	/**
	 * The default constructor for {@code Baghdad}.
	 */
	public Baghdad() {
	}

	/**
	 * The constructor for {@code Baghdad}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Baghdad(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Baghdad}.
	 */
	private void init(int infectionLevel) {
		this.setName("Baghdad");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CAIRO);
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.TEHRAN);
		neighbors.add(CityEnum.KARACHI);
		neighbors.add(CityEnum.RIYADH);
	}
}
