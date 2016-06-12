package com.sudoku.validator;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class AllBoxesValidatorSize16Test extends AbstractValidatorSize16Test {

	@Override
	Validator getValidator(final int[][] board) {
		System.out.println();
		System.out.println(Boards.getBoard(board));
		return AllBoxesValidator.newInstance(Boards.getBoard(board));
	}

}
