package com.pandemic.simulator.actions;

import com.pandemic.cities.CityEnum;

/**
 * This class is a concrete {@link Action} that represents a move to a certain
 * {@linke City}.
 * 
 * @author Brady
 */
public class MoveAction extends Action {

	private CityEnum moveTo;

	/**
	 * The constructor of a {@code MoveAction}. This defines the city in which
	 * the player is to move.
	 * 
	 * @param moveTo
	 */
	public MoveAction(CityEnum moveTo) {
		this.moveTo = moveTo;
	}

	public CityEnum getMoveTo() {
		return moveTo;
	}

	public void setMoveTo(CityEnum moveTo) {
		this.moveTo = moveTo;
	}
}
