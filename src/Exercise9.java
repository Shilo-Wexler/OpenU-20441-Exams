public class Exercise9 {

    /**
     * Problem Description: Arithmetic Expression Evaluator
     * * We evaluate expressions using four operations (+, -, *, /) on a base number 'num'.
     * The goal is to reach a target 'result' using at most 'maxOp' operations.
     * * Task:
     * Write a static recursive method 'calc' that finds and prints all valid expressions
     * evaluating to 'result'. It must return the total count of these valid expressions.
     * Signature: public static int calc(int num, int result, int maxOp)
     * * Constraints:
     * - Operations are evaluated strictly left-to-right, ignoring standard math precedence.
     * - Division is integer division without remainder.
     * - Evaluation stops immediately once 'result' is reached (no extending with +num-num).
     * - The solution MUST be purely recursive without any loops (no loops in helper methods either).
     * - Method overloading is allowed.
     * - Efficiency is not a requirement (redundant recursive calls are permitted).
     */


    public static int calc (int num, int result, int maxOp){
        return calc(num, result, maxOp, num,"" + num);
    }

    private static int calc (int num, int result, int maxOp, int currentResult, String exp){
        if (currentResult == result && maxOp >= 0)
        {
            System.out.println(exp + " = " + result);
            return 1;
        }
        else if (maxOp <= 0)
            return 0;

        int add = calc(num, result, maxOp -1, currentResult + num, exp + " + " + num);
        int sub = calc(num, result, maxOp -1, currentResult - num, exp + " - " + num);
        int multi = calc(num, result, maxOp -1, currentResult * num, exp + " * " + num);
        int div = calc(num, result, maxOp -1, currentResult / num, exp + " / " + num);
        return sub + add + multi + div;
    }
}
