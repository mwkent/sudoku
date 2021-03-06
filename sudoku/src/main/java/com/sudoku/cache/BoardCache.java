package com.sudoku.cache;

import java.util.ArrayDeque;
import java.util.Deque;

import com.sudoku.Board;

/**
 * @author Matt Kent
 */
public class BoardCache implements Cache<Board> {

	private final Deque<Board> cachedBoards = new ArrayDeque<>();

	@Override
	public void cache(final Board board) {
		cachedBoards.push(board.copy());
	}

	@Override
	public Board getCached() {
		System.out.println("Get cached board");
		if (cachedBoards.size() == 0) {
			System.out.println();
		}
		return cachedBoards.pop();
	}

}
