package com.sudoku.validator;

import com.sudoku.Board;

/**
 * @author Matt Kent
 */
public class UncompletedBoardValidator implements Validator {

	private final AllBoxesValidator boxValidator;
	private final AllRowsValidator rowValidator;
	private final AllColumnsValidator columnValidator;

	public UncompletedBoardValidator(final Board board) {
		this.boxValidator = AllBoxesValidator.newInstance(board);
		this.rowValidator = AllRowsValidator.newInstance(board);
		this.columnValidator = AllColumnsValidator.newInstance(board);
	}

	@Override
	public boolean isValid() {
		return boxValidator.isValid() && rowValidator.isValid()
				&& columnValidator.isValid();
	}

}
