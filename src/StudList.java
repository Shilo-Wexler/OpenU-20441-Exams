public class StudList {

    private StudentNode _head;
    private int _noOfStud;


    public StudList (){
        _head = null;
        _noOfStud = 0;
    }

    public StudList (StudentNode s){
        _head = s;
        _noOfStud = 1;
    }

    public StudentNode getStudents(){
        return _head;
    }

    public int getNoOfStud (){
        return _noOfStud;
    }

    public void add(String name, int d, int m, int y){
        Student s = new Student(name, d, m, y);
        StudentNode stud = new StudentNode(s, null);

        stud.setNext(_head);
        _head = stud;
        _noOfStud ++;
    }

    public void remove (String name, int d, int m, int y){
        if (getNoOfStud() == 0)
            return;

        Student s = new Student(name, d, m, y);
        if (_head.getStudent().equals(s))
        {
            _head = _head.getNext();
            _noOfStud --;
            return;
        }

        StudentNode prev = _head;
        StudentNode curr = _head.getNext();

        while (curr != null)
        {
            if (curr.getStudent().equals(s)){
                prev.setNext(curr.getNext());
                _noOfStud --;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }

    public StudList sort ()
    {
        StudList sortedList = new StudList();

        StudentNode current = this._head;
        StudentNode newTail = null;

        while (current != null){

            StudentNode newNode = new StudentNode(
                    current.getStudent(), null);

            if (sortedList._head == null){
                sortedList._head = newNode;
                newTail = newNode;
            }
            else {
                newTail.setNext(newNode);
                newTail = newNode;
            }
            sortedList._noOfStud ++;
            current = current.getNext();
        }
        sortedList._head = mergeSort(sortedList._head);

        return sortedList;
    }

    private StudentNode mergeSort (StudentNode head)
    {
        if (head == null || head.getNext() == null)
        {
            return head;
        }
        StudentNode middle = getMiddle(head);
        StudentNode nextOfMiddle = middle.getNext();
        middle.setNext(null);

        StudentNode left = mergeSort(head);
        StudentNode right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private StudentNode getMiddle (StudentNode head)
    {
        if (head == null)
            return head;

        StudentNode slow = head;
        StudentNode fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null)
        {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private StudentNode merge (StudentNode left, StudentNode right)
    {
        StudentNode dummy = new StudentNode(null, null);
        StudentNode tail = dummy;

        while (left != null && right != null)
        {
            Date leftDate = left.getStudent().getBirthday();
            Date rightDate = right.getStudent().getBirthday();

            if (leftDate.before(rightDate) || leftDate.equals(rightDate))
            {
                tail.setNext(left);
                left = left.getNext();
            }
            else {
                tail.setNext(right);
                right = right.getNext();
            }
            tail = tail.getNext();
        }
        if (left != null)
            tail.setNext(left);
        else
            tail.setNext(right);

        return dummy.getNext();
    }

    int DAY_OF_YEAR = 365;

    public int maxDaysWithoutBirthdays()
    {
        StudList sortedList = sort();
        StudentNode head = sortedList._head;
        int maxDiff = 0;

        if (head == null)
            return DAY_OF_YEAR;

        return maxDaysWithoutBirthdays(sortedList, head, maxDiff);
    }
    public int maxDaysWithoutBirthdays(StudList sorted, StudentNode head, int maxDiff)
    {
        if (head.getNext() == null) {
            Date curr = head.getStudent().getBirthday();
            return Math.max(maxDiff, DAY_OF_YEAR - curr.difference(sorted._head.getStudent().getBirthday()));
        }
        Date curr = head.getStudent().getBirthday();
        Date next = head.getNext().getStudent().getBirthday();
        return maxDaysWithoutBirthdays(sorted, head.getNext(), Math.max(maxDiff, curr.difference(next)));
    }

}
