package com.pandemic.simulator;

import java.util.List;

import com.pandemic.simulator.actions.Action;

/**
 * This class represents a turn of a player. A {@code Turn} consists of 4
 * {@link Action}s.
 * 
 * @author Brady
 */
public class Turn {
	private List<Action> actions;

	/**
	 * The main constructor for a {@code Turn}. A turn has exactly
	 * {@code NUM_ACTIONS_PER_TURN} actions.
	 * 
	 * @param actions
	 *            the {@code List<Action>} that defines this {@code Turn}.
	 */
	public Turn(List<Action> actions) {
		this.actions = actions;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
