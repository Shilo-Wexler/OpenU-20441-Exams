public class Exercise7{
    /**
     * Problem Description: Letter Path in a Matrix

     * Given a 2D character array 'mat' of size n x m, and a String 'pattern',
     * a "Letter-Path" in the matrix is defined by the following conditions:
     * 1. Movement is only allowed from one cell to an adjacent cell: up, down, left, or right
     * (no diagonal movements).
     * 2. A path can only proceed to a cell if its character exists within the 'pattern' string.
     * 3. A path cannot return to a cell it has already visited.

     * Part A:
     * Write a static recursive method 'lengthPath' that accepts 'mat' and 'pattern'.
     * The method returns the length of the longest Letter-Path starting strictly
     * from the first cell (row 0, column 0). If the character in the first cell does not
     * appear in 'pattern', the method returns 0.
     * Signature: public static int lengthPath(char[][] mat, String pattern)

     * Part B:
     * Write a static recursive method 'maxPath' that returns the length of the overall
     * longest Letter-Path anywhere in the matrix (can start from any cell).
     * Signature: public static int maxPath(char[][] mat, String pattern)

     * Constraints:
     * - The methods must be strictly recursive. No loops are allowed.
     * - Method overloading is allowed.
     * - Assume the matrix and string are not null and not empty.
     * - Temporary modification of the matrix is allowed, provided it is restored
     * to its original state before the method terminates.
     */


    public static int lengthPath (char[][] mat, String pattern){
        boolean[][] boolMat = new boolean[mat.length][mat[0].length];
        return lengthPath(mat, pattern, 0, 0, boolMat);
    }
    private static int lengthPath (char[][] mat, String pattern, int row, int col, boolean[][] boolMat){
        if (row >= mat.length || row < 0) return 0;
        if (col >= mat[row].length || col < 0) return 0;
        if (boolMat[row][col]) return 0;

        if (!cIsInPattern(mat[row][col], pattern, 0)) return 0;

        boolMat[row][col] = true;

        int up = 1 + lengthPath(mat, pattern, row - 1, col, boolMat);
        int down = 1 + lengthPath(mat, pattern, row + 1, col, boolMat);
        int right = 1 + lengthPath(mat, pattern, row , col + 1, boolMat);
        int left = 1 + lengthPath(mat, pattern, row, col - 1, boolMat);

        boolMat[row][col] = false;

        return Math.max(Math.max(up, down), Math.max(right, left));
    }

    private static boolean cIsInPattern (char c, String pattern, int index){
        if (index >= pattern.length())
            return false;
        if (pattern.charAt(index) == c)
            return true;
        return cIsInPattern(c, pattern, index + 1);
    }

    public static int maxPath (char[][] mat, String pattern){
        boolean[][] boolMat = new boolean[mat.length][mat[0].length];
        return maxPath(mat, pattern, 0, 0, boolMat);
    }

    private static int maxPath (char[][] mat, String pattern, int row, int col, boolean[][] boolMat){
        if (row == mat.length)
            return 0;
        if (col == mat[row].length)
            return maxPath(mat, pattern, row + 1, 0, boolMat);

        return Math.max(lengthPath(mat, pattern, row, col, boolMat),maxPath(mat, pattern, row, col+1, boolMat));
    }
}
