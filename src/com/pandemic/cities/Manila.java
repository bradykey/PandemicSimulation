package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Manila.
 * 
 * @author BKey
 */
public class Manila extends City {

	/**
	 * The default constructor for {@code Manila}.
	 */
	public Manila() {
	}

	/**
	 * The constructor for {@code Manila}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Manila(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Manila}.
	 */
	private void init(int infectionLevel) {
		name = "Manila";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.HO_CHI_MINH_CITY);
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.TAIPEI);
		neighbors.add(CityEnum.SAN_FRANSISCO);
		neighbors.add(CityEnum.SYDNEY);
	}
}
