package com.sudoku.updater;

import com.sudoku.Board;
import com.sudoku.Position;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
class RowUpdater implements Updater {

	private final Board board;

	RowUpdater(final Board board) {
		this.board = board;
	}

	/**
	 * Updates the row with the square's value.
	 */
	@Override
	public boolean update(final Square square) {
		final byte takenValue = square.getValue();
		boolean updated = false;
		if (takenValue != Square.INVALID_VALUE) {
			final Position pos = square.getPosition();
			final int row = pos.getRow();
			for (int col = 0; col < board.getLength(); col++) {
				if (board.getSquare(row, col).removePossibleValueAndUpdate(
						takenValue)) {
					updated = true;
				}
			}
		}
		return updated;
	}

}
