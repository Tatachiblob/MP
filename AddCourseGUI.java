import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCourseGUI extends JFrame{
    private JLabel lblCode,lblName,lblUnits;
    private JTextField txtCode,txtUnits;
    private JTextField txtName;
    private JButton addCourse;
    public AddCourseGUI(){
        super("Machine Project");
        this.lblCode = new JLabel("Course Code: ");
        this.lblName = new JLabel("Course Name: ");
        this.lblUnits = new JLabel("Course Units: ");
        this.txtCode = new JTextField(25);
        this.txtUnits = new JTextField(10);
        this.txtName = new JTextField(25);
        this.addCourse = new JButton("Add Course");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(500,500);
        setVisible(true);
        
    }
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblCode, con);
        
        con.gridx = 1;
        p.add(txtCode, con);
        
        con.gridx = 0;
        con.gridy = 1;     
        p.add(lblName, con);
         
        con.gridx = 1;
        p.add(txtName, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(this.lblUnits, con);
        
        con.gridx = 1;
        p.add(txtUnits, con);
        
        con.gridx = 0;
        con.gridy = 3;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(addCourse, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Course Panel"));
        p.setBackground(new Color(127,191,127));
        add(p);
    }
    public static void main(String[] args) {
        AddCourseGUI a = new AddCourseGUI();
    }
}
