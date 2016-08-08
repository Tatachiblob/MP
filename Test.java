import java.util.Scanner;
public class Test {
    static EnrollmentSystem e = new EnrollmentSystem();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userLog, passLog, s;
        String a, b, c;
        boolean logMenu, adminMenu, studentMenu;
        
        System.out.println("Machine Project Driver");
        logMenu = true;
        
        while(logMenu){
            adminMenu = true;
            studentMenu = true;
            System.out.print("\nLogin: ");
            userLog = sc.next();
            if(userLog.equalsIgnoreCase("Cancel"))
                logMenu = false;
            System.out.print("Password: ");
            passLog = sc.next();
            if(e.login(userLog, passLog)){
                if(e.getAdmin().getIsLogin()){
                    while(adminMenu){
                        System.out.println("");
                        adminMenu();
                        s = sc.next();
                        if(s.matches("[1-5]")){
                            switch(s){
                                case "1":
                                    if(e.RegisterStudentAccount(RegisterStudentMenu()))
                                        System.out.println("Register Complete");
                                    else
                                        System.out.println("Error!!");
                                    
                                    break;
                                    
                                case "2": 
                                    System.out.print("Search ID: ");
                                    a = sc.next();
                                    System.out.print("Change Last Name: ");
                                    b = sc.next();
                                    System.out.print("Change First Name: ");
                                    c = sc.next();
                                    if(e.editStudent(a, c, b))
                                        System.out.println("Edit Student Complete");
                                    else
                                        System.out.println("Error!!");
                                    break;
                                    
                                case "3": 
                                    if(e.addCourse(addCourse()))
                                        System.out.println("Added Course");
                                    else
                                        System.out.println("Error!!");
                                    break;
                                    
                                case "4": 
                                    
                                    break;
                                    
                                case "5": 
                                    break;
                                    
                            }
                        }
                        else if(s.matches("6")){
                            System.out.println("\nLOGGING OUT");
                            adminMenu = false;
                            e.logout();
                        }
                        else
                            System.out.println("INVALID CHOICE\n");
                    }//while for the menu
                }//admin menu
                else{
                    
                }//student menu
            }
            else
                System.out.println("Error!!");
        }//while for Logging in
        
    }
    
    public static void adminMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Register Student Account"); 
        System.out.println("2. Edit Student Account"); 
        System.out.println("3. Add Course"); 
        System.out.println("4. Open Section"); 
        System.out.println("5. View Class List"); 
        System.out.println("6. Logout"); 
        System.out.print("Enter Choice: ");
    }
    
    public static Student RegisterStudentMenu(){
        Scanner sc = new Scanner(System.in);
        String a, b, c, d, e, f;
        System.out.print("Input ID number: ");
        a = sc.next();
        System.out.print("Input Password: ");
        b = sc.next();
        System.out.print("Input Last Name: ");
        c = sc.next();
        System.out.print("Input First Name: ");
        d = sc.next();
        System.out.print("Input Minimum Units: ");
        e = sc.next();
        System.out.print("Input Maximum Units: ");
        f = sc.next();
        Student s = new Student(a, b, c, d, Double.parseDouble(e), Double.parseDouble(f));
        return s;
    }
    
    public static Course addCourse(){
        Scanner sc = new Scanner(System.in);
        String a, b, c;
        System.out.print("Input Course Code: ");
        a = sc.next();
        System.out.print("Input Course Name: ");
        b = sc.next();
        System.out.print("Input Course Units: ");
        c = sc.next();
        
        Course q = new Course(a, b, Double.parseDouble(c));
        return q;
    }
    
    public static void openSection(){
        Scanner sc = new Scanner(System.in);
        String a, b, c, d, e, f, g;
        System.out.print("Enter Course: ");
        a = sc.next();
        System.out.print("Enter Section Name: ");
        b = sc.next();
        System.out.print("Enter Faculty: ");
        c = sc.next();
        System.out.print("Enter Schedule: ");
        d = sc.next();
        System.out.print("Enter Start Time: ");
        e = sc.next();
        System.out.print("Enter End Time: ");
        f = sc.next();
        System.out.print("Enter Capacity: ");
        g = sc.next();
        
    }
    
    public static void studentMenu(){
        
    }
}
