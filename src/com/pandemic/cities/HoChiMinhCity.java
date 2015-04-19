package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Ho Chi Minh City.
 * 
 * @author BKey
 */
public class HoChiMinhCity extends City {

	/**
	 * The default constructor for {@code HoChiMinhCity}.
	 */
	public HoChiMinhCity() {
	}

	/**
	 * The constructor for {@code HoChiMinhCity}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public HoChiMinhCity(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code HoChiMinhCity}.
	 */
	private void init(int infectionLevel) {
		name = "Ho Chi Minh City";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.JAKARTA);
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.MANILA);
	}
}
