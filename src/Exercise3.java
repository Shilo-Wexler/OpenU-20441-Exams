public class Exercise3 {
    /**
     * Exercise 3: Cross-Sorted Array Operations
     * * This class provides highly optimized algorithms for manipulating a specialized array
     * structure consisting of two intertwined sub-sequences:
     * - Even indices are sorted in ascending order.
     * - Odd indices are sorted in descending order.
     * * Key Operations:
     * 1. crossSort: Merges the intertwined sub-sequences into a uniformly sorted array.
     * Time Complexity: O(n) | Space Complexity: O(n)
     * 2. crossSearch: Locates the index of a target value using dual adapted binary searches.
     * Time Complexity: O(log n) | Space Complexity: O(1)
     * * @author Shilo Wexler
     */

    public static void crossSort (int [] arr){

        int k = 0;
        int i = 0;
        int j = arr.length -1;
        int [] tempArr = new int[arr.length];

        if (arr.length % 2 != 0)
            j--;

        while (i < arr.length && j > 0){

            if (arr[i] < arr[j]){
                tempArr[k++] = arr[i];
                i += 2;
            }
            else {
                tempArr[k++] = arr[j];
                j -= 2;
            }
        }
        while (i <  arr.length)
        {
            tempArr[k++] = arr[i];
            i += 2;
        }
        while (j > 0){
            tempArr[k++] = arr[j];
            j -= 2;
        }
        copy(tempArr, arr);
    }
    private static void copy (int [] originArr, int [] destArr)
    {
        for (int i = 0; i < destArr.length; i++)
            destArr[i] = originArr[i];
    }

    public static int crossSearch (int [] arr, int x){
        int lowEven = 0;
        int highEven = (arr.length-1) / 2;

        while (highEven >= lowEven){

            int mid = (lowEven + highEven) / 2;
            if (arr[mid * 2] == x)
                return mid * 2;
            if (arr[mid * 2] > x)
                highEven = mid - 1;
            else
                lowEven = mid + 1;
        }

        int lowOdd = 0;
        int highOdd = (arr.length) / 2 - 1;

        while (highOdd >= lowOdd){
            int mid = (lowOdd + highOdd) / 2;

            if (arr[mid * 2 + 1] == x)
                return mid * 2 + 1;

            if (arr[mid * 2 + 1] > x)
                lowOdd = mid + 1;
            else
                highOdd = mid - 1;
        }
        return -1;
    }
}
