public class Group {

    public final int MAX_STUDENTS = 400;
    private final Student [] _stud;
    private int _numOfStudents;


    public Group (){
        _stud = new Student[MAX_STUDENTS];
        _numOfStudents = 0;
    }

    public Student [] getStudents (){
        Student [] arrStudents = new Student[getNumOfStudents()];

        System.arraycopy(_stud, 0, arrStudents, 0, arrStudents.length);
        return arrStudents;
    }

    public int getNumOfStudents (){
        return _numOfStudents;
    }

    public void remove (String name, int d, int m, int y)
    {
        Student studentToRemove = new Student(name, d, m, y);
        int i = 0;
        boolean found = false;
        while (i < MAX_STUDENTS && _stud[i] != null && !found) {
            if (_stud[i].equals(studentToRemove))
                found = true;
            i ++;
        }
        if (!found)
            return;

        while (i < MAX_STUDENTS && _stud[i] != null){
            _stud[i-1] = _stud[i];
            i++;
        }
        _numOfStudents --;
        _stud[_numOfStudents] = null;
    }

    public Student[] sort() {
        Student[] sortedArray = getStudents();

        if (sortedArray.length <= 1) {
            return sortedArray;
        }

        mergeSort(sortedArray, 0, sortedArray.length - 1);

        return sortedArray;
    }

    private void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArr = new Student[n1];
        Student[] rightArr = new Student[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            Date leftDate = leftArr[i].getBirthday();
            Date rightDate = rightArr[j].getBirthday();

            if (leftDate.before(rightDate) || leftDate.equals(rightDate)) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void add (String name, int day, int month, int year){
        if (getNumOfStudents() == MAX_STUDENTS)
            return;

        Student s = new Student(name, day, month, year);

        int i = getNumOfStudents() - 1;
        while (i >= 0 && greaterByName(_stud[i], s)){
            _stud[i + 1] = _stud[i];
            i--;
        }
        _stud[i + 1] = s;
        _numOfStudents ++;
    }

    public boolean greaterByName(Student s1, Student s2){
        int len = Math.min(s1.getName().length(), s2.getName().length());

        for (int i = 0; i < len; i++) {
            if (s1.getName().charAt(i) > s2.getName().charAt(i))
                return true;
            if (s1.getName().charAt(i) < s2.getName().charAt(i))
                return false;
        }
        return s1.getName().length() > s2.getName().length();
    }
    public int howManyMonth(){
        boolean [] month = new boolean[12];
        for (int i = 0; i < getNumOfStudents(); i++){
            month[_stud[i].getBirthday().getMonth() - 1] = true;
        }
        int count = 0;
        for (int i =0; i < month.length; i++)
            if( month[i])
                count ++;
        return month.length - count;
    }

    public boolean biggerThan (int num){
        if (getNumOfStudents() <= 1)
            return false;

        Date mindate = _stud[0].getBirthday();
        Date maxdate = _stud[0].getBirthday();

        for (int i = 1; i < getNumOfStudents(); i++)
        {
            Date current = _stud[i].getBirthday();

            if (current.before(mindate))
                mindate = current;
            if (current.after(maxdate))
                maxdate = current;
        }
        return mindate.difference(maxdate) > num;
    }
}
