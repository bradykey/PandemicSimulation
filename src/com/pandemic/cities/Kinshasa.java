package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Kinshasa.
 * 
 * @author BKey
 */
public class Kinshasa extends City {

	/**
	 * The default constructor for {@code Kinshasa}.
	 */
	public Kinshasa() {
	}

	/**
	 * The constructor for {@code Kinshasa}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Kinshasa(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Kinshasa}.
	 */
	private void init(int infectionLevel) {
		this.setName("Kinshasa");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.LAGOS);
		neighbors.add(CityEnum.KHARTOUM);
		neighbors.add(CityEnum.JOHANNESBURG);
	}
}
