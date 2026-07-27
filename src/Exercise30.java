public class Exercise30 {

    /**
     * This class provides a recursive solution to calculate the number of ways
     * to populate an array of size n with positive integers from 1 to max.
     * The generated arrays must be sorted in a non-decreasing order (elements
     * can be equal or ascending).

     * The algorithm utilizes a purely recursive approach to explore all valid
     * combinations, deciding at each step whether to place the current maximum
     * value or to restrict further placements to smaller values, without the
     * use of any iterative loops.
     */

    public static int howManySorted(int n, int max) {
        return howManySorted(n, max, 0);
    }

    private static int howManySorted(int n, int max, int i) {
        if (i == n) {
            return 1;
        }
        if (max == 0) {
            return 0;
        }
        int opt1 = howManySorted(n, max-1, i);
        int opt2 = howManySorted(n, max, i+1);
        return opt1 + opt2;
    }
}
