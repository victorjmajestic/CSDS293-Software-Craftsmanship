package matrix;

import java.util.NavigableMap;
import java.util.stream.Stream;

public interface Matrix<I, T> {
	
	/* The matrix interface.
	 * Defines the methods value(I index), T zero(), and NavigableMap<I,T> representation:
	 * T value(I index) returns the T value at index I of the matrix.
	 * T zero() returns 0 type-casted to T.
	 * NavigableMap<I,T> returns a copy of the matrix in binary tree form.
	 */
    T value(I index);
    T zero();
    NavigableMap<I, T> representation();
    Stream<Indexes> streamIndexes(Indexes size);
    Stream<Indexes> streamIndexes(int rows, int columns);
	Stream<Indexes> streamIndexes(Indexes from, Indexes to);
    
}