package com.sudoku.guesser;


/**
 * @author Matt Kent
 */
public interface Guesser<E> {

	void guess(final E element);

	E backtrack();

}
