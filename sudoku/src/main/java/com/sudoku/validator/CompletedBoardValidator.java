package com.sudoku.validator;

import com.sudoku.Board;

/**
 * @author Matt Kent
 */
public class CompletedBoardValidator implements Validator {

	private final UncompletedBoardValidator uncompletedBoardValidator;
	private final SquareValidator squareValidator;

	public CompletedBoardValidator(final Board board) {
		uncompletedBoardValidator = new UncompletedBoardValidator(board);
		squareValidator = new SquareValidator(board);
	}

	@Override
	public boolean isValid() {
		return squareValidator.isValid() && uncompletedBoardValidator.isValid();
	}

}
