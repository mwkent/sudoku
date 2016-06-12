package com.sudoku.validator;

import java.util.HashSet;
import java.util.Set;

import com.sudoku.Board;
import com.sudoku.Position;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
public class RowValidator implements Validator {

	private final Board board;
	private final int row;

	public RowValidator(final Board board, final int row) {
		this.board = board;
		this.row = row;
	}

	@Override
	public boolean isValid() {
		final Set<Byte> usedValues = new HashSet<Byte>(board.getLength());
		for (int col = 0; col < board.getLength(); col++) {
			final byte val = board.getValue(row, col);
			if (val != Square.INVALID_VALUE) {
				if (usedValues.contains(val)) {
					System.out.println(Position.getInstance(row, col)
							+ " was invalid in the row");
					return false;
				}
				usedValues.add(val);
			}
		}
		return true;
	}

}
