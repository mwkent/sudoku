package com.sudoku.validator;

import org.junit.Assert;
import org.junit.Test;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class SquareValidatorTest extends AbstractValidatorSize9Test {

	@Override
	@Test
	public void testAllZeros() {
		validator = getValidator(Boards.allZeros());
		Assert.assertFalse(validator.isValid());
	}

	@Override
	@Test
	public void testIncompleteBoard() {
		validator = getValidator(Boards.incompleteBoard());
		Assert.assertFalse(validator.isValid());
	}

	@Override
	Validator getValidator(final int[][] board) {
		return new SquareValidator(Boards.getBoard(board));
	}

}
