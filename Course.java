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
        return courseCode.length() == 7;
    }
    
    public boolean isUnique(Course c){//returns true if unique
        return !(this.courseCode.equals(c.courseCode));
    }
    
    //Still need to check
    public boolean addSection(String name, String faculty, String schedule, String start, String end, int capacity){//returns true if added
        Section s = new Section(name, faculty, schedule, start, end, capacity);
        
        if(s.isThreeChar() && s.isValidSchedule() && s.isValidTime()){
            if(this.sections.isEmpty()){
                sections.add(s);
                return true;
            }
            for(int i = 0; i < sections.size(); i++){
                if(sections.get(i) .isUnique(s) && sections.get(i).isNonConflic(s)){
                    sections.add(s);
                    s.setCourse(this);
                    return true;
                }
            }
        }
        
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
        Course  c = new Course("ARCHOS", "Computer architecture", 0);
        System.out.println(c.addSection("S13", "Inoue Yuta", "MW", "129:00", "10:00", 10));
        System.out.println(c.addSection("S13", "Inoue Yuta", "MW", "8:00", "8:40", 10));
        
    }
    */
}
