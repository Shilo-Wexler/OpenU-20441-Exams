public class Exercise29 {

    /**
     * Problem Description:
     * Finds the missing integer within a one-dimensional array representing an arithmetic sequence.
     * The array is guaranteed to contain a sequence of numbers with a constant mathematical difference, with exactly one element missing.
     * The solution operates using an iterative binary search approach to achieve optimal performance.

     * Signatures:
     * public static int missingValue(int[] arr)

     * Constraints:
     * Iterative approach (utilizing a while loop).
     * Time Complexity: O(log n) - The algorithm utilizes a binary search mechanism, dividing the search space in half during each iteration. This completely avoids linear O(n) scans and ensures maximum time efficiency.
     * Space Complexity: O(1) - The space complexity is strictly constant. It only utilizes a few primitive variables (left, right, mid, diff) for pointer tracking and mathematical operations, requiring no auxiliary data structures or recursive call stacks.

     * Algorithm idea:
     * The algorithm leverages the mathematical properties of an arithmetic sequence combined with a divide-and-conquer search strategy.
     * - Difference calculation: First, it calculates the constant difference ('diff') of the sequence. It subtracts the first element from the last element and divides by the array's length. This works seamlessly because the length of the given array exactly matches the total number of 'steps' in the complete sequence.
     * - Binary Search initialization: It establishes two pointers, 'left' at index 0 and 'right' at the last index, defining the initial search boundaries.
     * - Value expectation check: At each iteration, the 'mid' index is calculated. Instead of relying on local comparisons of adjacent elements, the algorithm verifies if the actual value at 'arr[mid]' exactly matches the mathematically expected value for that position, calculated via the formula: (arr[0] + mid * diff).
     * - Search space reduction:
     *   Option A: If the actual value equals the expected value, the sequence is perfectly intact up to the 'mid' point. Therefore, the missing value must reside in the right half. The search window is adjusted by moving the 'left' pointer to (mid + 1).
     *   Option B: If the actual value does not match, the sequence disruption occurred at or prior to the 'mid' point, meaning the missing value is in the left half. The search window is adjusted by moving the 'right' pointer to (mid - 1).
     * - Final resolution: Once the 'left' pointer exceeds the 'right' pointer, the loop terminates. The 'left' pointer now definitively indicates the exact number of steps from the beginning where the missing value should have been. The exact missing integer is then calculated and returned using the base formula: (arr[0] + left * diff).
     */

    public static int missingValue (int [] arr) {
        int diff = (arr[arr.length-1] - arr[0]) / arr.length;

        int right = arr.length-1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == arr[0] + mid * diff) {
                left = mid + 1;
            }
            else if (arr[mid] != arr[0] + mid * diff) {
                right = mid - 1;
            }
        }
        return arr[0] + left * diff;
    }
}
