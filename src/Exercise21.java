public class Exercise21 {

    /**
     * Problem Description:
     * Finds the length of the longest "almost-palindrome" contiguous subarray
     * within a given 1D array of integers. An almost-palindrome is defined as a
     * palindromic sequence where at most one element can be omitted (skipped),
     * provided the omission does not occur at the extreme edges of the sequence.
     * Standard palindromes (with 0 omissions) are also considered valid.

     * Signature: public static int longestAlmostPalindrome(int[] arr)

     * Constraints:
     * Must be implemented purely recursively without any use of loops.
     * No global or static variables are permitted.
     * Method overloading is allowed.
     * Must prevent redundant recursive calls to optimize the run.

     * Algorithm idea:
     * The algorithm separates the logic into a scanning method and a validation method.
     * A recursive wrapper (allOptions) scans all possible subarrays by systematically
     * shrinking the boundaries from the left and right. For each set of boundaries,
     * it calls a dedicated boolean recursive helper (isPalindrome) to verify the sequence.
     * The validation method uses boolean flags to track if it is currently evaluating
     * the outermost edges and if the single allowed skip has already been utilized.
     * If a valid almost-palindrome is identified, its length is immediately returned,
     * which intelligently prunes the recursion tree and avoids redundant checks on
     * smaller inner subarrays.
     */

    public static int longestAlmostPalindrome (int[] arr) {
        return allOptions(arr, 0, arr.length-1);
    }

    private static int allOptions (int[] arr, int i, int j) {
        if (i >= arr.length || j < 0) {
            return 0;
        }

        if (isPalindrome(arr, i, j, true, true)) {
            return j - i + 1;
        }

        return Math.max(allOptions(arr, i + 1, j), allOptions(arr, i, j - 1));
    }

    private static boolean isPalindrome (int [] arr, int i, int j, boolean isFirst, boolean one) {
        if (i > j) {
            return true;
        }
        if ((isFirst && arr[i] != arr[j]) || (!one && arr[i] != arr[j])) {
            return false;
        }

        if (one && arr[i] != arr[j]) {
            boolean opt1 = isPalindrome(arr, i + 1, j, false, false);
            boolean opt2 = isPalindrome(arr, i, j - 1, false, false);
            return opt1 || opt2;
        }
        return isPalindrome(arr, i + 1, j - 1, false, one);
    }
}
