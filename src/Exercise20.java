public class Exercise20 {

    /**
     * Problem Description:
     * Fill an array with digits from 1 to 9 such that their sum equals exactly 's'.
     * The digits must be placed to form the smallest possible number when read
     * from left to right. If no such valid combination exists, the array must
     * remain unchanged (filled with 0s).

     * Signature: public static void minNumWithSum(int[] arr, int s)

     * Constraints:
     * Must be highly efficient.
     * Time Complexity: O(n) where n is the length of the array (single pass).
     * Space Complexity: O(1) auxiliary space (in-place modification).

     * Algorithm idea:
     * The algorithm first checks for impossible edge cases (sum is too small or too large).
     * It then iterates through the array backwards, from right to left.
     * To guarantee the smallest overall number, it greedily places the largest possible
     * valid digit at the current rightmost position. The placed value is the minimum
     * between 9 and the remaining sum minus the number of empty cells left to fill (i).
     * This ensures that the smallest digits are pushed to the left side of the array.
     */

    public static void minNumWithSum(int[] arr, int s) {
        if (s > arr.length * 9) {
            return;
        }
        if (s < arr.length) {
            return;
        }
        for (int i = arr.length-1; i >= 0; i--) {
            int val = Math.min(9, s - i);
            arr[i] = val;
            s -= val;
        }
    }
}
