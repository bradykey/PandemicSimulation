package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Paris.
 * 
 * @author BKey
 */
public class Paris extends City {

	/**
	 * The default constructor for {@code Paris}.
	 */
	public Paris() {
	}

	/**
	 * The constructor for {@code Paris}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public Paris(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code Paris}.
	 */
	private void init(int infectionLevel) {
		this.setName("Paris");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.MADRID);
		neighbors.add(CityEnum.LONDON);
		neighbors.add(CityEnum.ESSEN);
		neighbors.add(CityEnum.MILAN);
		neighbors.add(CityEnum.ALGIERS);
	}
}
