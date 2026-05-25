public class Exercise_2 {
    /**
     * Write a completely recursive boolean method:
     * {@code public static boolean match(int[] a, int[] pattern)}
     *
     * The method receives an array of integers 'a' and an array of integers 'pattern'.
     * The 'pattern' array consists only of the numbers 0, 1, or 2, which represent
     * the required number of digits for the corresponding elements in a sub-array of 'a':
     * - 1 represents a single-digit integer.
     * - 2 represents a two-digit integer.
     * - 0 represents either a single-digit or a two-digit integer.
     *
     * The method must return true if there is a continuous sub-array within 'a' that
     * exactly matches the sequence defined by the 'pattern', and false otherwise.
     *
     * Constraints:
     * - The solution must be entirely recursive.
     * - The use of any loops is strictly forbidden.
     * - Method overloading and recursive helper methods are allowed.
     */

    public static boolean mach (int[] a, int[] pattern){
        if (pattern.length == 0)
            return true;

        return mach(a, pattern, 0, 0);
    }

    private static boolean mach (int[] a, int[] pattern, int i, int j){
        if (j == pattern.length)
            return true;
        if (i == a.length)
            return false;

        if (getNumLen(a[i]) == pattern[j] || pattern[j] == 0 && (getNumLen(a[i]) == 1 || getNumLen(a[i]) == 2)){
            i++;
            j++;
        }
        else {
            i = i - j + 1;
            j = 0;
        }
        return mach(a, pattern, i, j);
    }

    private static int getNumLen (int n){
        if (n / 10 == 0)
            return 1;
        return 1 + getNumLen(n / 10);
    }
}
