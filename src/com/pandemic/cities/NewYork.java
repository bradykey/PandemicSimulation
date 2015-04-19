package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents New York.
 * 
 * @author BKey
 */
public class NewYork extends City {

	/**
	 * The default constructor for {@code NewYork}.
	 */
	public NewYork() {
	}

	/**
	 * The constructor for {@code NewYork}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public NewYork(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code NewYork}.
	 */
	private void init(int infectionLevel) {
		name = "New York";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.WASHINGTON);
		neighbors.add(CityEnum.MONTREAL);
		neighbors.add(CityEnum.LONDON);
		neighbors.add(CityEnum.MADRID);
	}
}
