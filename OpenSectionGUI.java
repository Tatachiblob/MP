import com.sun.scenario.effect.Flood;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OpenSectionGUI extends JFrame{
    
    private JComboBox<String> courseOption;//<Course>
    private JLabel lblSecName, lblFaculty, lblSched, lblStart, lblEnd, lblCaps;
    private JTextField txtSecName, txtFaculty, txtSched, txtStart, txtEnd, txtCaps;
    private JButton select, open;
    
    public OpenSectionGUI(){
        super("Machine Project");
        
        this.courseOption = new JComboBox<>();
        courseOption.addItem("Sample");
        courseOption.addItem("Sample");
        courseOption.addItem("Sample");
        this.lblSecName = new JLabel("Section Name: ");
        this.lblFaculty = new JLabel("Faculty: ");
        this.lblSched = new JLabel("Schedule: ");
        this.lblStart = new JLabel("Start Time: ");
        this.lblEnd = new JLabel("End Time: ");
        this.lblCaps = new JLabel("Capacity: ");
        this.txtSecName = new JTextField();
        txtSecName.setColumns(20);
        this.txtFaculty = new JTextField();
        txtFaculty.setColumns(20);
        this.txtSched = new JTextField();
        txtSched.setColumns(4);
        this.txtStart = new JTextField();
        txtStart.setColumns(6);
        this.txtEnd = new JTextField();
        txtEnd.setColumns(6);
        this.txtCaps = new JTextField();
        txtCaps.setColumns(6);
        this.open = new JButton("Open Section");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        initScreen();
        setSize(500,350);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel();
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(p2, con);
        con.gridx = 1;
        p.add(courseOption, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p.add(lblSecName, con);
        con.gridx = 1;
        p.add(txtSecName, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(lblFaculty, con);
        con.gridx = 1;
        p.add(txtFaculty, con);
        
        con.gridx = 0;
        con.gridy = 3;
        p.add(lblSched, con);
        con.gridx = 1;
        p.add(txtStart, con);
        
        con.gridx = 0;
        con.gridy = 4;
        p.add(lblEnd, con);
        con.gridx = 1;
        p.add(txtEnd, con);
        
        con.gridx = 0;
        con.gridy = 5;
        p.add(lblCaps, con);
        con.gridx = 1;
        p.add(txtCaps, con);
        
        con.gridx = 0;
        con.gridy = 6;
        con.gridwidth = 6;
        con.anchor = GridBagConstraints.CENTER;
        p.add(open, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Open Section Panel"));
        
        add(p);
    }
    
    public static void main(String[] args) {
        OpenSectionGUI a = new OpenSectionGUI();
    }
}
