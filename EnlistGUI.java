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
        EnlistGUI a = new EnlistGUI(new EnrollmentSystem());
    }
}
