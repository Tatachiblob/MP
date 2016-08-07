import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudentMenuGUI extends JFrame implements ActionListener{
    
    private JComboBox<String> comboOptions;
    private JButton select;
    private String option;
    
    public StudentMenuGUI(){
        super("Machine Project");
        this.comboOptions = new JComboBox<>();
        this.select = new JButton("Select");
        select.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        initScreen();
        setSize(400,200);
        setVisible(true);
    }
    
    public void initScreen(){
        comboOptions.addItem("Enlist in Section");
        comboOptions.addItem("Remove Enlistment");
        comboOptions.addItem("Enroll");
        comboOptions.addItem("View Enrolment Assessment Form");
        comboOptions.addItem("Log Out");
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        JPanel p = new JPanel(new FlowLayout());
        p.add(comboOptions);
        p.add(select);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student Menu"));
        
        add(p, con);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public static void main(String[] args) {
        StudentMenuGUI a = new StudentMenuGUI();
    }
}
