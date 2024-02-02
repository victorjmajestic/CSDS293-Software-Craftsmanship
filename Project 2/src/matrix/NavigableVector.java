package matrix;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Collections;

public final class NavigableVector<T> extends AbstractMatrix<Integer, T> {

	// Constructor which inherits its superclass methods.
    public NavigableVector(NavigableMap<Integer, T> matrix, T zero) {
        super(matrix, zero);
    }

    // Returns a new copy of a vector with zeroes filtered out.
    public static <T> NavigableVector<T> from(Map<Integer, T> vector, T zero) {
    	Objects.requireNonNull(vector, "Null vector is not allowed.");
        Objects.requireNonNull(zero, "Null zero is not allowed.");
    	NavigableMap<Integer, T> vectorWithoutZero = new TreeMap<>();
        for (Map.Entry<Integer, T> entry : vector.entrySet()) {
            if (!entry.getValue().equals(zero)) {
                vectorWithoutZero.put(entry.getKey(), entry.getValue());
            }
        }
        return new NavigableVector<>(Collections.unmodifiableNavigableMap(vectorWithoutZero), zero);
    }
}