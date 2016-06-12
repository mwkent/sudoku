package com.sudoku.guesser;

import com.sudoku.Position;

/**
 * @author Matt Kent
 */
class Guess {

	static final Guess INVALID = new Guess(null, (byte) -1);

	private final Position position;
	private final byte value;

	Guess(final Position position, final byte value) {
		this.position = position;
		this.value = value;
	}

	public Position getPosition() {
		return position;
	}

	public byte getValue() {
		return value;
	}

	@Override
	public String toString() {
		return position + ", value=" + value;
	}

	public static void main(final String[] args) {
		new Guess(Position.getInstance(0, 0), (byte) 0);
	}

}
