package com.sudoku;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matt Kent
 */
public class PositionTest {

	@Test
	public void test() {
		final int row = 125;
		final int col = -5;
		final Position pos = Position.getInstance(row, col);
		Assert.assertEquals(row, pos.getRow());
		Assert.assertEquals(col, pos.getCol());
		final Position pos2 = Position.getInstance(row, col);
		Assert.assertEquals(row, pos2.getRow());
		Assert.assertEquals(col, pos2.getCol());
	}

}
