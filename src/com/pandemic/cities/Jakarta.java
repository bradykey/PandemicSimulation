package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Jakarta.
 * 
 * @author BKey
 */
public class Jakarta extends City {

	/**
	 * The default constructor for {@code Jakarta}.
	 */
	public Jakarta() {
	}

	/**
	 * The constructor for {@code Jakarta}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Jakarta(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Jakarta}.
	 */
	private void init(int infectionLevel) {
		this.setName("Jakarta");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.CHENNAI);
		neighbors.add(CityEnum.BANGKOK);
		neighbors.add(CityEnum.HO_CHI_MINH_CITY);
		neighbors.add(CityEnum.SYDNEY);
	}
}
