import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        EnrollmentSystem e = new EnrollmentSystem();
        Student s = new Student("11512709", "MyPassword!", "Inoue", "Yuta", 10, 30);
        Student s2 = new Student("1112342", "0317", "Gabriel", "Santa", 10, 30);
        Student s3 = new Student("11421329", "YourMom", "Salva", "Trisha", 10, 30);
        Student s4 = new Student("11249237", "Happy", "Pilapil", "Ela", 10, 30);
        Student s5 = new Student("11723164", "Kevin", "Uy", "Alec", 10, 30);
        
        Course c = new Course("INTPRG2", "Programming 2", 2);
        Course c2 = new Course("ENGLCOM", "English Communication", 3);
        Course c3 = new Course("ITMATH3", "Math for IT", 2);
        Course c4 = new Course("ARCH-OS", "Computer Architecture", 4);
        Course c5 = new Course("FITDANCE", "Danceing PE", 4);
        Section sec = new Section("S12", "Shirely Chu", "MW", "9:00", "10:45", 12);
        Section sec2 = new Section("S13", "Shirely Chu", "MW", "11:00", "12:30", 12);
        Section sec3 = new Section("A23", "Joanna Go", "TH", "7:30", "9:30", 12);
        Section sec4 = new Section("A24", "Joanna Go", "MW", "10:00", "12:00", 12);
        Section sec5 = new Section("S12", "Alcantara Harlod", "MW", "1:00", "2:45", 12);
        Section sec6 = new Section("S13", "Alcantara Harlod", "TH", "3:00", "4:45", 12);
        Section sec7 = new Section("S14", "Roger Uy", "MW", "2:00", "3:45", 12);
        Section sec8 = new Section("S12", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec9 = new Section("S16", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec10 = new Section("EQ", "Sir? Valdez", "TH", "4:00", "5:45", 12);
        
        //Admin Login
        e.login("admin", "DLSU");
        System.out.println("Is Admin Login: " + e.getAdmin().getIsLogin());
        System.out.println("Register 1st Student: " + e.RegisterStudentAccount(s));
        System.out.println("Register 2nd Student: " + e.RegisterStudentAccount(s2));
        System.out.println("Register 3rd Student: " + e.RegisterStudentAccount(s3));
        System.out.println("Register 4th Student: " + e.RegisterStudentAccount(s4));
        System.out.println("Register 5th Student: " + e.RegisterStudentAccount(s5));
        for(Student check : e.getStudents()){
            System.out.println("ID: " + check.getUserName());
            System.out.println("Name: " + check.getFullName());
        }
        
        System.out.println("Add Course : " + e.addCourse(c));
        System.out.println("Add Course : " + e.addCourse(c2));
        System.out.println("Add Course : " + e.addCourse(c3));
        System.out.println("Add Course : " + e.addCourse(c4));
        System.out.println("Add Course : " + e.addCourse(c5));
        for(Course check : e.getCourses()){
            System.out.println("Course: " + check.getCode());
            System.out.println("Name: " + check.getName());
        }
        
        System.out.println("Open Section: " + e.openSection(c, sec));
        System.out.println("Open Section: " + e.openSection(c, sec2));
        System.out.println("Open Section: " + e.openSection(c2, sec3));
        System.out.println("Open Section: " + e.openSection(c2, sec4));
        System.out.println("Open Section: " + e.openSection(c3, sec5));
        System.out.println("Open Section: " + e.openSection(c3, sec6));
        System.out.println("Open Section: " + e.openSection(c4, sec7));
        System.out.println("Open Section: " + e.openSection(c4, sec8));
        System.out.println("Open Section: " + e.openSection(c5, sec10));
        
        for(Section check : e.getSections()){
            System.out.println("Name: " + check.getSectionName());
            System.out.println("Course: " + check.getCourse().getCode());
        }
        
        System.out.println(e.logout());
        System.out.println(e.login("11512709", "MyPassword!"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        System.out.println("Enlist(INTPRG2)(S13): " + e.enlistSection(c, sec2));// should be true
        System.out.println("Enlist(ENGLCOM)(A24): " + e.enlistSection(c2, sec4));//should be false
        System.out.println("Enlist(ENGLCOM)(A23): " + e.enlistSection(c2, sec3));//should be true
        System.out.println("Enlist(ITMATH3)(S12): " + e.enlistSection(c3, sec5));//should be true
        System.out.println("Enlist(ARCH-OS)(S14): " + e.enlistSection(c4, sec7));//should be false
        System.out.println("Enlist(ARCH-OS)(S12): " + e.enlistSection(c4, sec8));//should be true
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        /*
        System.out.println("Remove: " + e.removeEnlistment(c, sec2));
        System.out.println("Remove: " + e.removeEnlistment(c2, sec3));
        System.out.println("Remove: " + e.removeEnlistment(c3, sec5));
        System.out.println("Remove: " + e.removeEnlistment(c4, sec8));
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        */
        System.out.println("Logout: " + (e.logout()));
        System.out.println("Login: " + e.login("1112342", "0317"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        
        System.out.println("Enlist(INTPRG2)(S13): " + e.enlistSection(c, sec2));
        System.out.println("Enlist(ENGLCOM)(A24): " + e.enlistSection(c2, sec4));
        System.out.println("Enlist(ENGLCOM)(A23): " + e.enlistSection(c2, sec3));
        System.out.println("Enlist(ITMATH3)(S12): " + e.enlistSection(c3, sec5));
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        
        System.out.println("Logout: " + e.logout());
        System.out.println("Login: " + e.login("11512709", "MyPassword!"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        
        System.out.println("Enlist(INTPRG2)(S13): " + e.enlistSection(c, sec2));
        System.out.println("Enlist(ENGLCOM)(A24): " + e.enlistSection(c2, sec4));
        System.out.println("Enlist(ENGLCOM)(A23): " + e.enlistSection(c2, sec3));
        System.out.println("Enlist(ITMATH3)(S12): " + e.enlistSection(c3, sec5));
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        
        System.out.println("Logout: " + (e.logout()));
        System.out.println("Login: " + e.login("1112342", "0317"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        
        System.out.println("Enlist(INTPRG2)(S13): " + e.enlistSection(c, sec2));// should be true
        System.out.println("Enlist(ENGLCOM)(A24): " + e.enlistSection(c2, sec4));//should be false
        System.out.println("Enlist(ENGLCOM)(A23): " + e.enlistSection(c2, sec3));//should be true
        System.out.println("Enlist(ITMATH3)(S12): " + e.enlistSection(c3, sec5));//should be true
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        
        System.out.println("Logout: " + (e.logout()));
        System.out.println("Login: " + e.login("1112342", "0317"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        
        System.out.println("Remove: " + e.removeEnlistment(c, sec2));
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        
        System.out.println("Logout: " + (e.logout()));
        System.out.println("Login: " + e.login("11512709", "MyPassword!"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        
        System.out.println("Enroll: " + e.enroll());
        for(Section check : e.getCurrentStudent().getEnrolls()){
            System.out.println("Enrolled Course: " + check.getCourse().getCode());
            System.out.println("Enrolled Section: " + check.getSectionName());
        }
        
        e.viewEAF();
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section(After Enroll): " + check.getSectionName()); 
            System.out.println("Enlisted Course(After Enroll): " + check.getCourse().getCode()); 
        }
        
        System.out.println("Enlist(After Enroll): " + e.enlistSection(c5, sec10));
        
        System.out.println("Logout: " + (e.logout()));
        System.out.println("Login: " + e.login("1112342", "0317"));
        System.out.println("Student Name: " + e.getCurrentStudent().getFullName());
        
        for(Section check : e.getCurrentStudent().getEnlists()){
            System.out.println("Enlisted Section: " + check.getSectionName()); 
            System.out.println("Enlisted Course: " + check.getCourse().getCode()); 
        }
        System.out.println("Total Units Enlisted: " + e.getCurrentStudent().getTotalUnitsEnlisted());
        System.out.println("Enlist(ENGLCOM)(A23): " + e.enlistSection(c2, sec3));
        System.out.println("Enlist(ITMATH3)(S12): " + e.enlistSection(c3, sec5));
        System.out.println("Enlist(INTPRG2)(S13): " + e.enlistSection(c, sec2));
        System.out.println("Enlist(ARCH-OS)(S12): " + e.enlistSection(c4, sec8));
        System.out.println("Enroll: " + e.enroll());
        e.viewEAF();
        
        e.logout();
        e.login("admin", "DLSU");
        e.viewClassList(c, sec2);
    }
    
}
