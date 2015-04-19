package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Bogota.
 * 
 * @author BKey
 */
public class Bogota extends City {

	/**
	 * The default constructor for {@code Bogota}.
	 */
	public Bogota() {
	}

	/**
	 * The constructor for {@code Bogota}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Bogota(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Bogota}.
	 */
	private void init(int infectionLevel) {
		name = "Bogota";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.SAO_PAULO);
		neighbors.add(CityEnum.BUENOS_AIRES);
		neighbors.add(CityEnum.LIMA);
		neighbors.add(CityEnum.MEXICO_CITY);
		neighbors.add(CityEnum.MIAMI);
	}
}
