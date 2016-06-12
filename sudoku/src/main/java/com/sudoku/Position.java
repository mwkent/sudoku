package com.sudoku;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author Matt Kent
 */
public class Position {

	private static final Map<Pair<Integer, Integer>, Position> CACHED_POSITIONS = new HashMap<>();

	private final int row;
	private final int col;

	public static Position getInstance(final int row, final int col) {
		if (CACHED_POSITIONS.get(Pair.of(row, col)) == null) {
			CACHED_POSITIONS.put(Pair.of(row, col), new Position(row, col));
		}
		return CACHED_POSITIONS.get(Pair.of(row, col));
	}

	private Position(final int row, final int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}

}
