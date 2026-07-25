public class Exercise23 {

    /**
     * Problem Description:
     * Finds the maximum length of a valid character path within a 2D array (matrix).
     * The path can start from any cell and move in four directions (up, down, left, right)
     * without moving diagonally. A valid cell is one whose character appears in the
     * provided 'pattern' string. Each cell can only be visited once per path.
     * If no cell in the matrix matches any character in the pattern, returns 0.

     * Signature: public static int maxPath(char[][] mat, String pattern)

     * Constraints:
     * Must be implemented strictly using recursion without any loops (no for/while).
     * Overloading is allowed. The matrix and pattern are guaranteed to be non-null.

     * Algorithm idea:
     * The solution employs a recursive backtracking approach combined with a recursive
     * matrix traversal. The 'maxPath' method acts as a recursive scanner to initiate
     * a path search from every cell (row, col) in the matrix. The 'lengthPath' helper
     * method performs the actual backtracking (DFS), exploring all valid adjacent cells.
     * To satisfy the constraint of not revisiting a cell in the same path, the current
     * cell's character is temporarily replaced with a null character ('\0') during the
     * recursive calls and restored immediately after (backtracking step). The maximum
     * length yielded across all possible starting points is computed and returned.
     */

    public static int lengthPath (char[][] mat, String pattern) {
        return lengthPath(mat, pattern, 0, 0);
    }

    public static int maxPath (char[][] mat, String pattern) {
        return maxPath(mat, pattern, 0, 0);
    }

    private static int lengthPath (char[][] mat, String pattern, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) {
            return 0;
        }
        if (!inThePattern(pattern, mat[i][j], 0)) {
            return 0;
        }
        char temp = mat[i][j];
        mat[i][j] = '\0';

        int up = lengthPath(mat, pattern, i - 1, j);
        int down = lengthPath(mat, pattern, i + 1, j);
        int left = lengthPath(mat, pattern, i , j - 1);
        int right = lengthPath(mat, pattern, i , j + 1);

        mat[i][j] = temp;

        return 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }

    private static int maxPath (char[][] mat, String pattern, int i, int j) {
        if (i >= mat.length) {
            return 0;
        }
        if (j >= mat[i].length) {
            return maxPath(mat, pattern, i + 1, 0);
        }
        return Math.max(
                lengthPath(mat, pattern, i, j), maxPath(mat, pattern, i, j + 1)
        );
    }

    private static boolean inThePattern (String pattern, char c, int index) {
        if (index >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(index) == c) {
            return true;
        }
        return inThePattern(pattern, c, index + 1);
    }
}
