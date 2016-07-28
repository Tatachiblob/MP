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
        this.isLogIn = false;//not logged in from the start
        this.isEnrolled = false;//not enrolled from the start
        this.minUnit = minUnit;
        this.maxUnit = maxUnit;
        this.enlists = new ArrayList<>();
        this.enrolls = new ArrayList<>();
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
    
    public boolean addEnlists(Course course, Section section){
        if(enlists.isEmpty()){
            course.getSections().add(section);
            return enlists.add(course);
        }
        else{
            for(Course c : enlists){
                for(Section s : c.getSections()){
                    if(s.getSectionName().equals(section.getSectionName()) || s.isFull() || !s.isNonConflic(section)){
                        return false;//if same section already exist or is full
                    }
                }//getting the existing sections inside the courses inside the enlistments
            }//getting the existing courses inside the enlistments
        }
    }
    
    public boolean addEnrolls(){
        
    }
    
    public boolean getIsEnrolled(){return isEnrolled;}
    public boolean getIsLogIn(){return isLogIn;}
    public ArrayList<Course> getEnlists(){return enlists;}
    public void setIsLogIn(boolean b){
        this.isLogIn = b;
    }
    
    //for checking
    public void display(){
        System.out.println("ID: " + this.getUserName());
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        for(Course c : enlists){
            System.out.println("Course enlisted: "  + c.getName());
            for(Section s : c.getSections())
                System.out.println("\tSection: " + s.getSectionName());
        }
    }
    
    //Testing Testing
    public static void main(String[] args) {
        Student s1 = new Student("11512709", "Tatachi9", "Inoue", "Yuta", 0, 0);
        Student s2 = new Student("115122709", "Tatachi9", "Inoue", "Kiku", 0, 0);
        
        Course c = new Course("INTPRG2", "Programming 2", 2);
        Section s = new Section("S13", "Shirley Chu", "TH", "9:00", "10:00", 23);
        s1.addEnlists(c, s);
        s1.display();
    }
    
}
