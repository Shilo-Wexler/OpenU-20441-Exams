public class Exercise15 {

    /**
     * Problem Description: Find the Heaviest Path

     * Given a 1D array of positive integers, find the maximum sum of a path
     * from the first to the last cell. In each step, you can jump right or left
     * by exactly (cell_value + step_number). The method prints all valid paths
     * and returns the maximum weight found. If no valid path exists, it returns
     * Integer.MAX_VALUE.

     * Signature: public static int heaviestPath(int[] arr)

     * Constraint: Must use recursion. Array state must be preserved (backtracking).

     * Algorithm idea:
     * A recursive helper method explores both left and right jump possibilities.
     * It tracks the current step, accumulated sum, and a string of the path.
     * Visited cells are temporarily marked with -1 to prevent infinite loops,
     * and restored before returning. At the last index, the path is printed.
     * Math.max is used to bubble up the heaviest path's sum up the call stack.
     */

    public static int heaviestPath (int [] arr) {
        int result = heaviestPath(arr, 0, 1, 0,"");

        if (result == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return result;
    }

    private static int heaviestPath (int [] arr, int i, int step, int sum, String path) {
        if (i < 0 || i >= arr.length || arr[i] == -1) {
            return Integer.MIN_VALUE;
        }

        if (i == arr.length -1) {
            System.out.println(path + (arr.length-1) + "\tsum = " + (sum + arr[i]));
            return sum + arr[i];
        }

        int temp = arr[i];
        arr[i] = -1;

        int attempt1 = heaviestPath(arr, i + (step + temp), step + 1, sum + temp, path + i + " -- ");
        int attempt2 = heaviestPath(arr, i - (step + temp), step + 1, sum + temp, path + i + " -- ");

        arr[i] = temp;

        return Math.max(attempt1, attempt2);
    }
}
