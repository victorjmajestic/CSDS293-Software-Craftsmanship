package matrix;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;

public abstract class AbstractMatrix<I, T> implements Matrix<I, T> {

	/* matrix represents the matrix itself.
	 * zero represents the value of zero for the matrix type.
	 */
    protected final NavigableMap<I, T> matrix;
    private final T zero;

    // Constructor which initializes matrix as a TreeMap and zero using method zero().
    protected AbstractMatrix(NavigableMap<I, T> matrix, T zero) {
    	Objects.requireNonNull(matrix, "Null matrix is not allowed.");
        Objects.requireNonNull(zero, "Null zero is not allowed.");
    	this.matrix = Collections.unmodifiableNavigableMap(new TreeMap<>(matrix));
        this.zero = zero;
    }

    // Returns the T value at index I of the vector.
 	public T value(I index) {
 		 Objects.requireNonNull(index, "Null index is not allowed.");
         return matrix.getOrDefault(index, zero());
     }

 	// Returns 0 type-casted to type T.
     @SuppressWarnings("unchecked")
 	public T zero() {
         return (T) Integer.valueOf(0);
     }
     
     // Returns a copy of the vector binary tree map.
     public NavigableMap<I, T> representation() {
         return new TreeMap<>(matrix);
     }
     
     // Generates all the indexes between the from starting point inclusive and the to ending point exclusive.
     public Stream<Indexes> streamIndexes(Indexes from, Indexes to) {
    	 Objects.requireNonNull(from, "Null from is not allowed.");
         Objects.requireNonNull(to, "Null to is not allowed.");
         return Indexes.stream(from, to);
     }

     // Generates the indexes from (0,0) to the size end point.
     public Stream<Indexes> streamIndexes(Indexes size) {
    	 Objects.requireNonNull(size, "Null size is not allowed.");
         return Indexes.stream(size);
     }

     // Generates the indexes from (0, 0) to the (rows, columns) end point.
     public Stream<Indexes> streamIndexes(int rows, int columns) {
    	 Objects.requireNonNull(rows, "Null rows are not allowed.");
    	 Objects.requireNonNull(columns, "Null columns are not allowed.");
    	 return Indexes.stream(rows, columns);
     }
}