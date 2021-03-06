package com.sudoku.validator;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class AllBoxesValidatorTest extends AbstractValidatorSize9Test {

	@Override
	Validator getValidator(final int[][] board) {
		return AllBoxesValidator.newInstance(Boards.getBoard(board));
	}

}
