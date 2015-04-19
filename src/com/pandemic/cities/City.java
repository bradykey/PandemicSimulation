package com.pandemic.cities;

import java.util.List;

/**
 * The {@code City} object that represents one of the 48 cities on the Pandemic
 * board game map. Any specific instance of a city should extend this class.
 * 
 * @author BKey
 */
public abstract class City {

	protected String name;
	protected int infectionLevel = 0;
	protected List<CityEnum> neighbors;

	// Begin getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInfectionLevel() {
		return infectionLevel;
	}

	public void setInfectionLevel(int infectionLevel) {
		this.infectionLevel = infectionLevel;
	}

	public List<CityEnum> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<CityEnum> neighbors) {
		this.neighbors = neighbors;
	}

}
