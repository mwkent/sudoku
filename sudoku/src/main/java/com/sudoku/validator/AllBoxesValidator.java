package com.sudoku.validator;

import java.util.ArrayList;
import java.util.List;

import com.sudoku.Board;

/**
 * Validates all boxes in the given board.
 * 
 * @author Matt Kent
 */
public class AllBoxesValidator implements Validator {

	private final List<BoxValidator> boxValidators;

	public static AllBoxesValidator newInstance(final Board board) {
		final List<BoxValidator> boxValidators = new ArrayList<>(
				board.getLength());
		for (int boxRow = 0; boxRow < board.getBoxSize(); boxRow++) {
			for (int boxCol = 0; boxCol < board.getBoxSize(); boxCol++) {
				boxValidators.add(new BoxValidator(board, boxRow, boxCol));
			}
		}
		return new AllBoxesValidator(boxValidators);
	}

	AllBoxesValidator(final List<BoxValidator> boxValidators) {
		this.boxValidators = new ArrayList<BoxValidator>(boxValidators);
	}

	@Override
	public boolean isValid() {
		for (final BoxValidator boxValidator : boxValidators) {
			if (!boxValidator.isValid()) {
				return false;
			}
		}
		return true;
	}

}
