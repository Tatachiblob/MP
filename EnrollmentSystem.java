//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
import java.util.Vector;
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
        this.currentAccount = null;
    }
    //For Admin accounts
    //Boolean so that can display error message for later things
    public boolean RegisterStudentAccount(Student student){
        if(admin.getIsLogin()){
            if(!student.isLegitUnits())
                return false;
            if(students.size() > 0){
                for(Student y : students){
                    if(student.isEqual(y)){
                        return false;
                    }
                }
            }
        
            students.add(student);
            return true;
        }
        else
            return false;
    }
    
    //return true if edited
    //No need to call this anymore
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
    public boolean addCourse(Course course){
        if(admin.getIsLogin()){
            //Course course = new Course(code, name, units);
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
            if(!section.isThreeChar())
                return false;
            if(sections.isEmpty()){
                section.setCourse(course);
                sections.add(section);
                return true;
            }
            for(Section s : sections){
                if(s.getSectionName() .equals(section.getSectionName()) && s.getCourse() .getCode() .equals(course.getCode())/*s.getSectionName().equals(section.getSectionName()) && s.getCourse() .equals(course.getName())*/){
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
            if(sections.contains(section) && courses.contains(course)){
                if(section.getCourse() == course){
                    for(Student y : section.getStudents())
                        System.out.println("Name: " + y.getFullName());
                    System.out.println("Total Number of slots: " + section.getCapacity());
                    System.out.println("Remaining Slots: " + (section.getCapacity() - section.getStudents().size()));
                    return true;
                }
            }
        }
        return false;
    }
    
    //Student account and not yet done
    public boolean enlistSection(Course course, Section section){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){//If logged in and if not yet enrolled
            if(!courses.contains(course))
                return false;
            
            if(!sections.contains(section))
                return false; 
            
            if(section.isFull()){
                return false;
            }
            if(!section.getCourse().equals(course))
                return false;
            for(Section s : currentAccount.getEnlists()){
                if(s.getCourse().equals(course)){
                    return false;//The student is not enlisted yet in another section for the same course code
                }
            }
            for(Section s : currentAccount.getEnlists()){
                if(!s.isNonConflic(section)){
                    return false;
                }
            }
            currentAccount.getEnlists().add(section);
            return true;
        }
            /*
            for(Course c : courses){
                if(!c.getCode() .equals("Course: " + course.getCode())){
                    return false;//Check if the course parameter exists
                }
            }
            for(Section s : sections){
                if(!s.equals(section)){
                    System.out.println("Checking for Sections");
                    return false;//Check if the course parameter exists
                }
            }
            if(section.isFull()){
                System.out.println("Checking for Capacity");
                return false;
            }
            for(Section s : currentAccount.getEnlists()){
                if(s.getCourse().equals(course)){
                    System.out.println("Checking for Enlisted Section");
                    return false;//The student is not enlisted yet in another section for the same course code
                }
            }
            for(Section s : currentAccount.getEnlists()){
                if(!s.isNonConflic(section)){
                    System.out.println("Checking for conflicts");
                    return false;
                }
            }
            currentAccount.getEnlists().add(section);
            return true;
        }
        */
        
        return false;
    }
    
    public boolean removeEnlistment(Section section){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){
            if(sections.contains(section) && currentAccount.getEnlists().contains(section)){
                currentAccount.getEnlists().remove(section);
                return true;
            }
        }
        return false;
    }
    
    public boolean enroll(){
        if(currentAccount == null)
            return false;
        if(currentAccount.getIsLogin() && !currentAccount.getIsEnrolled()){
            if(currentAccount.isEnrollReady()){
                for(Section s : currentAccount.getEnlists()){
                    currentAccount.getEnrolls().add(s);
                    
                }
                for(Section s : currentAccount.getEnrolls()){
                    s.getStudents().add(currentAccount);
                }
                currentAccount.getEnlists().clear();
                currentAccount.setIsEnrolled();
                return true;
            }
        }
        return false;
    }
    
    public boolean viewEAF(){
        if(currentAccount.getIsLogin() && currentAccount.getIsEnrolled()){
            System.out.println("---------------------------------------------");
            System.out.println("Name: " + currentAccount.getFullName());
            System.out.println("ID: " + currentAccount.getUserName());
            String FORMAT = "%-10s %-30s %-10s %-30s %-20s %-5s";
            String s;
            s = String.format(FORMAT, "CODE", "COURSE", "SECTION", "TEACHER", "SCHEDULE", "UNITS");
            System.out.println(s);
            
            for(Section a : currentAccount.getEnrolls()){
                s = String.format(FORMAT, a.getCourse().getCode(), a.getCourse().getName(), a.getSectionName(), a.getFaculty(), a.getWholeSchedule(), Double.toString(a.getCourse().getUnits()));
                System.out.println(s);
            }
            System.out.println("TOTAL UNITS: " + currentAccount.getTotalUnitsEnrolled());
            System.out.println("---------------------------------------------");
        }
        return true;
    }
    
    public boolean login(Account dummy){
        if(admin.getIsLogin())
            return false;//Will not login if Admin is still logged in
        for(Student s : students)
            if(s.getIsLogin())
                return false;//Will not login if any Student is still Logged in
        //Account user = new Account(userName, password);
        if(dummy.equal(admin)){
            admin.setIsLogin(true);
            return true;
        }
        else{
            for(Student s : students){
                if(s.equal(dummy)){
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
    
    public Vector getCoursesVector(){
        return new Vector(courses);
    }
    
    public Vector getSectionsVector(){
        return new Vector(sections);
    }
    
    public Vector getStudentsVector(){
        return new Vector(students);
    }
     
    //getters
    public ArrayList<Student> getStudents(){return students;}
    public Admin getAdmin(){return admin;}
    public ArrayList<Course> getCourses(){return courses;}
    public ArrayList<Section> getSections(){return sections;}
    public Student getCurrentStudent(){return currentAccount;}
    
    /*
    public static void main(String[] args) {
        System.out.println("Name: Yuta Inoue");
        System.out.println("ID: 11512709");
        
        String FORMAT = "%-7s %-20s %-10s %-15s %-14s %-5s";
        String s = String.format(FORMAT, "CODE", "COURSE", "SECTION", "TEACHER", "SCHEDULE", "UNITS");
        String m = String.format(FORMAT, "INTPRG2", "Programming2", "S13", "Chu, Shirley", "TH 9:00-12:00", "2.0");
        System.out.println(s);
        System.out.println(m);
        
    }
    */
}
