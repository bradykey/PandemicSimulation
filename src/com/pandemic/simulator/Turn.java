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

	private final int NUM_ACTIONS_PER_TURN = 4;

	private List<Action> actions;

	/**
	 * The main constructor for a {@code Turn}. A turn has exactly
	 * {@code NUM_ACTIONS_PER_TURN} actions.
	 * 
	 * @param actions
	 *            the {@code List<Action>} that defines this {@code Turn}.
	 * @throws Exception
	 *             if the number of actions is not equal to the
	 *             {@code NUM_ACTIONS_PER_TURN}.
	 */
	public Turn(List<Action> actions) throws Exception {
		if (actions.size() != NUM_ACTIONS_PER_TURN)
			throw new Exception(
					"The list of actions representing a turn must be equal to "
							+ NUM_ACTIONS_PER_TURN + ".");

		this.actions = actions;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
