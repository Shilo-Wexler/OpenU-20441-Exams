public class Exercise18 {

    /**
     * Problem Description: Find the First Missing Positive

     * Given an unsorted 1D array of integers, find the smallest positive integer
     * that does not exist in the array. The method modifies the array in place
     * to achieve this and does not need to restore the array to its original state.

     * Signature: public static int findFirstMissing(int[] arr)

     * Constraint: Time complexity must be O(n) and Space complexity must be O(1).

     * Algorithm idea:
     * The algorithm treats the input array itself as a constant-space hash table.
     * A helper method iterates through the array, attempting to place every valid
     * positive integer 'x' (where 0 < x <= arr.length) at its "natural" index,
     * which is 'x - 1'. It uses a while loop to continuously swap elements that
     * land in the current index until the element is either out of bounds, invalid,
     * or already sitting in its correct target index (to prevent infinite loops).
     * After the array is rearranged, a second quick pass identifies the first
     * index 'i' where the value is not 'i + 1'. The missing number is 'i + 1'.
     * If all numbers from 1 to arr.length are in their correct places, it returns
     * arr.length + 1.
     */

    public static int findFirstMissing (int [] arr) {
        placeNumInIndex(arr);
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
            i++;
        }
        return i+1;
    }

    private static void placeNumInIndex (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i]-1]) {
                int num = arr[i];
                arr[i] = arr[num-1];
                arr[num-1] = num;
            }
        }
    }
}
