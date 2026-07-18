public class Exercise13 {

    /**
     * Problem: Maximal Proper Factor

     * Every natural num can be written as a sum of distinct powers of some factor a (a >= 2):
     *      num = a^i1 + a^i2 + ... + a^ik   (i1 < i2 < ... < ik, powers not necessarily consecutive)

     * Such 'a' is called a proper factor of num. The trivial factor a = num-1 always works
     * (num = (num-1)^0 + (num-1)^1) and is NOT counted - a is checked only in range 2..num-2.

     * Task: return the LARGEST proper factor a of num, or 0 if none exists.
     * For each factor tested, print the powers used to compose num.

     * Signature: public static int maxFactor(int num)

     * Constraints:
     * - Recursion only, no loops.
     * - Allowed: Math.sqrt/min/max, Integer.MIN_VALUE/MAX_VALUE, overloading.

     * Examples:
     *  maxFactor(9)   -> 3   (3^2 = 9)
     *  maxFactor(42)  -> 6   (6^1 + 6^2 = 42)
     *  maxFactor(273) -> 16  (16^0 + 16^1 + 16^2 = 273)
     *  maxFactor(3)   -> 0   (no valid factor in range)
     */

    public static int maxFactor (int num) {
        return maxFactor(num, num -2);
    }

    private static int maxFactor (int num, int f) {
        if (f < 2)
            return 0;

        if (isPropFactor(num, f, 1, 0, ""))
            return f;

        return maxFactor(num, f-1);
    }
    private static boolean isPropFactor (int num, int f, int currFactor, int result, String path) {
        if (result == num) {
            System.out.println(path);
            return true;
        }

        if (result > num || currFactor > num)
            return false;

        return (
            isPropFactor(num, f, currFactor * f, result, path) ||
            isPropFactor(num, f, currFactor * f, result + currFactor, path + currFactor + "\t")
        );
    }
}
