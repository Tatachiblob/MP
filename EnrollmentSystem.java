//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class EnrollmentSystem {
    
    private Admin admin;
    private ArrayList<Student> students;
    //private ArrayList<Section> sections;
    private ArrayList<Course> courses;
    
    //Still have to think if my constructor is ok
    public EnrollmentSystem(){
        this.admin = new Admin();
        this.students = new ArrayList<>();
        //this.sections = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
        //Boolean so that can display error message for later things
    public boolean RegisterStudentAccount(String ID, String password, String lastName, String firstName, int min, int max){
        Student s = new Student(ID, password, lastName, firstName, min, max);
        
        if(students.size() > 0){
            for(Student y : students){
                if(s.isEqual(y)){
                    return false;
                }
            }
        }
        
        students.add(s);
        return true;
    }
    
    public Student editStudent(String ID, String firstName, String lastName){
        Student s = null;
        
        if(students.isEmpty())
            return null;
        
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getUserName() .equals(ID)){
                s = students.get(i);
            }
        }
        s.setFirstName(firstName);
        s.setLastName(lastName);
        return s;
    }
    
    public boolean addCourse(String code, String name, int units){
        Course c = new Course(code, name, units);
        if(c.isSeven()){
            for(int i = 0; i < courses.size(); i++){
                if(courses.get(i).isUnique(c)){
                    courses.add(c);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean openSection(String name, String faculty, String schedule, String start, String end, int capacity){
        Section s = new Section(name, faculty, schedule, start, end, capacity);
        Course c;
        for(int i = 0; i < courses.size(); i++){
            c = courses.get(i);
            for(int j = 0; j < c.getSections().size(); j++){
                if()
            }
        }
        return false;
    }
    
    public void viewClassList(String course_name, String section){
        
    }    
}
