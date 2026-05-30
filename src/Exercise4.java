public class Exercise4 {

    /**
     * Problem Description:
     * Given a 2D array of non-negative integers, find all possible paths from
     * the top-left cell (0,0) to the bottom-right cell (m.length-1, m[0].length-1).
     * A path consists of adjacent cells (up, down, left, right).
     * The weight of a path is the sum of the values in the cells forming the path.
     * The method prints all valid paths and their corresponding total weights.
     */

    public static void printPathWeights (int [] [] m){

        printPathWeights(m, 0, 0, 0, "");
    }

    private static void printPathWeights (int [] [] m, int i, int j, int sum, String path){

        if (i < 0 || i >= m.length)
            return;
        if (j < 0 || j >= m[i].length)
            return;

        if (m[i][j] == -1)
            return;

        if (i == m.length-1 && j == m[i].length-1)
        {
            sum = sum + m[i][j];
            System.out.println(path + m[i][j]  + " = " + sum);
            return;
        }
        sum = sum + m[i][j];
        path = path + m[i][j] + " + ";

        int temp = m[i][j];
        m[i][j] = -1;

        printPathWeights(m, i + 1, j, sum, path);
        printPathWeights(m, i - 1, j, sum, path);
        printPathWeights(m, i, j + 1, sum, path);
        printPathWeights(m, i, j - 1, sum, path);

        m[i][j] = temp;
    }
}
