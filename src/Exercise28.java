public class Exercise28 {

    /**
     * Problem Description:
     * Calculates the length of the longest continuous palindromic sequence within a given one-dimensional array of integers.
     * The solution operates strictly using recursion, completely avoiding the use of iterative loops.

     * Signatures:
     * public static int longestPalindrome(int[] arr)
     * private static int longestPalindrome(int[] arr, int i, int j)
     * private static boolean isPalindrome(int[] arr, int i, int j)

     * Constraints:
     * Strictly recursive approach (no loops allowed).
     * Time Complexity: O(n * 2^n) - At each step, the algorithm potentially makes an O(n) check (isPalindrome) and branches into two recursive calls, leading to exponential time complexity without dynamic programming/memoization.
     * Space Complexity: O(n) - The space complexity is dictated by the maximum depth of the recursion call stack, which can reach at most 'n' frames.

     * Algorithm idea:
     * The algorithm utilizes method overloading and a divide-and-conquer approach.
     * The main method delegates the task to a recursive helper method that tracks the current subarray bounds (i and j).
     * - Base case: If index 'i' exceeds 'j', the pointers have crossed, representing an empty range, and it returns 0.
     * - Palindrome identification: It uses a secondary recursive boolean helper method (isPalindrome) to verify if the exact subarray from 'i' to 'j' forms a perfect palindrome.
     *   If true, it efficiently calculates and returns the length using the mathematical formula (j - i + 1), halting further exploration in this branch.
     * - Recursive exploration: If the current subarray is not a palindrome, the method branches into two parallel recursive paths to shrink the window:
     *   Option A: Exclude the leftmost element (i + 1, j).
     *   Option B: Exclude the rightmost element (i, j - 1).
     * - Math.max is continuously used at each step of the unwinding process to bubble up the maximum palindromic length discovered in either branch.
     * - The boolean helper method (isPalindrome) acts as a dedicated scanner, validating the edges recursively. It returns true if the inner pointers cross (success), or false immediately upon finding a value mismatch (failure).
     */

    public static int longestPalindrome (int[] arr) {
        return longestPalindrome(arr, 0, arr.length-1);
    }

    private static int longestPalindrome (int [] arr, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (isPalindrome(arr, i, j)) {
            return j - i + 1;
        }
        return Math.max(longestPalindrome(arr, i + 1, j), longestPalindrome(arr, i, j - 1));
    }
    private static boolean isPalindrome (int [] arr, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (arr[i] != arr[j]) {
            return false;
        }
        return isPalindrome(arr, i + 1, j - 1);
    }
}
