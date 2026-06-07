public class Exercise6
{
    /**
     * This class provides a recursive algorithm to generate a Hadamard Matrix.

     * A Hadamard matrix of size n x n (where n is a power of 2) is a matrix
     * containing only the values 1 and -1. It is constructed recursively
     * based on the following block matrix pattern:
     * * H_2n = [ H_n   H_n ]
     * [ H_n  -H_n ]

     * The algorithm populates the given matrix strictly using a Divide and Conquer
     * recursive approach, without the use of any iterative loops. The matrix is
     * conceptually divided into four quadrants at each step, with the bottom-right
     * quadrant receiving an inverted sign until the base case of a single cell is reached.
     */

    public static void fillHadamard (int[][] mat)
    {
        fillHadamard(mat, 0, 0, mat.length, 1);
    }

    private  static void fillHadamard (int[][] mat, int row, int col, int size, int sign)
    {
        if (size == 1)
        {
            mat[row][col] = sign;
            return;
        }
        int halfSize = size / 2;

        fillHadamard(mat, row, col, halfSize, sign);
        fillHadamard(mat, row , col + halfSize, halfSize, sign);
        fillHadamard(mat, row + halfSize, col, halfSize, sign);
        fillHadamard(mat, row + halfSize, col + halfSize, halfSize, -sign);
    }
}
