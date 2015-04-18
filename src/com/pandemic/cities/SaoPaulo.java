package com.pandemic.cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The specific {@link City} object that represents Sao Paulo.
 * 
 * @author BKey
 */
public class SaoPaulo extends City {

	/**
	 * The default constructor for {@code SaoPaulo}.
	 */
	public SaoPaulo() {
	}

	/**
	 * The constructor for {@code SaoPaulo}.
	 * 
	 * @param infectionLevel
	 *            the default infection level of this city.
	 */
	public SaoPaulo(int infectionLevel) {
		init(infectionLevel);
	}

	/**
	 * Initialize the {@code City} specifically for {@code SaoPaulo}.
	 */
	private void init(int infectionLevel) {
		this.setName("Sao Paulo");
		this.setInfectionLevel(infectionLevel);

		// build the geographical neighbors
		List<CityEnum> neighbors = new ArrayList<CityEnum>();
		neighbors.add(CityEnum.BUENOS_AIRES);
		neighbors.add(CityEnum.BOGOTA);
		neighbors.add(CityEnum.MADRID);
		neighbors.add(CityEnum.LAGOS);
	}
}
