package com.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.sudoku.updater.SquareUpdater;
import com.sudoku.updater.Updater;
import com.sudoku.validator.UncompletedBoardValidator;
import com.sudoku.validator.Validator;

/**
 * Mutable
 * 
 * @author Matt Kent
 */
public class Board implements Iterable<Square> {

	private final Square[][] squares;
	private Updater updater;
	private UncompletedBoardValidator validator;
	private final int length;
	private final int boxSize;
	private List<Square> squareList;
	private final SortedSet<Square> unsetSquares = new TreeSet<>(
			new PositionComparator());
	private final SortedSet<Square> setSquares = new TreeSet<>(
			new PositionComparator());
	private boolean justUpdated = true;
	private int numUpdated = 0;

	public Board(final int[][] squares) {
		if (squares.length < 1) {
			throw new IllegalArgumentException(
					"squares must have a positive number of rows");
		}
		length = squares.length;
		boxSize = (int) Math.round(Math.sqrt(length));
		this.squares = new Square[length][length];
		initSquares(squares);
		setSquareList();
		initSetAndUnsetSquares();
	}

	private Updater getUpdater() {
		if (updater == null) {
			updater = new SquareUpdater(this);
		}
		return updater;
	}

	public void updateFromAll() {
		final SortedSet<Square> setSquaresCopy = new TreeSet<>(setSquares);
		for (final Square square : setSquaresCopy) {
			getUpdater().update(square);
		}
	}

	public void updateFrom(final Square square) {
		getUpdater().update(square);
	}

	private void initSetAndUnsetSquares() {
		for (final Square square : squareList) {
			if (square.isSet()) {
				setSquares.add(square);
				numUpdated++;
			} else {
				unsetSquares.add(square);
			}
		}
		// System.out.println("unsetSquares=" + unsetSquares);
	}

	private void initSquares(final int[][] squares) {
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				this.squares[row][col] = new Square((byte) squares[row][col],
						Position.getInstance(row, col), this);
			}
		}
	}

	public Board copy() {
		final int[][] squareValues = new int[length][length];
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				squareValues[row][col] = squares[row][col].getValue();
			}
		}
		final Board result = new Board(squareValues);
		result.updateFromAll();
		return result;
	}

	private void setSquareList() {
		squareList = new ArrayList<Square>(length * length);
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				squareList.add(squares[row][col]);
			}
		}
	}

	public Square getSquare(final int row, final int col) {
		return squares[row][col];
	}

	public Square getSquare(final Position pos) {
		return getSquare(pos.getRow(), pos.getCol());
	}

	public byte getValue(final int row, final int col) {
		return squares[row][col].getValue();
	}

	public int getLength() {
		return length;
	}

	public int getBoxSize() {
		return boxSize;
	}

	public boolean wasJustUpdated() {
		return justUpdated;
	}

	public void setJustUpdated(final boolean justUpdated) {
		this.justUpdated = justUpdated;
	}

	public SortedSet<Square> getUnsetSquares() {
		return new TreeSet<Square>(unsetSquares);
	}

	public Set<Square> getSetSquares() {
		return new TreeSet<Square>(setSquares);
	}

	void squareUpdated(final Square square) {
		setSquares.add(square);
		unsetSquares.remove(square);
		numUpdated++;
		System.out.println("numUpdated=" + numUpdated);
	}

	private Validator getValidator() {
		if (validator == null) {
			validator = new UncompletedBoardValidator(this);
		}
		return validator;
	}

	public boolean isValid() {
		return getValidator().isValid();
	}

	@Override
	public String toString() {
		final BoardFormatter formatter = new BoardFormatter(this);
		return formatter.format();
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof Board)) {
			return false;
		}
		final Board that = (Board) o;
		for (int i = 0; i < squareList.size(); i++) {
			final byte thisVal = this.squareList.get(i).getValue();
			final byte thatVal = that.squareList.get(i).getValue();
			if (thisVal != thatVal) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder builder = new HashCodeBuilder();
		for (final Square square : squareList) {
			builder.append(square.getValue());
		}
		return builder.build();
	}

	@Override
	public Iterator<Square> iterator() {
		return squareList.iterator();
	}

}
