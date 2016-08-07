import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnlistGUI extends JFrame implements ActionListener{
    
    private JLabel lblSection, lblCourse;
    private JComboBox<String> sectionBox, courseBox;//<Section> and <Course>
    private JButton bEnlist;
    
    public EnlistGUI(){
        super("Machine Project");
        
        this.lblSection = new JLabel("Section: ");
        this.lblCourse = new JLabel("Course: ");
        this.sectionBox = new JComboBox<>();
        this.courseBox = new JComboBox<>();
        this.bEnlist = new JButton("Enlsit Section!");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(300,250);
        setVisible(true);
    }
    
    public void initScreen(){
        sectionBox.addItem("SampleSection 1");
        sectionBox.addItem("SampleSection 2");
        sectionBox.addItem("SampleSection 3");
        courseBox.addItem("SampleCourse 1");
        courseBox.addItem("SampleCourse 2");
        courseBox.addItem("SampleCourse 3");
        
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
        
    }
    
    public static void main(String[] args){
        EnlistGUI a = new EnlistGUI();
    }
}
