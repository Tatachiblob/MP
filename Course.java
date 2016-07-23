//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Course {
    
    private ArrayList<Section> sections;
    private String course_code;
    private String course_name;
    private int course_units;
    
    public Course(String code, String name, int units){
        code = code.toUpperCase();
        this.course_code = code;
        this.course_name = name;
        this.course_units = units;
        this.sections = new ArrayList<>();
    }
    
    public ArrayList<Section> getSections(){return sections;}
    public String getCode(){return course_code;}
    public String getName(){return course_name;}
    public int getUnits(){return course_units;}
    
    public boolean isSeven(){//returns true if code is 7
        return course_code.length() == 7;
    }
    
    public boolean isUnique(Course c){//returns true if unique
        return !(this.course_code.equals(c.course_code));
    }
    
}
