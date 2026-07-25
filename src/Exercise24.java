public class Exercise24 {

    /**
     * Problem Description:
     * Finds a number that appears more than once in a given array.
     * The array is of size n, containing integers in the range 1 to n-1.
     * The array is not sorted, and the algorithm is allowed to modify the
     * original array in-place.

     * Signature: public static int findDuplicate(int[] a)

     * Constraints:
     * Must be implemented with optimal efficiency regarding time and space.
     * Expected Time Complexity: O(n)
     * Expected Space Complexity: O(1)

     * Algorithm idea:
     * The algorithm utilizes an in-place cyclic sort approach. It iterates
     * through the array and attempts to place each number at its natural
     * corresponding index (i.e., placing the value x at index x-1).
     * During this swapping process, if a number is about to be placed at
     * a target index that already contains the same value, it indicates
     * that a duplicate has been found. This approach allows finding the
     * duplicate in linear time without requiring additional memory space.
     */

    public static int findDuplicate (int []a) {
        for (int i = 0; i < a.length; i++) {
            while (a[i]-1 != i) {
                int temp = a[a[i] - 1];
                if (temp == a[i]) {
                    return a[i];
                }
                a[a[i] - 1] = a[i];
                a[i] = temp;
            }
        }
        return -1;
    }
}
