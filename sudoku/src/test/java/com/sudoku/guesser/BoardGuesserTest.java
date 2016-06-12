package com.sudoku.guesser;

import org.junit.Assert;
import org.junit.Test;

import com.sudoku.Board;
import com.sudoku.Boards;

/**
 * @author Matt Kent
 */
public class BoardGuesserTest {

	@Test
	public void testBacktrackRetrievesCachedBoard() {
		final Board board = Boards.getBoard(Boards.getMediumBoard());
		final Board originalBoard = board.copy();
		final BoardGuesser guesser = new BoardGuesser();
		guesser.guess(board);
		final Board cachedBoard = guesser.backtrack();
		Assert.assertEquals(originalBoard, cachedBoard);
	}

}
