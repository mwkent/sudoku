package com.sudoku;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matt Kent
 */
public class BoardTest {

	@Test
	public void testCopy() {
		final Board original = Boards.getBoard(Boards.allZeros());
		final Board copy = original.copy();
		final int row = 0;
		final int col = 0;
		copy.getSquare(row, col).setValue((byte) 1);
		Assert.assertEquals(0, original.getSquare(row, col).getValue());
		Assert.assertEquals(1, copy.getSquare(row, col).getValue());
	}

}
