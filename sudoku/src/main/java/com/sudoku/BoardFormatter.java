package com.sudoku;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Matt Kent
 */
public class BoardFormatter {

	private final Board board;

	BoardFormatter(final Board board) {
		this.board = board;
	}

	public String format() {
		final StringBuilder result = new StringBuilder();
		for (int row = 0; row < board.getLength(); row++) {
			result.append("[");
			for (int col = 0; col < board.getLength(); col++) {
				final byte val = board.getSquare(row, col).getValue();
				result.append(val);
				result.append(StringUtils.repeat(" ",
						numDigitsToAdd(val, board.getLength())));
				result.append(", ");
			}
			result.delete(result.length() - 2, result.length());
			result.append("]\n");
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}

	private int getNumDigits(final int n) {
		return String.valueOf(n).length();
	}

	private int numDigitsToAdd(final int smaller, final int larger) {
		return getNumDigits(larger) - getNumDigits(smaller);
	}

}
