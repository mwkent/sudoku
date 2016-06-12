package com.sudoku.cache;

/**
 * @author Matt Kent
 */
public interface Cache<E> {

	void cache(E element);

	E getCached();

}
