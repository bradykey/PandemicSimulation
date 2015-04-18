package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

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
		this.setName("Ho Chi Minh City");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.JAKARTA);
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.HONG_KONG);
		neighbors.add(CityEnum.MANILA);
	}
}
