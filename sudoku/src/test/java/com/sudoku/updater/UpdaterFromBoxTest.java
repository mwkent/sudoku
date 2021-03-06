package com.sudoku.updater;

import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class UpdaterFromBoxTest extends UpdaterTest {

	private static final int[][] BOARD = new int[][] //
	{
	/*    */{ 0, 3, 5, 2, 6, 9, 7, 8, 1 },//
			{ 6, 8, 2, 5, 0, 1, 4, 9, 3 },//
			{ 1, 9, 7, 8, 3, 4, 5, 6, 0 },//
			{ 0, 2, 6, 1, 9, 5, 3, 4, 7 },//
			{ 3, 7, 4, 6, 0, 2, 9, 1, 5 },//
			{ 9, 5, 1, 7, 4, 3, 6, 2, 0 },//
			{ 0, 1, 9, 3, 2, 6, 8, 7, 4 },//
			{ 2, 4, 8, 9, 0, 7, 1, 3, 6 },//
			{ 7, 6, 3, 4, 1, 8, 2, 5, 0 } //
	};

	@Override
	void setBoard() {
		board = Boards.getBoard(BOARD);
	}

	@Override
	void setUpdater() {
		updater = new BoxUpdater(board);
	}

	@Override
	void addUpdatedValues() {
		updatedValues.put(board.getSquare(0, 0), 4);
		updatedValues.put(board.getSquare(3, 0), 8);
		updatedValues.put(board.getSquare(6, 0), 5);
		updatedValues.put(board.getSquare(1, 4), 7);
		updatedValues.put(board.getSquare(4, 4), 8);
		updatedValues.put(board.getSquare(7, 4), 5);
		updatedValues.put(board.getSquare(2, 8), 2);
		updatedValues.put(board.getSquare(5, 8), 8);
		updatedValues.put(board.getSquare(8, 8), 9);
	}

}
