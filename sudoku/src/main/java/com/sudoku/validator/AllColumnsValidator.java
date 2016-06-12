package com.sudoku.validator;

import java.util.ArrayList;
import java.util.List;

import com.sudoku.Board;

/**
 * @author Matt Kent
 */
public class AllColumnsValidator implements Validator {

	private final List<ColumnValidator> columnValidators;

	public static AllColumnsValidator newInstance(final Board board) {
		final List<ColumnValidator> columnValidators = new ArrayList<>(
				board.getLength());
		for (int col = 0; col < board.getLength(); col++) {
			columnValidators.add(new ColumnValidator(board, col));
		}
		return new AllColumnsValidator(columnValidators);
	}

	AllColumnsValidator(final List<ColumnValidator> columnValidators) {
		this.columnValidators = new ArrayList<ColumnValidator>(columnValidators);
	}

	@Override
	public boolean isValid() {
		for (final ColumnValidator columnValidator : columnValidators) {
			if (!columnValidator.isValid()) {
				return false;
			}
		}
		return true;
	}

}
