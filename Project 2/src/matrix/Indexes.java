package matrix;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Indexes(int row, int column) implements Comparable<Indexes> {
    
	// ORIGIN corresponds to Indexes(0,0)
	public static final Indexes ORIGIN = new Indexes(0, 0);

	// Return a new Indexes whose row  value is equal to the argument and column value is equal to those of this Indexes
    public Indexes withRow(int row) {
        return new Indexes(row, this.column);
    }

    // Return a new Indexes whose column value is equal to the argument and row value is equal to those of this Indexes
    public Indexes withColumn(int column) {
        return new Indexes(this.row, column);
    }

    // Compares Indexes by row and breaks any tie by column.
    public static final Comparator<Indexes> byRows = Comparator.comparingInt(Indexes::row)
            .thenComparingInt(Indexes::column);

    // Compares Indexes by column and breaks any tie by row.
    public static final Comparator<Indexes> byColumns = Comparator.comparingInt(Indexes::column)
            .thenComparingInt(Indexes::row);

    @Override
    // Implements Comparable that works byRows.
    public int compareTo(Indexes other) {
        return byRows.compare(this, other);
    }

    // Returns the matrix entry corresponding to this Indexes.
    public <T> T value(T[][] matrix) {
    	Objects.requireNonNull(matrix, "Null matrices are not allowed.");
    	return matrix[row][column];
    }

    // Returns true if this Indexes are along the matrix diagonal.
    public boolean areDiagonal() {
        return row == column;
    }

    // Generates all indexes between and including "from" and and excluding "to"
    public static Stream<Indexes> stream(Indexes from, Indexes to) {
        return IntStream.rangeClosed(from.row(), to.row() - 1)
                .boxed()
                .flatMap(row ->
                        IntStream.rangeClosed(from.column(), to.column() - 1)
                                .mapToObj(column -> new Indexes(row, column))
                );
    }

    // Generates the indexes from (0,0) to the size end point.
    public static Stream<Indexes> stream(Indexes size) {
        return stream(ORIGIN, size);
    }

    // Generates the indexes from (0, 0) to the (rows, columns) end point.
    public static Stream<Indexes> stream(int rows, int columns) {
        return stream(new Indexes(rows, columns));
    }
}
