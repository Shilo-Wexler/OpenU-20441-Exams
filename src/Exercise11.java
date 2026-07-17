public class Exercise11 {

    /**
     * Problem Description: Longest Alternating Merge of Two Sorted Arrays

     * Given two one-dimensional arrays 'a' and 'b', both containing integers
     * sorted in strictly increasing order, we want to build the longest possible
     * strictly increasing array by taking elements alternately from 'a' and 'b'
     * (not necessarily all elements, and not necessarily starting from index 0
     * of either array).

     * Task:
     * Write a static, RECURSIVE method 'alternateSorted' that receives the two
     * arrays as parameters, returns the length of the longest such alternating
     * array that can be built from 'a' and 'b', and also prints one such array
     * of maximal length (if more than one exists, any one of them may be printed).

     * Signature: public static int alternateSorted(int[] a, int[] b)

     * Constraints:
     * - The method must be written recursively, WITHOUT using any loops at all.
     *   Any helper methods written must also be loop-free.
     * - Efficiency is not required, but unnecessary/redundant recursive calls
     *   must be avoided.
     * - It may be assumed that both arrays are non-null and contain valid data.

     * Algorithm idea (greedy):
     * Since both arrays are strictly increasing, once it is our turn to take the
     * next element from a given array, the first element in that array which is
     * strictly greater than the previously chosen value is always the optimal
     * choice — taking it leaves the maximal possible "room" for future elements,
     * compared to taking any later, larger element from the same array.
     * Therefore, choosing the next element is fully deterministic once the
     * starting array is fixed. The only real branching in the problem is the
     * choice of which array to start from ('a' or 'b'), since it cannot be
     * determined in advance which starting point yields the longer sequence.
     * The method therefore computes the result for both possible starting points
     * and returns the maximum of the two, then prints the path corresponding to
     * the winning start.
     */

    public static int alternateSorted (int[] a, int[] b){
        int aStart = alternateSorted(a, b, Integer.MIN_VALUE, 0, 0, true);
        int bStart = alternateSorted(a, b, Integer.MIN_VALUE, 0, 0, false);

        if (aStart > bStart){
            printPath(a, b, Integer.MIN_VALUE, 0, 0, true, "{");
            return aStart;
        }
        printPath(a, b, Integer.MIN_VALUE, 0, 0, false, "{");
        return bStart;
    }

    private static int alternateSorted (int[] a, int[] b, int prevValue, int i, int j, boolean isA) {

        if (isA)
        {
            if (i >= a.length)
                return 0;
            if (a[i] > prevValue)
                return 1 + alternateSorted(a, b, a[i], i +1, j, false);
            return alternateSorted(a, b, prevValue, i + 1, j, true);
        }
        else
        {
            if (j >= b.length)
                return 0;
            if (b[j] > prevValue)
                return 1 + alternateSorted(a, b, b[j], i, j + 1, true);
            return alternateSorted(a, b, prevValue, i, j + 1, false);
        }
    }

    private static void printPath (int[] a, int[] b, int prevValue, int i, int j,  boolean isA, String sArr){

        if (isA)
        {
            if (i >= a.length){
                System.out.println(sArr + "}");
                return;
            }
            if (a[i] > prevValue){
                sArr += a[i] + ",";
                printPath(a, b, a[i], i +1, j, false, sArr);
            }
            else
                printPath(a, b, prevValue, i + 1, j, true, sArr);
        }
        else
        {
            if (j >= b.length){
                System.out.println(sArr + "}");
                return;
            }
            if (b[j] > prevValue){
                sArr += b[j] + ",";
                printPath(a, b, b[j], i, j + 1, true, sArr);
            }
            else
                printPath(a, b, prevValue, i, j + 1, false, sArr);
        }
    }
}
