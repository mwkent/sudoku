package com.sudoku;

import java.util.Comparator;

/**
 * @author Matt Kent
 */
public class PositionComparator implements Comparator<Square> {

	@Override
	public int compare(final Square o1, final Square o2) {
		final int row1 = o1.getPosition().getRow();
		final int col1 = o1.getPosition().getCol();
		final int row2 = o2.getPosition().getRow();
		final int col2 = o2.getPosition().getCol();
		if (row1 < row2) {
			return -1;
		}
		if (row1 > row2) {
			return 1;
		}
		if (col1 < col2) {
			return -1;
		}
		if (col1 > col2) {
			return 1;
		}
		if (o1.hashCode() < o2.hashCode()) {
			return -1;
		}
		if (o1.hashCode() > o2.hashCode()) {
			return 1;
		}
		return 0;
	}

}
