package com.sudoku.updater;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sudoku.Board;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
public abstract class UpdaterTest {

	Board board;
	Updater updater;
	Map<Square, Integer> updatedValues;

	@Before
	public void setupUpdaterTest() {
		updatedValues = new HashMap<Square, Integer>();
	}

	abstract void setBoard();

	abstract void setUpdater();

	abstract void addUpdatedValues();

	@Test
	public void test() {
		setBoard();
		setUpdater();
		addUpdatedValues();
		for (int row = 0; row < board.getLength(); row++) {
			for (int col = 0; col < board.getLength(); col++) {
				updater.update(board.getSquare(row, col));
			}
		}
		for (final Square square : updatedValues.keySet()) {
			Assert.assertTrue(updatedValues.get(square) == square.getValue());
		}
	}

}
