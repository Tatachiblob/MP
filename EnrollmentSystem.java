//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class EnrollmentSystem {
    
    private Admin admin;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    
    //Still have to think if my constructor is ok
    public EnrollmentSystem(){
        this.admin = new Admin();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    //For Admin accounts
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
    
    //return true if edited
    public boolean editStudent(String ID, String firstName, String lastName){
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
    
    //returns true if able to addCourse
    public boolean addCourse(String code, String name, int units){
        Course c = new Course(code, name, units);
        if(c.isSeven()){
            if(courses.isEmpty()){
                courses.add(c);
                return true;
            }
            for(int i = 0; i < courses.size(); i++){
                if(courses.get(i).isUnique(c)){
                    courses.add(c);
                    return true;
                }
            }
        }
        return false;
    }
    
    //returns true if able to open a section for a course
    public boolean openSection(String courseCode, String name, String faculty, String schedule, String start, String end, int capacity){
        Course c = null;
        for(Course course: courses){
            if(course.getCode().equals(courseCode))
                c = course;
        }
        //sections is from the courses' sections. Not from this enrollment class
        ArrayList<Section> sections = c.getSections();
        
        if(c != null){
            return c.addSection(name, faculty, schedule, start, end, capacity);
        }
        
        return false;
    }
    
    //Not yet complete
    public boolean viewClassList(String courseCode, String section){
        Course c = null;
        Section s = null;
        for(Course a : courses){
            if(a.getCode().equals(courseCode)){
                c = a;
            }
        }
        if(c == null)
            return false;
        
        for(Section a : c.getSections()){
            if(a.getSectionName().equals(section))
                s = a;
        }
        
        if(s == null)
            return false;
        
        else{
            System.out.println("Course: " + c.getCode());
            System.out.println("Section: " + s.getSectionName());
            //List of sutdents
            //Total Number of slots
            //Slots remaining
        }
        return false;
    }
    
    //for checking purpose
    public void display(){
        System.out.println("Admin: " + admin.getUserName());
        for(Student s : students)
            s.display();
        for(Course c : courses)
            c.display();
    }
    
    
    //Student account
    public boolean enlistSection(){
        
    }
    
    public boolean removeEnlistment(){
        
    }
    
    public boolean enroll(){
        
    }
    
    public boolean viewEAF(){
        
    }
    
    //getters
    public ArrayList<Student> getStudent(){return students;}
    public Admin getAdmin(){return admin;}
    public ArrayList<Course> getCourse(){return courses;}
    
    
}
