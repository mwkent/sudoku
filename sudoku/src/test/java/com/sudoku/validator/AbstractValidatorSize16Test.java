package com.sudoku.validator;

import org.junit.Assert;
import org.junit.Test;

import com.sudoku.BoardsSize16;

/**
 * @author Matt Kent
 */
public abstract class AbstractValidatorSize16Test {

	Validator validator;

	abstract Validator getValidator(int[][] board);

	@Test
	public void testAllZeros() {
		validator = getValidator(BoardsSize16.EMPTY);
		Assert.assertTrue(validator.isValid());
	}

	@Test
	public void testInvalidBoard() {
		validator = getValidator(BoardsSize16.INVALID);
		Assert.assertFalse(validator.isValid());
	}

	// @Test
	// public void testCompletedBoard() {
	// validator = getValidator(Boards.completedBoard());
	// Assert.assertTrue(validator.isValid());
	// }
	//
	// @Test
	// public void testIncompleteBoard() {
	// validator = getValidator(Boards.incompleteBoard());
	// Assert.assertTrue(validator.isValid());
	// }

}
