package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Delhi.
 * 
 * @author BKey
 */
public class Delhi extends City {

	/**
	 * The default constructor for {@code Delhi}.
	 */
	public Delhi() {
	}
	
	/**
	 * The constructor for {@code Delhi}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Delhi(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Delhi}.
	 */
	private void init(int infectionLevel) {
		this.setName("Delhi");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.TEHRAN);
		neighbors.add(CityEnum.KARACHI);
		neighbors.add(CityEnum.MUMBAI);
		neighbors.add(CityEnum.CHENNAI);
		neighbors.add(CityEnum.KOLKATA);
	}
}
