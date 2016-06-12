package com.sudoku.updater;

import com.sudoku.Board;
import com.sudoku.Position;
import com.sudoku.Square;

/**
 * @author Matt Kent
 */
class BoxUpdater implements Updater {

	private final Board board;
	private final int boxSize;

	BoxUpdater(final Board board) {
		this.board = board;
		boxSize = board.getBoxSize();
	}

	/**
	 * Updates the box with the square's value.
	 */
	@Override
	public boolean update(final Square square) {
		boolean updated = false;
		final byte takenValue = square.getValue();
		if (takenValue != Square.INVALID_VALUE) {
			final Position pos = square.getPosition();
			final int startRow = pos.getRow() / boxSize * boxSize;
			final int startCol = pos.getCol() / boxSize * boxSize;
			final int endRow = startRow + boxSize;
			final int endCol = startCol + boxSize;
			for (int row = startRow; row < endRow; row++) {
				for (int col = startCol; col < endCol; col++) {
					if (board.getSquare(row, col).removePossibleValueAndUpdate(
							takenValue)) {
						updated = true;
					}
				}
			}
		}
		return updated;
	}

}
