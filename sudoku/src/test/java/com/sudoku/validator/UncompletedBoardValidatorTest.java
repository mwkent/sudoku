package com.sudoku.validator;

import org.junit.Assert;
import org.junit.Test;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class UncompletedBoardValidatorTest extends AbstractValidatorSize9Test {

	@Test
	public void testTestBoard() {
		validator = getValidator(Boards.testBoard());
		Assert.assertFalse(validator.isValid());
	}

	@Override
	Validator getValidator(final int[][] board) {
		return new UncompletedBoardValidator(Boards.getBoard(board));
	}

}
