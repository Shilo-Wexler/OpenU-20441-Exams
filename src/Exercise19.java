public class Exercise19 {

    /**
     •	Problem Description:
     •	Count all strictly increasing sequences of positive integers that sum up to a given target.
     •	•	Signature: public static int count(int sum)
     •	•	Constraints:
     •	Must use pure recursion (no loops). Method overloading is allowed.
     •	Must avoid unnecessary recursive calls by pruning invalid paths.
     •	•	Algorithm idea:
     •	The algorithm uses a recursive "take it or leave it" helper method.
     •	It tracks the remaining sum and the current positive integer to consider.
     •	At each step, it branches to either include the current number (subtracting it
     •	from the remaining sum) or skip it. The current number is always incremented
     •	to ensure a strictly increasing sequence. Base cases halt the recursion by
     •	returning 1 if the remaining sum is exactly 0, or returning 0 if the path is
     •	invalid (remaining sum < 0, or current number > remaining sum).
     */

    public static int count(int sum) {
        return count(sum, 1);
    }

    private static int count(int sum, int currAdd) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || currAdd > sum) {
            return 0;
        }
        int withCurrAdd = count(sum - currAdd, currAdd + 1);
        int withoutCurrAdd = count(sum, currAdd + 1);

        return withCurrAdd + withoutCurrAdd;
    }
}
