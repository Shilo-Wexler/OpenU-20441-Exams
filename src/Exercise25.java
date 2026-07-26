public class Exercise25 {

    /**
     * Problem Description:
     * Handles a "crossed array", which is an array where the elements at even
     * indices are sorted in ascending order, and elements at odd indices are
     * sorted in descending order. Provides methods to sort the entire array
     * in ascending order in-place, and to search for a specific element efficiently.

     * Signatures:
     * public static void crossSort(int[] arr)
     * public static int crossSearch(int[] arr, int x)

     * Constraints:
     * Must be implemented with optimal efficiency regarding time and space.
     * crossSort Expected Time Complexity: O(n)
     * crossSort Expected Space Complexity: O(n)
     * crossSearch Expected Time Complexity: O(log n)
     * crossSearch Expected Space Complexity: O(1)

     * Algorithm idea:
     * crossSort: Utilizes an auxiliary array of size n to merge the two interleaved
     * sorted sub-sequences. Two pointers are used: one moving forward on the
     * even indices (ascending), and one moving backward on the odd indices
     * (descending). The smaller element between the two pointers is repeatedly
     * placed into the temporary array. Finally, the sorted elements are copied
     * back to the original array.

     * crossSearch: Performs two separate logical binary searches without allocating
     * additional memory. It maps a standard logical index to the corresponding
     * physical odd or even index. It first searches the odd indices (accounting
     * for their descending order). If the element is not found, it proceeds to
     * search the even indices (accounting for their ascending order).
     */

    public static void crossSort (int [] arr) {
        int k = 0;
        int i = 0;
        int j = arr.length-1;
        if ((arr.length-1) % 2 == 0) {
            j = arr.length-2;
        }

        int [] tempArr = new int[arr.length];

        while (i < arr.length && j > 0) {
            if (arr[i] < arr[j]) {
                tempArr[k] = arr[i];
                k++;
                i += 2;
            }
            else if (arr[j] < arr[i]) {
                tempArr[k] = arr[j];
                k++;
                j -= 2;
            }
            else {
                tempArr[k] = arr[j];
                k++;
                j -= 2;
                tempArr[k] = arr[i];
                k++;
                i += 2;
            }
        }
        while (j > 0) {
            tempArr[k] = arr[j];
            k++;
            j -= 2;
        }
        while (i < arr.length) {
            tempArr[k] = arr[i];
            k++;
            i += 2;
        }
        copyArr(tempArr, arr);
    }

    private static void copyArr (int [] origen, int [] target) {
        for (int i = 0; i < origen.length; i++) {
            target[i] = origen[i];
        }
    }

    public static int crossSearch (int [] arr, int x) {
        int oddResult = findInOdds(arr, x);
        if (oddResult != -1) {
            return oddResult;
        }
        return findInEven(arr, x);
    }

    private static int findInOdds (int [] arr, int x) {
        int left = 0;
        int right = arr.length / 2 -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid * 2 + 1] == x) {
                return mid * 2 + 1;
            }
            if (arr[mid * 2 + 1] > x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findInEven (int [] arr, int x) {
        int left = 0;
        int right = (arr.length - 1) / 2 ;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid * 2] == x) {
                return mid * 2;
            }
            if (arr[mid * 2] > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
