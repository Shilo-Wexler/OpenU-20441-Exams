public class Exercise17 {

    /**
     * Problem: Partition an array into two disjoint and complementary subsets such that
     * the absolute difference between the sums of the subsets equals the absolute
     * difference between the sizes (number of elements) of the subsets. We must count
     * all valid partitions and print them, using only recursion and no loops.

     * Approach: Recursive backtracking.
     * We explore the full binary recursion tree by deciding for each array element
     * whether to assign it to subset A or subset B. We use an overloaded helper
     * method to carry the current state forward: the current array index, running
     * sums of both subsets, element counts of both subsets, and string accumulators
     * for printing the generated paths. Once we reach the end of the array, we
     * evaluate the condition. This explores all 2^n possibilities, resulting in
     * an O(2^n) time complexity.
     */

    public static int countEqualDiff (int [] arr) {
        int groupA = countEqualDiff(arr, 1, 0, arr[0], 0, 1, "" + arr[0], "");
        int groupB = countEqualDiff(arr, 0, 1, 0, arr[0], 1, "", "" + arr[0]);
        return  groupA + groupB;
    }

    private static int countEqualDiff (int [] arr, int countA, int countB, int sumA, int sumB, int i, String pathA, String pathB) {
        if (i >= arr.length) {
            int diffCount = Math.abs(countA - countB);
            int diffSum = Math.abs(sumA - sumB);
            if (diffCount == diffSum) {
                System.out.println(pathA + "\tsum = " + sumA + " count = " + countA);
                System.out.println(pathB + "\tsum = " + sumB + " count = " + countB + "\n");
                return 1;
            }
            else {
                return 0;
            }
        }
        int iInA = countEqualDiff(arr, countA + 1, countB, sumA + arr[i], sumB, i + 1, pathA + " " + arr[i], pathB);
        int iInB = countEqualDiff(arr, countA, countB + 1, sumA, sumB + arr[i], i + 1, pathA, pathB + " " + arr[i]);
        return iInA + iInB;
    }
}
