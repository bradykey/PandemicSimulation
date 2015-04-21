package com.pandemic.simulator;

import java.util.List;

/**
 * A wrapper for the {@code List<Turn>}s that defines a players path.
 * 
 * @author Brady
 */
public class Path implements Comparable<Path> {

	private List<Turn> turns;
	private int fitness;

	public Path(List<Turn> turn) {
		this.turns = turn;

		// fitness is defaulted
		fitness = -1;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(List<Turn> turn) {
		this.turns = turn;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	@Override
	public int compareTo(Path o) {
		int LESS = -1, EQUAL = 0, GREATER = 1;

		if (this.fitness < o.fitness)
			return LESS;
		else if (this.fitness > o.fitness)
			return GREATER;
		else
			return EQUAL;
	}
}
