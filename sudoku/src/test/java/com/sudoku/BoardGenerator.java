package com.sudoku;

import java.util.Random;

/**
 * Doesn't necessarily generate a valid board or one that can be solved.
 * 
 * @author Matt Kent
 */
public class BoardGenerator {

	private final int size;

	BoardGenerator(final int size) {
		this.size = size;
	}

	public Board generate() {
		final Board board = createEmptyBoard();
		final Random gen = new Random();
		for (final Square square : board) {
			if (gen.nextInt(2) == 0) {
				square.setRandomValue();
			}
		}
		return board;
	}

	private Board createEmptyBoard() {
		return new Board(new int[size][size]);
	}

	public static void main(final String[] args) {
		final BoardGenerator gen = new BoardGenerator(16);
		final Board board = gen.generate();
		System.out.println(board.isValid());
		System.out.println(board);
	}
}
