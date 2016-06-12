package com.sudoku.validator;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class RowValidatorTest extends AbstractValidatorSize9Test {

	@Override
	Validator getValidator(final int[][] board) {
		return AllRowsValidator.newInstance(Boards.getBoard(board));
	}

}
