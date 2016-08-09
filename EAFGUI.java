import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class EAFGUI extends JFrame{
    
    private EnrollmentSystem es;
    private JLabel lblName, lblID;//, lblCode, lblCourse, lblSection, lblFaculty, lblSched,lblUnit,lblTotalUnit;
    private JLabel lblFormat;
    private JLabel[] lblSubjects;
    private JButton ok;
    
    public EAFGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.lblFormat = new JLabel();
        this.lblName = new JLabel("NAME: " + es.getCurrentStudent().getFullName());
        this.lblID = new JLabel("ID NUMBER: " + es.getCurrentStudent().getUserName());
        this.lblSubjects = new JLabel[es.getCurrentStudent().getEnrolls().size()];
        for(JLabel a : lblSubjects){
            a = new JLabel();
        }
        /*
        this.lblCode = new JLabel("CODE");
        this.lblCourse = new JLabel("COURSE NAME");
        this.lblSection = new JLabel("SECTION");
        this.lblFaculty = new JLabel("TEACHER");
        this.lblSched = new JLabel("SCHEDULE");
        this.lblUnit = new JLabel("UNITS");
        this.lblTotalUnit = new JLabel("TOTAL UNITS");
        */
        this.ok = new JButton("Ok");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(700,400);
        setVisible(true);
    }
    
    public void initScreen(){
        ArrayList<Section> sections = es.getCurrentStudent().getEnrolls();
        String FORMAT = "%-10s %-30s %-10s %-30s %-20s %-5s";
        String s = String.format(FORMAT,"CODE", "COURSE", "SECTION", "TEACHER", "SCHEDULE", "UNITS");
        lblFormat.setText(s);
        
        
        for(int i = 0; i < lblSubjects.length; i++){
            s = String.format(FORMAT, sections.get(i).getCourse().getCode(), 
                    sections.get(i).getCourse().getName(), sections.get(i).getSectionName(), 
                    sections.get(i).getFaculty(), 
                    sections.get(i).getWholeSchedule(),
                    Double.toString(sections.get(i).getCourse().getUnits()));
            lblSubjects[i] = new JLabel(s);
        }
        
        JPanel p1 = new JPanel(new GridBagLayout());
        GridBagConstraints con1 = new GridBagConstraints();
        con1.anchor = GridBagConstraints.WEST;
        con1.insets = new Insets(10, 10, 10, 10);
        
        con1.gridx = 0;
        con1.gridy = 0;
        p1.add(lblName, con1);
        
        con1.gridy = 1;
        p1.add(lblID, con1);
        
        con1.gridy = 2;
        p1.add(lblFormat, con1);
        
        JPanel p2 = new JPanel(new GridBagLayout());
        GridBagConstraints con2 = new GridBagConstraints();
        con2.anchor = GridBagConstraints.WEST;
        con2.insets = new Insets(10, 10, 10, 10);
        
        int i = 0;
        int y = 0;
        do{
            con2.gridy = y;
            p2.add(lblSubjects[i], con2);
            i++;
            y++;
        }while(i < lblSubjects.length);
        
        con1.gridy = 3;
        p1.add(p2, con1);
        
        add(p1);
        /*
        JPanel p1 = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel whole = new JPanel(new GridBagLayout());
        GridBagConstraints con1 = new GridBagConstraints();
        GridBagConstraints con2 = new GridBagConstraints();
        GridBagConstraints entire = new GridBagConstraints();
        con1.anchor = GridBagConstraints.WEST;
        con2.anchor = GridBagConstraints.WEST;
        entire.anchor = GridBagConstraints.WEST;
        con1.insets = new Insets(10, 10, 10, 10);
        con2.insets = new Insets(10, 10, 10, 10);
        entire.insets = new Insets(10, 10, 10, 10);
        
        con1.gridx = 0;
        con1.gridy = 0;
        p1.add(lblName, con1);
        
        con1.gridy = 1;
        p1.add(lblID, con1);
        
        entire.gridx = 0;
        entire.gridy = 0;
        whole.add(p1, entire);
        
        con2.gridx = 0;
        con2.gridy = 0;
        p2.add(lblCode, con2);
        con2.gridx = 1;
        p2.add(lblCourse, con2);
        con2.gridx = 2;
        p2.add(lblSection, con2);
        con2.gridx = 3;
        p2.add(lblSched, con2);
        con2.gridx = 4;
        p2.add(lblFaculty, con2);
        con2.gridx = 5;
        p2.add(lblUnit, con2);
        
        con2.gridx = 0;
        con2.gridy = 1;
        p2.add(new JLabel("INTPRG2"), con2);
        
        con2.gridx = 1;
        p2.add(new JLabel("OBJECT-BASED PROGRAMMING IN JAVA"), con2);
        
        con2.gridx = 2;
        p2.add(new JLabel("S15"), con2);
        
        con2.gridx = 3;
        p2.add(new JLabel("CHU, SHIRLEY"), con2);
        
        con2.gridx = 4;
        p2.add(new JLabel("MW 9:15 - 10:45"), con2);
        
        con2.gridx = 5;
        p2.add(new JLabel("3.0"), con2);
        
        con2.gridx = 0;
        con2.gridy = 6;
        p2.add(lblTotalUnit, con2);
        con2.gridx = 5;
        p2.add(new JLabel("3.0"), con2);
        
        entire.gridy = 1;
        whole.add(p2, entire);
        
        
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "View EAF Panel"));
        
        add(whole);*/
    }
    
    public static void main(String[] args){
        EnrollmentSystem es = new EnrollmentSystem();
        Account account = new Account("admin", "DLSU");
        Student yuta = new Student("11512709", "Komoro9!", "Inoue", "Yuta", 0, 20);
        
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
        
        es.login(account);
        
        es.RegisterStudentAccount(yuta);
        es.addCourse(c);
        es.addCourse(c2);
        es.addCourse(c3);
        es.addCourse(c4);
        es.addCourse(c5);
        es.openSection(c, sec);
        es.openSection(c, sec2);
        es.openSection(c2, sec3);
        es.openSection(c2, sec4);
        es.openSection(c3, sec5);
        es.openSection(c3, sec6);
        es.openSection(c4, sec7);
        es.openSection(c4, sec8);
        es.openSection(c5, sec10);
        
        es.logout();
        
        account = new Account("11512709", "Komoro9!");
        es.login(account);
        es.enlistSection(c, sec2);
        es.enlistSection(c2, sec3);
        es.enlistSection(c3, sec5);
        es.enlistSection(c4, sec8);
        es.enroll();
        
        EAFGUI a = new EAFGUI(es);
    }
}
