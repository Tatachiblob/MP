import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EditStudentGUI extends JFrame implements ActionListener{
    
    private JLabel lblUsername, lblFirstName, lblLastName;
    private JTextField textUsername, textFirstName, textLastName;
    private JButton edit;
    private String username, firstName, lastName;
    
    public EditStudentGUI(){
        super("Machine Project");
        
        lblUsername = new JLabel("Username: ");
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
        p.add(textUsername, con);
        
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
        
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals(edit.getText())){
            b = (JButton)e.getSource();
            this.username = textUsername.getText();
            this.firstName = textFirstName.getText();
            this.lastName = textLastName.getText();
        }
    }
    
    public static void main(String[] args){
        EditStudentGUI a = new EditStudentGUI();
    }
}
