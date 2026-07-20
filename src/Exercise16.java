public class Exercise16 {

    /**
     * Problem Description: Find the Smallest and Biggest Difference Pairs

     * Given two arrays of integers 'a' and 'b', the class provides two methods:
     * 1. smallestDiffPair: Finds the pair (one from 'a', one from 'b') with the
     *    minimum absolute difference. Prints the pair and returns the difference.
     * 2. biggestDiffPair: Finds the pair with the maximum absolute difference.
     *    Prints the pair and returns the difference.

     * Signatures:
     * public static int smallestDiffPair(int[] a, int[] b)
     * public static int biggestDiffPair(int[] a, int[] b)

     * Constraint: Time and space complexity must be as efficient as possible.

     * Algorithm idea & Complexity:
     * - smallestDiffPair: Copies both arrays (to preserve original data) and sorts
     *   them using QuickSort. A two-pointer approach is then used to scan the arrays
     *   in a single pass, advancing the pointer of the smaller element to minimize
     *   the gap.
     *   Time Complexity: O(n log n) bounded by the sorting algorithm. The two-pointer
     *   scan takes O(n).
     *   Space Complexity: O(n) for creating copies of the input arrays.

     * - biggestDiffPair: The maximum difference is always formed by the maximum of one
     *   array and the minimum of the other. The method scans each array once
     *   independently to find their respective min/max values, then compares the two
     *   possible cross-differences.
     *   Time Complexity: O(n) for the independent linear scans of the arrays.
     *   Space Complexity: O(1) as it utilizes only primitive variables for tracking.
     */

    public static int smallestDiffPair(int[] a , int[] b) {
        int [] arrA = copyArr(a);
        int [] arrB = copyArr(b);

        QuickSort.quickSort(arrA);
        QuickSort.quickSort(arrB);

        int numA = Integer.MAX_VALUE;
        int numB = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (i < arrA.length && j < arrB.length) {
            int currDiff = Math.abs(arrA[i] - arrB[j]);

            if (currDiff < minDiff) {
                minDiff = currDiff;
                numA = arrA[i];
                numB = arrB[j];
            }
            if (arrA[i] < arrB[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        System.out.println(numA + "---" + numB);
        return minDiff;
    }


    public static int biggestDiffPair(int[] a , int[] b) {

        int [] resA = findMinMax(a);
        int maxA = resA[1];
        int minA = resA[0];

        int [] resB = findMinMax(b);
        int maxB = resB[1];
        int minB = resB[0];

        int option1 = Math.abs(maxA - minB);
        int option2 = Math.abs(maxB - minA);

        if (option1 > option2) {
            System.out.println(maxA + "---" + minB);
            return option1;
        }
        System.out.println(maxB + "---" + minA);
        return option2;
    }


    private static int [] findMinMax (int [] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int [] {min, max};
    }

    private static int [] copyArr (int [] arr) {
        int [] newArr = new int [arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
