package com.sudoku.validator;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class ColumnValidatorTest extends AbstractValidatorSize9Test {

	@Override
	Validator getValidator(final int[][] board) {
		return AllColumnsValidator.newInstance(Boards.getBoard(board));
	}

}
