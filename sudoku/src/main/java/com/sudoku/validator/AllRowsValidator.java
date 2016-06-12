package com.sudoku.validator;

import java.util.ArrayList;
import java.util.List;

import com.sudoku.Board;

/**
 * @author Matt Kent
 */
public class AllRowsValidator implements Validator {

	private final List<RowValidator> rowValidators;

	public static AllRowsValidator newInstance(final Board board) {
		final List<RowValidator> rowValidators = new ArrayList<>(
				board.getLength());
		for (int row = 0; row < board.getLength(); row++) {
			rowValidators.add(new RowValidator(board, row));
		}
		return new AllRowsValidator(rowValidators);
	}

	AllRowsValidator(final List<RowValidator> rowValidators) {
		this.rowValidators = new ArrayList<RowValidator>(rowValidators);
	}

	@Override
	public boolean isValid() {
		for (final RowValidator rowValidator : rowValidators) {
			if (!rowValidator.isValid()) {
				return false;
			}
		}
		return true;
	}

}
