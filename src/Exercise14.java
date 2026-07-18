public class Exercise14 {

    /**
     * Problem: For each element arr[i] (where num <= i <= arr.length - 1 - num),
     * check whether the sum of arr[i] together with its 'num' neighbors on each side
     * is divisible by arr[i] itself.
     *
     * Approach: Sliding window.
     * We maintain a running sum of a window of size (2*num + 1).
     * As the window slides one step to the right, we add the new element entering
     * on the right and subtract the element leaving on the left - instead of
     * recalculating the whole sum from scratch each time.
     * This gives O(n) time and O(1) extra space.
     */
    public static int howManyDivisors(int[] arr, int num) {
        if (arr.length < num * 2 + 1)
            return -1;

        int windowSize = num * 2 + 1;
        int candidateIndex = num;
        int leftEdgeIndex = 0;
        int windowSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= windowSize - 1) {
                if (windowSum % arr[candidateIndex] == 0) {
                    count++;
                }
                candidateIndex++;
                windowSum -= arr[leftEdgeIndex];
                leftEdgeIndex++;
            }
        }
        return count;
    }
}
