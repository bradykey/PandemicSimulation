package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Mexico City.
 * 
 * @author BKey
 */
public class MexicoCity extends City {

	/**
	 * The default constructor for {@code MexicoCity}.
	 */
	public MexicoCity() {
	}

	/**
	 * The constructor for {@code MexicoCity}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public MexicoCity(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code MexicoCity}.
	 */
	private void init(int infectionLevel) {
		this.setName("Mexico City");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.LOS_ANGELES);
		neighbors.add(CityEnum.CHICAGO);
		neighbors.add(CityEnum.MIAMI);
		neighbors.add(CityEnum.BOGOTA);
		neighbors.add(CityEnum.LIMA);
	}
}
