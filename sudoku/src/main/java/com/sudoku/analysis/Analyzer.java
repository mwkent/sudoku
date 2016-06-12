package com.sudoku.analysis;

import com.sudoku.Board;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
public class Analyzer {

	private final Board board;

	public Analyzer(final Board board) {
		this.board = board;
	}

	public Square getSquareWithLeastPossibleValues() {
		Square minSquare = null;
		for (final Square square : board) {
			if (square.getValue() == Square.INVALID_VALUE
					&& (minSquare == null || square.getPossibleValues().size() < minSquare
							.getPossibleValues().size())) {
				minSquare = square;
			}
		}
		return minSquare;
	}

}
