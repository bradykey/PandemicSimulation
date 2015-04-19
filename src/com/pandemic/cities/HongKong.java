package com.pandemic.cities;

import java.util.ArrayList;

/**
 * The specific {@link City} object that represents Hong Kong.
 * 
 * @author BKey
 */
public class HongKong extends City {

	/**
	 * The default constructor for {@code HongKong}.
	 */
	public HongKong() {
	}

	/**
	 * The constructor for {@code HongKong}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public HongKong(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code HongKong}.
	 */
	private void init(int infectionLevel) {
		name = "Hong Kong";
		this.infectionLevel = infectionLevel;

		// build the geographical neighbors
		neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.KOLKATA);
		neighbors.add(CityEnum.SHANGHAI);
		neighbors.add(CityEnum.TAIPEI);
		neighbors.add(CityEnum.MANILA);
		neighbors.add(CityEnum.HO_CHI_MINH_CITY);
	}
}
