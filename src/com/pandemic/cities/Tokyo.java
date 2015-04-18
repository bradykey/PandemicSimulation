package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Tokyo.
 * 
 * @author BKey
 */
public class Tokyo extends City {

	/**
	 * The default constructor for {@code Tokyo}.
	 */
	public Tokyo() {
	}

	/**
	 * The constructor for {@code Tokyo}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Tokyo(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Tokyo}.
	 */
	private void init(int infectionLevel) {
		this.setName("Tokyo");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SEOUL);
		neighbors.add(CityEnum.SHANGHAI);
		neighbors.add(CityEnum.OSAKA);
		neighbors.add(CityEnum.SAN_FRANSISCO);
	}
}
