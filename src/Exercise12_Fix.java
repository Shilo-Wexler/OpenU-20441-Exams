public class Exercise12_Fix {
    /**
     * Problem Description: Find the Minimum Triplet Product

     * Given an array 'arr' of integers (positive and negative, no zeros),
     * n >= 3, find the minimum possible product of any three elements.
     * The method prints the equation (factor1*factor2*factor3=result) and
     * returns the product.

     * Signature: public static int findTriplet(int[] arr)

     * Constraint: must be highly efficient in time and space.

     * Algorithm idea:
     * The minimal product is either the product of the 3 smallest elements
     * (three large-magnitude negatives), or the product of the 2 largest
     * elements with the smallest element (two large positives with one very
     * negative number). No other combination can beat the better of these two.

     * A single O(n) pass finds these 5 values (3 smallest, 2 largest),
     * updating them by position as the array is scanned - so duplicate values
     * are handled correctly. Only the two candidate products above are then
     * compared and the smaller one is printed/returned; each always
     * corresponds to 3 distinct real elements of the array.

     * Time Complexity: O(n) - single pass, plus constant-time comparison.
     * Space Complexity: O(1) - fixed number of variables only.
     */

    public static int findTriplet (int [] arr) {
        int [] candidates = findCandidate(arr);

        int option1 = candidates[0] * candidates[3] * candidates[4];
        int option2 = candidates[0] * candidates[1] * candidates[2];

        if (option1 < option2)
        {
            System.out.println(candidates[0] + "*" + candidates[3] + "*" + candidates[4] + "=" + option1);
            return option1;
        }
        System.out.println(candidates[0] + "*" + candidates[1] + "*" + candidates[2] + "=" + option2);
        return option2;
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
