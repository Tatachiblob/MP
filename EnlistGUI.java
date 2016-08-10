import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnlistGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblSection, lblCourse;
    private JComboBox<Section> sectionBox; 
    private JComboBox<Course> courseBox;
    private JButton bEnlist;
    
    public EnlistGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.lblSection = new JLabel("Section: ");
        this.lblCourse = new JLabel("Course: ");
        this.sectionBox = new JComboBox<>(es.getSectionsVector());
        this.courseBox = new JComboBox<>(es.getCoursesVector());
        this.bEnlist = new JButton("Enlsit Section!");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(300,250);
        setVisible(true);
    }
    
    public void initScreen(){
        
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblCourse, con);
        con.gridx = 1;
        p.add(courseBox, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p.add(lblSection, con);
        con.gridx = 1;
        p.add(sectionBox, con);
        
        con.gridx = 0;
        con.gridy = 2;
        con.anchor = GridBagConstraints.CENTER;
        con.gridwidth = 2;
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enlistment Panel"));
        
        p.add(bEnlist, con);
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        Course c;
        Section s;
        if(e.getActionCommand().equals("Enlist Section!")){
            b = (JButton)e.getSource();
            c = (Course)courseBox.getSelectedItem();
            s = (Section)sectionBox.getSelectedItem();
            es.enlistSection(c, s);
        }
    }
    
    public static void main(String[] args){
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
        Course c5 = new Course("FTDANCE", "Danceing PE", 4);
        Section sec = new Section("S12", "Shirely Chu", "MW", "9:00", "10:45", 12);
        Section sec2 = new Section("S13", "Shirely Chu", "MW", "11:00", "12:30", 12);
        Section sec3 = new Section("A23", "Joanna Go", "TH", "7:30", "9:30", 12);
        Section sec4 = new Section("A24", "Joanna Go", "MW", "10:00", "12:00", 12);
        Section sec5 = new Section("S12", "Alcantara Harlod", "MW", "1:00", "2:45", 12);
        Section sec6 = new Section("S13", "Alcantara Harlod", "TH", "3:00", "4:45", 12);
        Section sec7 = new Section("S14", "Roger Uy", "MW", "2:00", "3:45", 12);
        Section sec8 = new Section("S12", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec9 = new Section("S16", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec10 = new Section("EQ1", "Sir? Valdez", "TH", "4:00", "5:45", 12);
        Account as = new Account("admin", "DLSU");
        
        e.login(as);
        e.RegisterStudentAccount(s);
        e.addCourse(c);
        e.addCourse(c2);
        e.addCourse(c3);
        e.addCourse(c4);
        e.addCourse(c5);
        e.openSection(c, sec);
        e.openSection(c, sec2);
        e.openSection(c2, sec3);
        e.openSection(c2, sec4);
        e.openSection(c3, sec5);
        e.openSection(c3, sec6);
        e.openSection(c4, sec7);
        e.openSection(c4, sec8);
        e.openSection(c5, sec9);
        e.openSection(c5, sec10);
        
        e.logout();
        as = new Account("11512709", "MyPassword!");
        e.login(as);
        
        EnlistGUI a = new EnlistGUI(e);
    }
}
