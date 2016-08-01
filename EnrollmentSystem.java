//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class EnrollmentSystem {
    
    private Admin admin;
    private Student currentAccount;
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
    public boolean addCourse(String code, String name, int units){
        if(admin.getIsLogin()){
            Course c = new Course(code, name, units);
            if(c.isSeven()){
                if(courses.isEmpty()){
                    courses.add(c);
                    return true;
                }
                else{
                }
            }
        }
        return false;
    }
    
    //returns true if able to open a section for a course
    public boolean openSection(Course course, Section section){
        
        return false;
    }
    
    //Not yet complete
    public boolean viewClassList(Course course){
        if(admin.getIsLogin()){
        }
        return false;
    }
    
    //for checking purpose
    public void display(){
        /*
        System.out.println("Admin: " + admin.getUserName());
        for(Student s : students)
            s.display();
        for(Course c : courses)
            c.display();
        */
        System.out.println("Current Acoount: " + currentAccount.getUserName());
    }
    
    //Student account and not yet done
    public boolean enlistSection(Course course, Section section){
        
        return false;
    }
    
    public boolean removeEnlistment(Section section){
        return false;
    }
    
    public boolean enroll(){
        return false;
    }
    
    public boolean viewEAF(){
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
    public Student getCurrentStudent(){return currentAccount;}
    
    public static void main(String[] args) {
        EnrollmentSystem e = new EnrollmentSystem();
        System.out.println(e.login("admin", "DLSU"));
        System.out.println(e.RegisterStudentAccount("11512709", "Komoro9!", "Inoue", "Yuta", 0, 0));
        System.out.println(e.RegisterStudentAccount("11512709", "Komoro9!", "Inoue", "Yuta", 0, 0));
        System.out.println(e.RegisterStudentAccount("11423912", "Komoro9!", "Inoue", "Kiku", 0, 0));
        System.out.println(e.editStudent("11512709", "Tatachi", "Inoue"));
        System.out.println(e.logout());
        System.out.println(e.login("11512789", "KOOMOWQE"));
        System.out.println(e.login("11512709", "KSDOAS"));
        System.out.println(e.login("11512709", "Komoro9!"));
        System.out.println(e.login("admin", "DLSU"));
        System.out.println(e.login("11423912", "Komoro9!"));
        e.display();
        e.logout();
        System.out.println(e.login("11423912", "Komoro9!"));
        e.display();
        e.logout();
        
    }
    
}
