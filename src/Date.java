public class Date {

    private final int _day;
    private final int _month;
    private final int _year;

    public Date(int d, int m, int y) {
        _day = d;
        _month = m;
        _year = y;
    }

    public Date(Date other) {
        this(other._day, other._month, other._year);
    }

    public int getYear() {
        return this._year;
    }

    public int getMonth() {
        return this._month;
    }

    public int getDay ()
    {
        return this._day;
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof Date otherDate))
            return false;

        boolean equalYear = this._year == otherDate.getYear();
        boolean equalMonth = this._month == otherDate.getMonth();
        boolean equalDay = this._day == otherDate.getDay();

        return equalYear && equalMonth && equalDay;
    }

    public boolean before (Date d)
    {
        if (this._year < d.getYear())
            return true;
        if (this._year == d.getYear()) {
            if (this._month < d.getMonth())
                return true;
            else if (this._month == d.getMonth()) {
                return this._day < d.getDay();
            }
        }
        return false;
    }

    public boolean after (Date d)
    {
        return d.before(this);
    }

    public int difference (Date d)
    {
        return Math.abs(calcDays(this) - calcDays(d));
    }

    private int calcDays (Date d)
    {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int allDays = d.getYear() * 365;
        for (int m = 0; m < d.getMonth() -1; m++)
        {
            allDays += daysInMonth[m];
        }
        return allDays + d.getDay();
    }

    public String toString() {
        return STR."\{this._day}/\{this._month}/\{this._year}";
    }
}
