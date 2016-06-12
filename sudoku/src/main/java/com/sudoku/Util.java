package com.sudoku;

import java.util.HashSet;

/**
 * @author Matt Kent
 */
public class Util {

	@SafeVarargs
	static <T> HashSet<T> asHashSet(final T... vals) {
		final HashSet<T> result = new HashSet<T>(vals.length);
		for (final T val : vals) {
			result.add(val);
		}
		return result;
	}

}
