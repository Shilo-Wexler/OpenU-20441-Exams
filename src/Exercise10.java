public class Exercise10 {

    /**
     * Problem Description: Search in a K-Almost-Sorted Array
     * * An array is 'K-Almost-Sorted' if it contains only non-negative integers,
     * the positive integers are strictly monotonically increasing (ignoring zeroes),
     * and the maximum length of consecutive zeroes is bounded by a constant K.
     * * Task:
     * Write a static, NON-recursive method 'kAlmostSearch' that finds a strictly positive
     * integer 'num' in the array and returns its index. If 'num' is not found, or if
     * the array contains only zeroes, return -1.
     * Signature: public static int kAlmostSearch(int[] a, int num)
     * * Constraints:
     * - The method MUST be highly efficient in both time and space complexities.
     * - Expected complexities: O(log n) time and O(1) space.
     * - A solution that is not efficient (e.g., O(n) time) will receive limited points.
     * - The constant K is independent of the array size n, and its exact value is unknown.
     * - Must be written iteratively (non-recursive).
     */

    public static int kAlmostSearch (int [] a, int num){
        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int temp;

            if (a[mid] == num)
                return mid;

            if (a[mid] == 0) {
                temp = notZero(a, mid + 1, high);
                if (temp == -1)
                    high = mid -1;
                else if (a[temp] == num)
                    return temp;
                else if (a[temp] > num)
                    high = mid -1;
                else
                    low = temp + 1;
            }

            else if (a[mid] > num)
                high = mid -1;

            else
                low = mid + 1;
        }

        return -1;
    }
    private static int notZero(int [] a, int low, int high){
        while (low <= high)
        {
            if (a[low] != 0)
                return low;
            low ++;
        }
        return -1;
    }
}
