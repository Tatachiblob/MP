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
        if(admin.getIsLogIn()){
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
        else
            return false;
    }
    
    //return true if edited
    public boolean editStudent(String ID, String firstName, String lastName){
        if(admin.getIsLogIn()){
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
        else
            return false;
    }
    
    //returns true if able to addCourse
    public boolean addCourse(String code, String name, int units){
        if(admin.getIsLogIn()){
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
        }
        return false;
    }
    
    //returns true if able to open a section for a course
    public boolean openSection(String courseCode, String name, String faculty, String schedule, String start, String end, int capacity){
        if(admin.getIsLogIn()){
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
        }
        return false;
    }
    
    //Not yet complete
    public boolean viewClassList(String courseCode, String section){
        if(admin.getIsLogIn()){
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
    
    
    //Student account and all incomplete
    public boolean enlistSection(String course, String section){
        for(Course c : courses)
        return false;
    }
    
    public boolean removeEnlistment(String course, String section){
        return false;
    }
    
    public boolean enroll(){
        return false;
    }
    
    public boolean viewEAF(){
        return false;
    }
    
    public boolean login(String userName, String password){
        Account user = new Account(userName, password);
        if(user.equal(admin)){
            admin.setIsLogIn(true);
            return true;
        }
        else{
            for(Student s : students){
                if(s.equal(user)){
                    s.setIsLogIn(true);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean logout(){
        admin.setIsLogIn(false);
        for(Student s : students){
            if(s.getIsLogIn())
                s.setIsLogIn(false);
        }
        return true;
    }
    
    //getters
    public ArrayList<Student> getStudent(){return students;}
    public Admin getAdmin(){return admin;}
    public ArrayList<Course> getCourse(){return courses;}
    
}
