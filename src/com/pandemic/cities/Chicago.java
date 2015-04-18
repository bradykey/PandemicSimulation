package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Chicago.
 * 
 * @author BKey
 */
public class Chicago extends City {

	/**
	 * The default constructor for {@code Chicago}.
	 */
	public Chicago() {
	}

	/**
	 * The constructor for {@code Chicago}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Chicago(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Chicago}.
	 */
	private void init(int infectionLevel) {
		this.setName("Chicago");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SAN_FRANSISCO);
		neighbors.add(CityEnum.LOS_ANGELES);
		neighbors.add(CityEnum.MEXICO_CITY);
		neighbors.add(CityEnum.ATLANTA);
		neighbors.add(CityEnum.MONTREAL);
	}
}
