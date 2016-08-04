//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class EnrollmentSystem {
    
    private Admin admin;
    private Student currentAccount;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Section> sections;
    
    //Still have to think if my constructor is ok
    public EnrollmentSystem(){
        this.admin = new Admin();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.sections = new ArrayList<>();
    }
    //For Admin accounts
    //Boolean so that can display error message for later things
    public boolean RegisterStudentAccount(String ID, String password, String lastName, String firstName, double min, double max){
        if(admin.getIsLogin()){
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
        if(admin.getIsLogin()){
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
    public boolean addCourse(String code, String name, double units){
        if(admin.getIsLogin()){
            Course course = new Course(code, name, units);
            if(course.isSeven()){
                if(courses.isEmpty()){
                    courses.add(course);
                    return true;
                }
                else{
                    for(Course c : courses){
                        if(c.isNotUnique(course)){//true if not unique
                            return false;
                        }
                    }
                    courses.add(course);
                    return true;
                }
            }
            else 
                return false;
        }
        return false;
    }
    
    //returns true if able to open a section for a course OK NA
    public boolean openSection(Course course, Section section){
        if(admin.getIsLogin()){
            for(Section s : sections){
                if(s.getSectionName().equals(section.getSectionName()) && s.getCourse() .equals(course.getName())){
                    return false;
                }
            }
            section.setCourse(course);
            sections.add(section);
            return true;
        }
        else
            return false;
    }
    
    //Not yet complete Do I need Section section as a parameter?
    public boolean viewClassList(Course course, Section section){
        if(admin.getIsLogin()){
        }
        return false;
    }
    
    //Student account and not yet done
    public boolean enlistSection(Course course, Section section){
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){//If logged in and if not yet enrolled
            for(Course c : courses){
                if(!c.equals(course))
                    return false;//Check if the course parameter exists
            }
            for(Section s : sections){
                if(!s.equals(section))
                    return false;//Check if the course parameter exists
            }
            if(section.isFull())
                return false;
            for(Section s : currentAccount.getEnlists()){
                if(s.getCourse().equals(course))
                    return false;//The student is not enlisted yet in another section for the same course code
            }
            for(Section s : currentAccount.getEnlists()){
                if(!s.isNonConflic(section))
                    return false;
            }
            currentAccount.getEnlists().add(section);
            return true;
        }
        return false;
    }
    
    public boolean removeEnlistment(Course course, Section section){
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){
            for(Section s : currentAccount.getEnlists()){
                if(s.equals(section) && s.getCourse().equals(course))
                currentAccount.getEnlists().remove(section);
                return true;
            }
        }
        return false;
    }
    
    public boolean enroll(){
        if(currentAccount.getIsLogin() && currentAccount.getIsEnrolled()){
            if(currentAccount.isEnrollReady()){
                for(Section s : currentAccount.getEnlists()){
                    currentAccount.getEnrolls().add(s);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean viewEAF(){
        if(currentAccount.getIsLogin() && currentAccount.getIsEnrolled()){
            //viewer
        }
        return false;
    }
    
    public boolean login(String userName, String password){
        if(admin.getIsLogin())
            return false;//Will not login if Admin is still logged in
        for(Student s : students)
            if(s.getIsLogin())
                return false;//Will not login if any Student is still Logged in
        Account user = new Account(userName, password);
        if(user.equal(admin)){
            admin.setIsLogin(true);
            return true;
        }
        else{
            for(Student s : students){
                if(s.equal(user)){
                    s.setIsLogin(true);
                    this.currentAccount = s;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean logout(){
        admin.setIsLogin(false);
        for(Student s : students){
            if(s.getIsLogin())
                s.setIsLogin(false);
        }
        this.currentAccount = null;
        return true;
    }
    
    //getters
    public ArrayList<Student> getStudents(){return students;}
    public Admin getAdmin(){return admin;}
    public ArrayList<Course> getCourses(){return courses;}
    public ArrayList<Section> getSections(){return sections;}
    public Student getCurrentStudent(){return currentAccount;}
    
    
    
    public static void main(String[] args) {
        
    }
    
}
