//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Student extends Account {
    
    private String firstName;
    private String lastName;
    private boolean isLogIn;
    private boolean isEnrolled;
    private int minUnit;
    private int maxUnit;
    private ArrayList<Course> enlists;
    private ArrayList<Course> enrolls;
    
    
    public Student(String userName, String password, String lastName, String firstName, int minUnit, int maxUnit){
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLogIn = false;
        this.isEnrolled = false;//not enrolled from the start
        this.minUnit = minUnit;
        this.maxUnit = maxUnit;
        this.enlists = new ArrayList<>();
    }
    
    public boolean getIsEnrolled(){return isEnrolled;}
    
    public boolean getIsLogIn(){return isLogIn;}
    public void setIsLogIn(boolean b){
        this.isLogIn = b;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public boolean isEqual(Student s){//return true if equal, else not equal
        String myID = this.getUserName();
        String otherID = s.getUserName();
        return myID.equals(otherID);
    }
    
    //for checking
    public void display(){
        System.out.println("ID: " + this.getUserName());
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }
    
    //Testing Testing
    /*public static void main(String[] args) {
        Student s1 = new Student("11512709", "Tatachi9", "Inoue", "Yuta", 0, 0);
        Student s2 = new Student("115122709", "Tatachi9", "Inoue", "Kiku", 0, 0);
        
        System.out.println(s1.isEqual(s2));
        System.out.println(s2.isEqual(s1));
    }*/
    
}
