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
    
    public boolean editStudent(String ID, String firstName, String lastName){//return true if edited
        if(students.isEmpty())
            return false;
        else{
            Student s = null;
            for(int i = 0; i < students.size(); i++){
                if(students.get(i).getUserName() .equals(ID)){
                    s = students.get(i);
                }
            }
            if(s == null)
                return false;
            s.setFirstName(firstName);
            s.setLastName(lastName);
            return true;
        }
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
        
    }
    //Not yet complete
    public void viewClassList(String course_name, String section){
        
        System.out.println("Course: ");
        System.out.println("Section: ");
        System.out.println("List of Students enrolled: ");
        System.out.println("Total slots: ");
        System.out.println("Remaining slots: ");
    }
    
    public ArrayList<Student> getStudent(){return students;}
    
    public static void main(String[] args) {
        EnrollmentSystem e = new EnrollmentSystem();
        for (Student student : e.getStudent()) {
            student.display();
        }
    }
    
}
