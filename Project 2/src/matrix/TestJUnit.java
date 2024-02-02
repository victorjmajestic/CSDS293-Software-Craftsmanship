package matrix;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestMatrix extends AbstractMatrix<Integer, Integer> {
    public TestMatrix(NavigableMap<Integer, Integer> matrix, Integer zero) {
        super(matrix, zero);
    }
}

public class TestJUnit {

    @Test
    void testValue() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the value method
        Integer result = matrix.value(1);
        assertNotNull(result);
        assertEquals(0, result);
    }

    @Test
    void testZero() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the zero method
        Integer result = matrix.zero();
        assertNotNull(result);
        assertEquals(0, result);
    }

    @Test
    void testRepresentation() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the representation method
        NavigableMap<Integer, Integer> result = matrix.representation();
        assertNotNull(result);
        assertEquals(0, result.size());
    }
    
    @Test
    void testStreamIndexesWithSize() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the streamIndexes method with size
        Indexes size = new Indexes(3, 3);
        Stream<Indexes> result = matrix.streamIndexes(size);
        assertNotNull(result);
        assertEquals(size.row() * size.column(), result.count());
    }

    @Test
    void testStreamIndexesWithRowsAndColumns() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the streamIndexes method with rows and columns
        int rows = 2;
        int columns = 4;
        Stream<Indexes> result = matrix.streamIndexes(rows, columns);
        assertNotNull(result);
        assertEquals(rows * columns, result.count());
    }
    
    @Test
    void testStreamIndexesWithFromAndTo() {
        // Create a sample matrix
        Matrix<Integer, Integer> matrix = new TestMatrix(new TreeMap<>(), 0);

        // Test the streamIndexes method with from and to
        Indexes from = new Indexes(1, 2);
        Indexes to = new Indexes(3, 4);
        Stream<Indexes> result = matrix.streamIndexes(from, to);

        // Calculate the expected number of elements
        long expectedCount = (to.row() - from.row()) * (to.column() - from.column());

        assertNotNull(result);
        assertEquals(expectedCount, result.count());
    }
    
    @Test
    void testFrom() {
        // Create a sample vector
        Map<Integer, Integer> vector = new TreeMap<>();
        vector.put(1, 2);
        vector.put(2, 0);
        vector.put(3, 4);

        // Test the from method
        NavigableVector<Integer> result = NavigableVector.from(vector, 0);
        assertNotNull(result);
        assertEquals(2, result.representation().size());
    }
    
    @Test
    void testByRows() {
        // Test the byRows comparator
        assertTrue(Indexes.byRows.compare(new Indexes(1, 2), new Indexes(1, 1)) > 0);
    }

    @Test
    void testByColumns() {
        // Test the byColumns comparator
        assertTrue(Indexes.byColumns.compare(new Indexes(1, 2), new Indexes(2, 2)) < 0);
    }

    @Test
    void testMatrixValue() {
        // Test the value method
        Integer[][] matrix = {{1, 2}, {3, 4}};
        assertEquals(1, Indexes.ORIGIN.value(matrix));
    }

    @Test
    void testAreDiagonal() {
        // Test the areDiagonal method
        assertTrue(Indexes.ORIGIN.areDiagonal());
    }
}