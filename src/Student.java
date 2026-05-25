public class Student {

    private final String _name;
    private final Date _birthday;

    public Student (String n, int d, int m, int y)
    {
        _name = n;
        _birthday = new Date(d, m, y);
    }

    public Date getBirthday (){
        return new Date (_birthday);
    }

    public String getName (){
        return _name;
    }

    public boolean equals (Object other){
        if (!(other instanceof Student otherStudent))
            return false;

        boolean isSameName = this._name.equals(otherStudent.getName());
        boolean isSameBirthday = _birthday.equals(otherStudent.getBirthday());

        return isSameName && isSameBirthday;
    }

    public String toString (){
        return STR."Name: \{_name}. Birthday: \{_birthday.toString()}";
    }
}
