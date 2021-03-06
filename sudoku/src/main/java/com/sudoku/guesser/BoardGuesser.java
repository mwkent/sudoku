package com.sudoku.guesser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.SortedSet;

import com.sudoku.Board;
import com.sudoku.Square;
import com.sudoku.cache.BoardCache;

/**
 * @author Matt Kent
 */
public class BoardGuesser implements Guesser<Board> {

	private final BoardCache boardCache = new BoardCache();
	private final Deque<Guess> guesses = new ArrayDeque<>();
	private Board currentBoard;
	private int numGuesses = 0;
	private int numValid = 0;
	private int numInvalid = 0;

	@Override
	public void guess(final Board board) {
		currentBoard = board;
		boardCache.cache(currentBoard);
		makeGuess();
		numGuesses++;
		System.out.println("numGuesses=" + numGuesses);
	}

	@Override
	public Board backtrack() {
		currentBoard = boardCache.getCached();
		removeInvalidGuess();
		if (!currentBoard.isValid()) {
			System.out.println("backtracking board is invalid");
			System.out.println(currentBoard);
			numInvalid++;
		} else {
			numValid++;
		}
		System.out.println("number of valid backtracks=" + numValid);
		System.out.println("number of invalid backtracks=" + numInvalid);
		return currentBoard;
	}

	private void makeGuess() {
		final Square bestProspect = getBestProspect();
		final byte val = bestProspect.getPossibleValues().iterator().next();
		bestProspect.setValue(val);
		bestProspect.clearPossibleValues();
		final Guess guess = new Guess(bestProspect.getPosition(), val);
		guesses.push(guess);
		System.out.println("Guessed " + guess);
	}

	private Square getBestProspect() {
		final SortedSet<Square> unsetSquares = currentBoard.getUnsetSquares();
		Square bestProspect = unsetSquares.first();
		for (final Square square : unsetSquares) {
			if (square.getPossibleValues().size() < bestProspect
					.getPossibleValues().size()) {
				bestProspect = square;
			}
		}
		return bestProspect;
	}

	private void removeInvalidGuess() {
		final Guess mostRecentGuess = guesses.pop();
		System.out.println("mostRecentGuess=" + mostRecentGuess);
		final Square guessedSquare = currentBoard.getSquare(mostRecentGuess
				.getPosition());
		System.out.println("possible values="
				+ guessedSquare.getPossibleValues());
		guessedSquare.removePossibleValueAndUpdate(mostRecentGuess.getValue());
	}

}
