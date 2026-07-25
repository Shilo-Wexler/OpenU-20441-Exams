public class Exercise22 {

    /**
     * Problem Description:
     * Finds a number that is strictly bounded by the maximum and minimum values
     * of a given array but is not present in the array itself.
     * The input array is provided sorted in descending order.
     * If no such missing number exists within the boundaries, the method
     * returns Integer.MIN_VALUE.

     * Signature: public static int findNumber(int[] arr)

     * Constraints:
     * Must be implemented with optimal efficiency regarding time and space.
     * Expected Time Complexity: O(log n)
     * Expected Space Complexity: O(1)

     * Algorithm idea:
     * The algorithm utilizes a modified binary search approach to achieve
     * logarithmic time complexity. It maintains two pointers (left and right)
     * and calculates the mid-point. By comparing the difference between the
     * array values at these indices against the difference of the indices
     * themselves, it identifies which half of the array contains a gap
     * (missing elements). Once the search space is narrowed down to two
     * adjacent indices with a value gap larger than 1, a valid missing
     * number is derived and returned.
     */

    public static int findNumber (int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            if (right - left == 1) {
                if (arr[left] - arr[right] > 1)
                {
                    return arr[left] - 1;
                }
                return Integer.MIN_VALUE;
            }

            int mid = (left + right) / 2;

            if (arr[left] - arr[mid] > mid - left) {
                right = mid;
            }
            else if (arr[mid] - arr[right] > right - mid) {
                left = mid;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }
}
