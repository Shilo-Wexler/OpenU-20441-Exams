public class Exercise26 {

    /**
     * Problem Description:
     * Determines whether there exists a subset of elements within a given array
     * of positive integers that sums up exactly to a specified target number (num).
     * The subset must adhere to the following constraints:
     * 1. Each element from the array can be used at most once.
     * 2. The subset cannot contain three consecutive array elements
     *    (i.e., if elements at index i and i+1 are chosen, the element at i+2 cannot be chosen).

     * Signature: public static boolean isSum(int[] a, int num)

     * Constraints:
     * Must be implemented entirely using recursion. The use of loops is strictly forbidden.
     * Method overloading is permitted to pass additional state parameters.

     * Algorithm idea:
     * The algorithm utilizes a recursive backtracking approach to explore valid
     * subset combinations. An overloaded helper method tracks the current index 'i'
     * and a 'count' of consecutive elements taken so far.
     * - If the consecutive count reaches 2, the algorithm is forced to skip the
     *   current element, resetting the consecutive count to 0 for the next call.
     * - If the count is less than 2, the algorithm branches into two paths:
     *   including the current element (incrementing the count and reducing the target sum)
     *   or skipping it (resetting the count to 0).
     * Short-circuit evaluation (logical OR) is used between the branches to efficiently
     * halt the search and return true as soon as a valid subset is found. Base cases
     * handle exact matches (num == 0), overshoots (num < 0), and array boundaries.
     */

    public static boolean isSum (int[] a, int num) {
        return isSum(a, num, 0, 0);
    }

    private static boolean isSum (int[] a, int num, int i, int count) {
        if (num == 0) {
            return true;
        }
        if (i >= a.length || num < 0) {
            return false;
        }

        if (count >= 2) {
            return isSum(a, num, i + 1 , 0);
        }
        else {
            return isSum(a, num - a[i], i + 1, count + 1) || isSum(a, num, i + 1, 0);
        }
    }
}
