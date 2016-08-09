import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RemoveEnlistGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblSection, lblCourse;
    private JComboBox<Section> sectionBox; 
    private JComboBox<Course> courseBox;
    private JButton bRemove;
    
    public RemoveEnlistGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.lblSection = new JLabel("Section: ");
        this.lblCourse = new JLabel("Course: ");
        this.sectionBox = new JComboBox<>(es.getSectionsVector());
        this.courseBox = new JComboBox<>(es.getCoursesVector());
        this.bRemove = new JButton("Remove Enlistment!");
        
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
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Remove Enlistment Panel"));
        
        p.add(bRemove, con);
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals("Remove Enlistment")){
            b = (JButton)e.getSource();
            Course c;
            Section s;
            c = (Course)courseBox.getSelectedItem();
            s = (Section)sectionBox.getSelectedItem();
            es.removeEnlistment(c, s);
        }
    }
    
    public static void main(String[] argss){
        EnrollmentSystem es = new EnrollmentSystem();
        RemoveEnlistGUI a = new RemoveEnlistGUI(es);
    }
}
