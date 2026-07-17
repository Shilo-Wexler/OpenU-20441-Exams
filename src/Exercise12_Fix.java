public class Exercise12_Fix {

    /**
     * Problem Description: Find the Minimum Triplet Product
     * * Given an array 'arr' of integers (positive and negative, without zeros) of length n >= 3.
     * * Task:
     * Write a static method 'findTriplet' that receives the array 'arr'
     * and returns the minimum possible product of any three elements in the array.
     * The method should also print the equation (factor1 * factor2 * factor3 = result).
     * Signature: public static int findTriplet(int[] arr)
     * * Constraints:
     * - The method must be highly efficient in both time and space complexity.

     * * Solution Explanation:
     * - The minimum product of three numbers can only be formed by multiplying elements from the
     *   extreme ends of the array (e.g., three small negative numbers, or two large positive numbers
     *   and one small negative number).
     * - Instead of sorting the array in O(n log n) time, the algorithm uses a single pass O(n) to find:
     *   1. The three smallest elements in the array.
     *   2. The two greatest elements in the array.
     * - It extracts these 5 candidates while safely handling array duplicates.
     * - Finally, it iterates through all possible triplet combinations among these 5 candidates
     *   to find and return the absolute minimum product.
     * - Time Complexity: O(n) - A single pass over the array.
     * - Space Complexity: O(1) - Only a few variables and a size-5 array are allocated.
     */

    public static int findTriplet (int [] arr) {
        int [] candidates = findCandidate(arr);

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

    private static int [] findCandidate (int [] arr) {
        int smallest1 = Integer.MAX_VALUE;
        int smallest2 = Integer.MAX_VALUE;
        int smallest3 = Integer.MAX_VALUE;

        int greatest1 = Integer.MIN_VALUE;
        int greatest2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num <= smallest1) {
                smallest3 = smallest2;
                smallest2 = smallest1;
                smallest1 = num;
            } else if (num <= smallest2) {
                smallest3 = smallest2;
                smallest2 = num;
            } else if (num <= smallest3) {
                smallest3 = num;
            }

            if (num >= greatest1) {
                greatest2 = greatest1;
                greatest1 = num;
            } else if (num >= greatest2) {
                greatest2 = num;
            }

        }
        return new int[]{
                smallest1, smallest2, smallest3,
                greatest1, greatest2
        };
    }
}
