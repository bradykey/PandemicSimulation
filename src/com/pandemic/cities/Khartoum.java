package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Khartoum.
 * 
 * @author BKey
 */
public class Khartoum extends City {

	/**
	 * The default constructor for {@code Khartoum}.
	 */
	public Khartoum() {
	}

	/**
	 * The constructor for {@code Khartoum}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Khartoum(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Khartoum}.
	 */
	private void init(int infectionLevel) {
		name = "Khartoum";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.JOHANNESBURG);
		neighbors.add(CityEnum.LAGOS);
		neighbors.add(CityEnum.CAIRO);
	}
}
