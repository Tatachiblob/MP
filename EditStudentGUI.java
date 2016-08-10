import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EditStudentGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JComboBox<Student> studentCombo;
    private JLabel lblUsername, lblFirstName, lblLastName;
    private JTextField textUsername, textFirstName, textLastName;
    private JButton edit;
    private String firstName, lastName;
    
    public EditStudentGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        lblUsername = new JLabel("Username: ");
        this.studentCombo = new JComboBox<>(es.getStudentsVector());
        lblFirstName = new JLabel("First Name: ");
        lblLastName = new JLabel("Last Name: ");
        textUsername = new JTextField();
        textUsername.setColumns(20);
        textFirstName = new JTextField();
        textFirstName.setColumns(20);
        textLastName = new JTextField();
        textLastName.setColumns(20);
        edit = new JButton("Edit Student");
        edit.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(500,300);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblUsername, con);
        
        con.gridx = 1;
        p.add(studentCombo, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p.add(lblFirstName, con);
        
        con.gridx = 1;
        p.add(textFirstName, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(lblLastName, con);
        
        con.gridx = 1;
        p.add(textLastName, con);
        
        con.gridx = 0;
        con.gridy = 3;
        con.gridwidth = 3;
        con.anchor = GridBagConstraints.CENTER;
        p.add(edit, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Edit Student Panel"));
        p.setBackground(new Color(127,191,127));
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        Student student;
        if(e.getActionCommand().equals(edit.getText())){
            b = (JButton)e.getSource();
            student = (Student)studentCombo.getSelectedItem();
            this.firstName = textFirstName.getText();
            this.lastName = textLastName.getText();
            student.setFirstName(firstName);
            student.setLastName(lastName);
        }
    }
    
    public static void main(String[] args){
        EnrollmentSystem es = new EnrollmentSystem();
        Account as = new Account("admin", "DLSU");
        Student s = new Student("11512709", "MyPassword!", "Inoue", "Yuta", 10, 30);
        Student s2 = new Student("1112342", "0317", "Gabriel", "Santa", 10, 30);
        Student s3 = new Student("11421329", "YourMom", "Salva", "Trisha", 10, 30);
        Student s4 = new Student("11249237", "Happy", "Pilapil", "Ela", 10, 30);
        Student s5 = new Student("11723164", "Kevin", "Uy", "Alec", 10, 30);
        es.login(as);
        es.RegisterStudentAccount(s);
        es.RegisterStudentAccount(s2);
        es.RegisterStudentAccount(s3);
        es.RegisterStudentAccount(s4);
        es.RegisterStudentAccount(s5);
        
        EditStudentGUI a = new EditStudentGUI(es);
    }
}
