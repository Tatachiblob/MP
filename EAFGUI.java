import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class EAFGUI extends JFrame{
    
    //private Student student;
    private JLabel lblName, lblID, lblCode, lblCourse, lblSection, lblFaculty, lblSched,lblUnit,lblTotalUnit;
    //private ArrayList<JTextField> contents;
    private JButton ok;
    
    public EAFGUI(/*Student s*/){
        super("Machine Project");
        
        this.lblName = new JLabel("NAME: INOUE, YUTA" /*+ s.getLastName + "," + s.getFirstName*/);
        this.lblID = new JLabel("ID NUMBER: 11512709" /*+ s.getUsername*/);
        this.lblCode = new JLabel("CODE");
        this.lblCourse = new JLabel("COURSE NAME");
        this.lblSection = new JLabel("SECTION");
        this.lblFaculty = new JLabel("TEACHER");
        this.lblSched = new JLabel("SCHEDULE");
        this.lblUnit = new JLabel("UNITS");
        this.lblTotalUnit = new JLabel("TOTAL UNITS");
        //this.contents = new ArrayList<>();
        this.ok = new JButton("Ok");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(700,400);
        setVisible(true);
    }
    
    public void initScreen(){
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
        
        add(whole);
    }
    
    public static void main(String[] args){
        EAFGUI a = new EAFGUI();
    }
}
