//Inoue, Yuta   Salva, Trisha
import java.util.*;
public class Student extends Account {
    
    private String firstName;
    private String lastName;
    private boolean isEnrolled;
    private double minUnit;
    private double maxUnit;
    private ArrayList<Section> enlists;
    private ArrayList<Section> enrolls;
    
    
    public Student(String userName, String password, String lastName, String firstName, double minUnit, double maxUnit){
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
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
    
    public void setIsEnrolled(){
        this.isEnrolled = true;
    }
    
    public boolean isEqual(Student s){//return true if equal, else not equal
        String myID = this.getUserName();
        String otherID = s.getUserName();
        return myID.equals(otherID);
    }
    
    public boolean getIsEnrolled(){return isEnrolled;}
    public ArrayList<Section> getEnlists(){return enlists;}
    public ArrayList<Section> getEnrolls(){return enrolls;}
    public String getFullName(){return lastName + " " + firstName;}
    
    public boolean isLegitUnits(){
        return minUnit <= maxUnit;
    }
    
    public double getTotalUnitsEnlisted(){
        double total = 0;
        for(Section s : enlists){
            total += s.getCourse().getUnits();
        }
        return total;
    }
    
    public double getTotalUnitsEnrolled(){
        double total = 0;
        for(Section s : enrolls){
            total += s.getCourse().getUnits();
        }
        return total;
    }
    
    public boolean isEnrollReady(){
        return getTotalUnitsEnlisted() >= minUnit && getTotalUnitsEnlisted() <= maxUnit;
    }
    
    @Override
    public String toString(){
        return this.getUserName();
    }
    
    public Vector getEnlistedSectionsVector(){
        return new Vector(enlists);
    }
    
    public Vector getEnlistedCourseVector(){
        ArrayList<Course> courses = new ArrayList<>();
        for(Section check : enlists){
            courses.add(check.getCourse());
        }
        return new Vector(courses);
    }
    
    //for checking
    public void display(){
        String NAMEFORMAT = "%s:%s";
        String name = String.format(NAMEFORMAT, "NAME", this.lastName + "," + this.firstName);
        String IDFORMAT = "%s:%s";
        String id = String.format(IDFORMAT, "ID NUMBER", this.getUserName());
        String CFORMAT = "%s %s %s %s %s %s";
        String c = String.format(CFORMAT, "CODE","COURSE NAME", "SECTION", "TEACHER", "SCHEDULE", "UNITS");
        System.out.println(name);
        System.out.println(id);
        System.out.println(c);
    }
    
}
