//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Course {
    
    private ArrayList<Section> sections;
    private String courseCode;
    private String courseName;
    private int courseUnits;
    
    public Course(String code, String name, int units){
        code = code.toUpperCase();
        this.courseCode = code;
        this.courseName = name;
        this.courseUnits = units;
        this.sections = new ArrayList<>();
    }
    
    public ArrayList<Section> getSections(){return sections;}
    public String getCode(){return courseCode;}
    public String getName(){return courseName;}
    public int getUnits(){return courseUnits;}
    
    public boolean isSeven(){//returns true if code is 7
        return courseCode.length() == 7;
    }
    
    public boolean isUnique(Course c){//returns true if unique
        return !(this.courseCode.equals(c.courseCode));
    }
    
}
