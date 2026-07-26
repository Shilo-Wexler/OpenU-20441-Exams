public class Exercise27 {

    /**
     * Problem Description:
     * Calculates the minimum travel time required to traverse a route consisting of N segments,
     * given two parallel one-dimensional arrays (road1 and road2) containing positive integers
     * that represent the travel time for each segment.
     * The driver starts at the beginning of either road 1 or road 2 and travels to the end.
     * The route must adhere to the following rule:
     * - The driver is allowed to switch from one road to the other at most once during the journey
     *   (meaning they can switch once, or not switch at all).

     * Signature: public static int shortestRoad(int[] road1, int[] road2)

     * Constraints:
     * The method must be highly efficient in both time and space complexities.
     * Expected Time Complexity: O(n)
     * Expected Space Complexity: O(1)

     * Algorithm idea:
     * The algorithm utilizes a two-pass approach to achieve O(n) time and O(1) space.
     * In the first pass, it calculates the total travel time for both roads entirely,
     * establishing the baseline total sums (sumRoad1 and sumRoad2).
     * In the second pass, it iterates through the segments again while maintaining a
     * running sum of the travel time on each road up to the current segment 'i'
     * (currSumRoad1 and currSumRoad2).
     * - At each index, it evaluates the total time if a lane switch were to occur exactly there:
     *   Option A (switch 1 to 2): Current running sum of road 1 + remaining sum of road 2.
     *   Option B (switch 2 to 1): Current running sum of road 2 + remaining sum of road 1.
     * - The remaining sum of a road is efficiently calculated in O(1) time by subtracting
     *   its current running sum from its total baseline sum.
     * Math.min is used at each step to continuously track and update the global minimum
     * travel time found so far. The final minimum time guarantees the optimal route.
     */

    public static int shortestRoad (int [] road1, int [] road2) {
        int sumRoad1 = 0;
        int sumRoad2 = 0;

        for (int i = 0; i < road1.length; i++) {
            sumRoad1 += road1[i];
            sumRoad2 += road2[i];
        }

        int currSumRoad1 = 0;
        int currSumRoad2 = 0;
        int minPath = Integer.MAX_VALUE;

        for (int i = 0; i < road1.length; i++) {
            currSumRoad1 += road1[i];
            currSumRoad2 += road2[i];

            minPath = Math.min(currSumRoad1 + sumRoad2 - currSumRoad2, minPath);
            minPath = Math.min(currSumRoad2 + sumRoad1 - currSumRoad1, minPath);
        }
        return minPath;
    }
}
