package com.sudoku.updater;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class UpdaterFromColumnTest extends UpdaterTest {

	private static final int[][] BOARD = new int[][] //
	{
	/*    */{ 0, 0, 5, 2, 6, 9, 7, 8, 1 },//
			{ 6, 8, 0, 0, 7, 1, 4, 9, 3 },//
			{ 1, 9, 7, 8, 3, 4, 5, 6, 2 },//
			{ 8, 2, 6, 1, 9, 5, 3, 4, 7 },//
			{ 3, 7, 4, 6, 0, 0, 9, 1, 5 },//
			{ 9, 5, 1, 7, 4, 3, 6, 2, 8 },//
			{ 5, 1, 9, 3, 2, 6, 0, 7, 4 },//
			{ 2, 4, 8, 9, 5, 7, 1, 0, 6 },//
			{ 7, 6, 3, 4, 1, 8, 2, 5, 0 } //
	};

	@Override
	void setBoard() {
		board = Boards.getBoard(BOARD);
	}

	@Override
	void setUpdater() {
		updater = new ColumnUpdater(board);
	}

	@Override
	void addUpdatedValues() {
		updatedValues.put(board.getSquare(0, 0), 4);
		updatedValues.put(board.getSquare(0, 1), 3);
		updatedValues.put(board.getSquare(1, 2), 2);
		updatedValues.put(board.getSquare(1, 3), 5);
		updatedValues.put(board.getSquare(4, 4), 8);
		updatedValues.put(board.getSquare(4, 5), 2);
		updatedValues.put(board.getSquare(6, 6), 8);
		updatedValues.put(board.getSquare(7, 7), 3);
		updatedValues.put(board.getSquare(8, 8), 9);
	}

}
