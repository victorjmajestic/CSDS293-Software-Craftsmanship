package matrix;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Tester {
	
	/*public static void main(String[] args) {
        // Creates a new TreeMap and stores it within vectorMap.
        Map<Integer, Integer> vectorMap = new TreeMap<>();

        // Adds values to multiple indexes.
        vectorMap.put(0, 0);
        vectorMap.put(1, 2);
        vectorMap.put(2, 1);
        vectorMap.put(3, 0);
        vectorMap.put(4, 3);
        vectorMap.put(5, 0);

        // Test "from"
        NavigableVector<Integer> navigableVector = NavigableVector.from(vectorMap, 0);

        // Test "value"
        System.out.println("Value at index 0: " + navigableVector.value(0));
        System.out.println("Value at index 1: " + navigableVector.value(1));
        System.out.println("Value at index 2: " + navigableVector.value(2));
        System.out.println("Value at index 3: " + navigableVector.value(3));
        System.out.println("Value at index 4: " + navigableVector.value(4));
        System.out.println("Value at index 5: " + navigableVector.value(5));

        // Test "zero"
        System.out.println("Value of zero: " + navigableVector.zero());

        // Test "representation"
        NavigableMap<Integer, Integer> representation = navigableVector.representation();
        System.out.println("Representation of the matrix: " + representation);

        // Test "streamIndexes"
        System.out.println("Indexes stream from (0,0) to (2,2): " +
                navigableVector.streamIndexes(Indexes.ORIGIN, new Indexes(2, 2)).toList());
        System.out.println("Indexes stream for matrix size (3,3): " +
                navigableVector.streamIndexes(new Indexes(3, 3)).toList());
        System.out.println("Indexes stream for matrix size (2,3): " +
                navigableVector.streamIndexes(2, 3).toList());
    }*/

}
