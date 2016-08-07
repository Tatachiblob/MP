import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterGUI extends JFrame implements ActionListener{
    
    private JLabel lblUser, lblPassword, lblFirst, lblLast, lblMin, lblMax;
    private JTextField textUser, textFirst, textLast, textMin, textMax;
    private JPasswordField textPassword;
    private JButton register;
    private String username, password, firstName, lastName;
    private double minUnits, maxUnits;
    
    public RegisterGUI(){
        super("Machine Project");
        
        this.lblUser = new JLabel("Username: ");
        this.lblPassword = new JLabel("Password: ");
        this.lblFirst = new JLabel("First Name: ");
        this.lblLast = new JLabel("Last Name: ");
        this.lblMin = new JLabel("Minimum Units: ");
        this.lblMax = new JLabel("Maximum Units: ");
        this.textUser = new JTextField();
        textUser.setColumns(20);
        this.textPassword = new JPasswordField();
        textPassword.setColumns(20);
        this.textFirst = new JTextField();
        textFirst.setColumns(20);
        this.textLast = new JTextField();
        textLast.setColumns(20);
        this.textMin = new JTextField();
        textMin.setColumns(5);
        this.textMax = new JTextField();
        textMax.setColumns(5);
        this.register = new JButton("Register Student!!");
        register.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(700,350);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblUser, con);
        
        con.gridx = 1;
        p.add(this.textUser, con);
        
        con.gridx = 0;
        con.gridy = 1;
        p.add(this.lblPassword, con);
        
        con.gridx = 1;
        p.add(this.textPassword, con);
        
        con.gridx = 0;
        con.gridy = 2;
        p.add(this.lblFirst, con);
        
        con.gridx = 1;
        p.add(this.textFirst, con);
        
        con.gridx = 0;
        con.gridy = 3;
        p.add(this.lblLast, con);
        
        con.gridx = 1;
        p.add(this.textLast, con);
        
        con.gridx = 0;
        con.gridy = 4;
        p.add(this.lblMin, con);
        
        con.gridx = 1;
        p.add(this.textMin, con);
        
        con.gridx = 0;
        con.gridy = 5;
        p.add(this.lblMax, con);
        
        con.gridx = 1;
        p.add(this.textMax, con);
        
        con.gridx = 0;
        con.gridy = 6;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(register, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student Register Panel"));
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals(register.getText())){
            b = (JButton)e.getSource();
            this.username = textUser.getText();
            this.password = textPassword.getText();
            this.firstName = textFirst.getText();
            this.lastName = textLast.getText();
            this.maxUnits = Double.parseDouble(textMax.getText());
            this.minUnits = Double.parseDouble(textMin.getText());
        }
        //System.out.println("Username: " + username);
        //System.out.println("Password: " + password);
        //System.out.println("First Name: " + fisrtName);
        //System.out.println("Last Name: " + lastName);
        //System.out.println("Minimum Units: " + minUnits);
        //System.out.println("Maximum Units: " + maxUnits);
    }
    
    public static void main(String[] args){
        RegisterGUI a = new RegisterGUI();
        
    }
    
}
