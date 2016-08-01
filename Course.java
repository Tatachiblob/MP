//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Course {
    
    private ArrayList<Section> sections;
    private String courseCode;
    private String courseName;
    private int courseUnit;
    
    public Course(String code, String name, int units){
        code = code.toUpperCase();
        this.courseCode = code;
        this.courseName = name;
        this.courseUnit = units;
        this.sections = new ArrayList<>();
    }
    
    public ArrayList<Section> getSections(){return sections;}
    public String getCode(){return courseCode;}
    public String getName(){return courseName;}
    public int getUnits(){return courseUnit;}
    
    public boolean isSeven(){//returns true if code is 7
        return courseCode.matches("[\\w-]{7}$");
    }
    
    public boolean isNotUnique(Course c){//returns true if not unique
        return this.courseCode.equals(c.courseCode);
    }
    
    //Still need to check
    public boolean addSection(Section section){//returns true if added
        return false;
    }
    
    //for checking purpose
    public void display(){
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Units: " + courseUnit);
        for(Section s : sections)
            s.display();
    }
    
    //Testing Testing
    /*
    public static void main(String[] args) {
        Course  c = new Course("ITMATH3", "Computer architecture", 0);
        System.out.println(c.isSeven());
        
    }
    */
}
