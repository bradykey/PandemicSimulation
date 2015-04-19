package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Bangkok.
 * 
 * @author BKey
 */
public class Bangkok extends City {

	/**
	 * The default constructor for {@code Bangkok}.
	 */
	public Bangkok() {
	}

	/**
	 * The constructor for {@code Bangkok}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Bangkok(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Bangkok}.
	 */
	private void init(int infectionLevel) {
		name = "Bangkok";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CHENNAI);
		neighbors.add(CityEnum.KOLKATA);
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.HO_CHI_MINH_CITY);
		neighbors.add(CityEnum.JAKARTA);
	}
}
