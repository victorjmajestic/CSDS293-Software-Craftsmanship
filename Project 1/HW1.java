// Victor Majestic - Homework 1

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HW1 {
	
	/* A method returning the longest higher suffix of two lists.
	 * Per the assignment, "A suffix of a list is a list containing the last entry (or entries) of the
	 * list. A higher suffix is a suffix of list a whose elements are greater
	 * than or equal to the corresponding element in list b.
	 * 
	 *  Parameters: Two lists, a and b, of type T--and a Comparator of type T.
	 *  
	 *  Error 1: If the last element of a and b are not equal, it will skip to the element before.
	 *  Error 2: If the elements in b are larger than a, it is likely to skip that element.*/
	
	public static <T extends Comparable<? super T>> List<T> longestHigherSuffix(List<T> a, List<T> b, Comparator<T> cmp) {
        // minLength is the size of the shorter list between a and b.
		int minLength = Math.min(a.size(), b.size());

        /* suffix is the list containing the longest higher suffix between a and b.
         * The lower bound of suffix's size is 0, and the higher bound is the size of the shorter list between a and b.
         * Filters through each element, and includes the elements in suffix in which a is greater than or equal to b.
         * Maps the larger value to the corresponding list index in suffix.
         * Transforms to a list form that can be viewed in console. */
        List<T> suffix = IntStream.range(0, minLength)
                .filter(i -> cmp.compare(a.get(a.size() - minLength + i), b.get(b.size() - minLength + i)) >= 0)
                .mapToObj(i -> a.get(a.size() - minLength + i))
                .collect(Collectors.toList());

        return suffix;
    }

	// Test function
    public static void main(String[] args) {
        
    	// Example 1 - a: <0,2,4>; b: <1,2,3>; longestHigherSuffix: <2,4>
    	List<Integer> a1 = List.of(0, 2, 4);
        List<Integer> b1 = List.of(1, 2, 3);
        System.out.println("EXAMPLE 1");
        System.out.println("List a is: " + a1);
        System.out.println("List b is: " + b1);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a1, b1, Comparator.naturalOrder()));
        
        // Example 2 - a: <1,2>; b: <2,1>; longestHigherSuffix: <2>
        List<Integer> a2 = List.of(1, 2);
        List<Integer> b2 = List.of(2, 1);
        System.out.println("");
        System.out.println("EXAMPLE 2");
        System.out.println("List a is: " + a2);
        System.out.println("List b is: " + b2);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a2, b2, Comparator.naturalOrder()));
        
        // Example 3 - a: <2,4>; b: <1,3,2,4>; longestHigherSuffix: <2,4>
        List<Integer> a3 = List.of(2, 4);
        List<Integer> b3 = List.of(1, 3, 2, 4);
        System.out.println("");
        System.out.println("EXAMPLE 3");
        System.out.println("List a is: " + a3);
        System.out.println("List b is: " + b3);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a3, b3, Comparator.naturalOrder()));
        
        // Example 4 - a: <1,2,3,4>; b: <1,2,4>; longestHigherSuffix: <2,3,4>
        List<Integer> a4 = List.of(1, 2, 3, 4);
        List<Integer> b4 = List.of(1, 2, 4);
        System.out.println("");
        System.out.println("EXAMPLE 4");
        System.out.println("List a is: " + a4);
        System.out.println("List b is: " + b4);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a4, b4, Comparator.naturalOrder()));
        
        // Example 5 - a: <2,1>; b: <1,2,3>; longestHigherSuffix: <>
        List<Integer> a5 = List.of(2, 1);
        List<Integer> b5 = List.of(1, 2, 3);
        System.out.println("");
        System.out.println("EXAMPLE 5");
        System.out.println("List a is: " + a5);
        System.out.println("List b is: " + b5);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a5, b5, Comparator.naturalOrder()));

        // Example 6 - a: <1,3,2,4>; b: <1,2,3,4>; longestHigherSuffix: <4>
        List<Integer> a6 = List.of(1, 3, 2, 4);
        List<Integer> b6 = List.of(1, 2, 3, 4);
        System.out.println("");
        System.out.println("EXAMPLE 6");
        System.out.println("List a is: " + a6);
        System.out.println("List b is: " + b6);
        System.out.println("The longest higher suffix is: " + longestHigherSuffix(a6, b6, Comparator.naturalOrder())); // Output: [4]
    }
}