package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Karachi.
 * 
 * @author BKey
 */
public class Karachi extends City {

	/**
	 * The default constructor for {@code Karachi}.
	 */
	public Karachi() {
	}

	/**
	 * The constructor for {@code Karachi}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Karachi(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Karachi}.
	 */
	private void init(int infectionLevel) {
		this.setName("Karachi");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.RIYADH);
		neighbors.add(CityEnum.BAGHDAD);
		neighbors.add(CityEnum.TEHRAN);
		neighbors.add(CityEnum.DELHI);
		neighbors.add(CityEnum.MUMBAI);
	}
}
