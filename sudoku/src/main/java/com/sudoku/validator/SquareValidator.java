package com.sudoku.validator;

import com.sudoku.Board;
import com.sudoku.Position;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
public class SquareValidator implements Validator {

	private final Board board;
	private final int numRows;
	private final int numCols;

	public SquareValidator(final Board board) {
		this.board = board;
		numRows = board.getLength();
		numCols = board.getLength();
	}

	@Override
	public boolean isValid() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				final byte val = board.getValue(row, col);
				if (val == Square.INVALID_VALUE) {
					System.out.println(Position.getInstance(row, col)
							+ " was invalid");
					return false;
				}
			}
		}
		return true;
	}

}
