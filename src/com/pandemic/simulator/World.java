package com.pandemic.simulator;

import java.util.Map;

import com.pandemic.cities.City;
import com.pandemic.cities.CityEnum;

/**
 * A wrapper that represents the map of the world at a moment in time. That is,
 * it is a {@code Map<CityEnum,City>}.
 * 
 * @author Brady
 */
public class World {
	private Map<CityEnum, City> worldMap;

	/**
	 * Constructor for a {@code World} wrapper.
	 * 
	 * @param worldMap
	 *            the {@code Map<CityEnum, City>} that represents the map of the
	 *            world.
	 */
	public World(Map<CityEnum, City> worldMap) {
		this.worldMap = worldMap;
	}

	public Map<CityEnum, City> getWorldMap() {
		return worldMap;
	}

	public void setWorldMap(Map<CityEnum, City> worldMap) {
		this.worldMap = worldMap;
	}
}
