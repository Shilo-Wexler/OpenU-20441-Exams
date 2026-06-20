public class Exercise8 {
    /**
     * Problem Description: Find the Duplicate Number
     * * Given an array 'a' of length n, containing integers in the range 1 to n-1.
     * There is at least one duplicate number in the array.
     * * Task:
     * Write a static method 'findDuplicate' that receives the array 'a'
     * and returns the number that appears more than once.
     * Signature: public static int findDuplicate(int[] a)
     * * Constraints:
     * - The method must be efficient in both time and space complexity.
     * - The array is not null and not empty.
     * - Modification of the array is allowed, and it does not need to be restored.
     * - A solution that is not efficient will receive limited points.
     */

    public static int findDuplicate (int []a){
        int i = 0;
        while (i < a.length)
        {
            if (a[i] != i + 1){
                int currentIndex = a[i] -1;

                if (a[i] == a[currentIndex])
                    return a[i];
                swap(a, i, currentIndex);
            }
            else
                i++;
        }
        return -1;
    }
    private static void swap (int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
