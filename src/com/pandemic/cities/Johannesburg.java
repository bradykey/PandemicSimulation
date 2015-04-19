package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Johannesburg.
 * 
 * @author BKey
 */
public class Johannesburg extends City {

	/**
	 * The default constructor for {@code Johannesburg}.
	 */
	public Johannesburg() {
	}

	/**
	 * The constructor for {@code Johannesburg}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Johannesburg(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Johannesburg}.
	 */
	private void init(int infectionLevel) {
		name = "Johannesburg";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.KINSHASA);
		neighbors.add(CityEnum.KHARTOUM);
	}
}
