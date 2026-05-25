public class StudentNode {


    private Student _stud;
    private StudentNode _next;


    public StudentNode (Student s, StudentNode next){
        _stud = s;
        _next = next;
    }

    public Student getStudent (){
        return _stud;
    }

    public StudentNode getNext (){
        return _next;
    }

    public void setStudent (Student stud){
        _stud = stud;
    }

    public void setNext (StudentNode node){
        _next = node;
    }
}
