public class Exercise12 {

    /**
     * Problem Description: Minimal Product Triplet

     * Given an array 'arr' of integers (both positive and negative, no zeros),
     * find a triplet of numbers in the array (not necessarily adjacent) whose
     * product is minimal (i.e., as negative/as small as possible).
     * The method prints the three chosen numbers and returns their product.

     * Signature: public static int findTriplet(int[] arr)

     * Constraints:
     * - The array contains at least 3 elements.
     * - The method must be as efficient as possible in both time and space
     *   complexity. A solution with worse complexity than required will
     *   receive very few points.

     * Assumption:
     * This solution assumes all values in the array are distinct. Under this
     * assumption, the three smallest values and the two largest values in the
     * array can each be identified as the next value strictly greater/smaller
     * than the previously found one, without ambiguity.

     * Algorithm idea:
     * The minimal product triplet must be composed of elements taken from one
     * of two candidate groups: either the three smallest elements in the array,
     * or the two largest elements combined with the smallest element. All other
     * combinations of elements cannot yield a smaller product than the best of
     * these two candidates.
     * The method therefore identifies these five relevant candidate values
     * (three smallest, two largest) by repeatedly scanning the array for the
     * next strictly greater / strictly smaller value, then checks every valid
     * triplet combination among these five candidates and selects the one
     * yielding the minimal product, printing its three elements and returning
     * the product.

     * Time complexity: O(n) — the array is scanned a constant number of times
     * (5 linear scans to find the 5 candidates), and checking all combinations
     * among the 5 candidates takes constant time (independent of n).
     * Space complexity: O(1) — only a fixed number of variables and a
     * constant-size (5-element) candidates array are used, regardless of n.
     */

    public static int findTriplet (int [] arr){

        int smallest1 = findNext(arr, Integer.MIN_VALUE);
        int smallest2 = findNext(arr, smallest1);
        int smallest3 = findNext(arr, smallest2);

        int greatest1 = findPrev(arr, Integer.MAX_VALUE);
        int greatest2 = findPrev(arr, greatest1);

        int [] candidates = {
                smallest1, smallest2, smallest3,
                greatest1, greatest2
        };
        int factor1 = 0;
        int factor2 = 0;
        int factor3 = 0;

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++)
            for (int j = i+1; j < 5; j++)
                for (int k = j+1; k < 5; k++){
                    if (candidates[i] * candidates[j] * candidates[k] < res)
                    {
                        factor1 = candidates[i];
                        factor2 = candidates[j];
                        factor3 = candidates[k];
                        res = factor1 * factor2 * factor3;
                    }
                }

        System.out.println(factor1 + "*" + factor2 + "*" + factor3 + "=" + res);

        return res;
    }

    private static int findNext (int [] arr, int n){
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if (res == 0 && arr[i] > n)
                res = arr[i];
            else if (arr[i] > n && arr[i] < res)
                res = arr[i];

        }
        return res;
    }

    private static int findPrev (int [] arr, int n)
    {
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if (res == 0 && arr[i] < n)
                res = arr[i];
            else if (arr[i] < n && arr[i] > res)
                res = arr[i];
        }
        return res;
    }
}