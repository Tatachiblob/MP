public class Driver {
    public static void main(String[] args) {
        EnrollmentSystem e = new EnrollmentSystem();
        System.out.println(e.RegisterStudentAccount("11512709", "Komoro9!", "Inoue", "Yuta", 0, 0));
        e.login("admin", "dlsu");
        e.RegisterStudentAccount("11512709", "Komoro9!", "Inoue", "Yuta", 0, 0);
        e.RegisterStudentAccount("11451204", "IloveAnime", "Kinoshita", "Aoi", 0, 0);
        e.RegisterStudentAccount("11341591", "Hello World", "Saito", "Takao", 0, 0);
        
        e.addCourse("ARCH-OS", "Computer Architecture", 3);
        e.addCourse("INTPRG1", "Programming 1", 2);
        e.addCourse("INTPRG2", "Programming 2", 2);
        
        e.openSection("ARCH-OS", "S14", "Roger Uy", "MW", "222:00", "18:00", 20);
        e.openSection("ARCH-OS", "S14", "Roger Uy", "MW", "22:00", "18:00", 20);
        e.openSection("INTPRG1", "S14", "Lance Alcabasa", "MW", "16:00", "18:00", 20);
        
        e.display();
        e.logout();
        e.login("115109", "Komoro9!");
        System.out.println(e.enlistSection("INTPRG1", "S14"));
    }
}
