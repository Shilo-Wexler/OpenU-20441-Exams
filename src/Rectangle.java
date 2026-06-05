public class Rectangle
{
    /**
     * ============================================================================
     * Section A: smallestRect1
     * ============================================================================
     * Write a static method that receives an array 'p' of points (Point objects)
     * and returns the minimal bounding Rectangle that contains all the points in the array.
     * * Assumptions:
     * - The array contains valid Point objects.
     * - The array has at least one point and is not null.
     * * Method Signature: public static Rectangle smallestRect1(Point[] p)
     * * * ============================================================================
     * Section B: smallestRect2
     * ============================================================================
     * Assume an array of points 'p' is arranged in two discrete lines parallel to
     * the X-axis (i.e., each line has a constant Y value).
     * - The points on the first (bottom) line appear at the beginning of the array
     * and are sorted in strictly ascending order of their X-coordinate.
     * - The points on the second (top) line appear at the end of the array and are
     * also sorted in strictly ascending order of their X-coordinate.
     * * Write a method that receives the array 'p' and returns the minimal bounding
     * Rectangle that contains all the points in the array.
     * * Assumptions:
     * - The array is not null and contains at least two points.
     * * Note: Your solution must be as efficient as possible in both time and space
     * complexities. A solution that is not efficient enough will receive partial credit.
     * * Method Signature: public static Rectangle smallestRect2(Point[] p)
     */

    private int _length;
    private int _width;
    private Point _sw;

    // constructor
    public Rectangle(int l, int w, Point sw)
    {
        _length = l;
        _width = w;
        _sw = new Point(sw);
    }

    // methods

    public static Rectangle smallestRect1(Point[] p)
    {
        double maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
        double maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;

        for (int i = 0; i < p.length; i++)
        {
            if (p[i].getX() > maxX)
                maxX = p[i].getX();
            if (p[i].getX() < minX)
                minX = p[i].getX();

            if (p[i].getY() > maxY)
                maxY = p[i].getY();
            if (p[i].getY() < minY)
                minY = p[i].getY();
        }

        int length = (int)(maxX - minX);
        int width = (int)(maxY - minY);
        Point point = new Point((int)minX, (int)minY);

        return new Rectangle(length, width, point);
    }

    public static Rectangle smallestRect2(Point [] p)
    {
        double maxY = p[p.length-1].getY(), minY = p[0].getY();
        int boundaryIndex = findSeamIndex(p, minY);
        int maxX = Math.max((int)p[boundaryIndex].getX(), (int)p[p.length-1].getX());
        int minX = Math.min((int)p[0].getX(), (int)p[boundaryIndex+1].getX());

        int length = (maxX - minX);
        int width = (int)(maxY - minY);
        Point point = new Point(minX, (int)minY);

        return new Rectangle(length, width, point);
    }

    private static int findSeamIndex (Point [] p, double firstLine)
    {
        int low = 0, high = p.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid == p.length-1)
                return -1;

            if (p[mid].getY() != p[mid + 1].getY())
                return mid;

            if (p[mid].getY() == firstLine)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}