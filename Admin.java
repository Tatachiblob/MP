import java.util.ArrayList;
public class Admin extends Account {
    
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Section> sections;
    
    public Admin(){
        super("admin", "dlsu");
        this.students = new ArrayList<>();
    }
    
    public ArrayList<Student> getStudents(){return students;}
    
    //Boolean so that can display error message for later things
    public boolean RegisterStudentAccount(String ID, String password, String last_name, String first_name){
        Student s = new Student(ID, password, last_name, first_name);
        
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
    
    public Student editStudent(String ID, String first_name, String last_name){
        Student s = null;
        
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getUserName() .equals(ID)){
                s = students.get(i);
            }
        }
        s.setFirstName(first_name);
        s.setLastName(last_name);
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
    
    public boolean openSection(){
        
    }
    
    public void viewClassList(String course_name, String section){
        
    }
    
}