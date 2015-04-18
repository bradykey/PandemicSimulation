package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Cairo.
 * 
 * @author BKey
 */
public class Cairo extends City {

	/**
	 * The default constructor for {@code Cairo}.
	 */
	public Cairo() {
	}

	/**
	 * The constructor for {@code Cairo}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Cairo(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Cairo}.
	 */
	private void init(int infectionLevel) {
		this.setName("Cairo");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.ALGIERS);
		neighbors.add(CityEnum.ISTANBUL);
		neighbors.add(CityEnum.BAGHDAD);
		neighbors.add(CityEnum.RIYADH);
		neighbors.add(CityEnum.KHARTOUM);
	}
}
