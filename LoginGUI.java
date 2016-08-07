import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener{
    
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton login;
    private String username, password;
    
    public LoginGUI(){
        super("Machine Project");
        
        this.lblUsername = new JLabel("Username: ");
        this.lblPassword = new JLabel("Password: ");
        this.txtUsername = new JTextField(20);
        this.txtPassword = new JPasswordField(20);
        this.login = new JButton("Login");
        login.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(400,200);
        setVisible(true);
        
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(this.lblUsername, con);
        
        con.gridx = 1;
        p.add(txtUsername, con);
        
        con.gridx = 0;
        con.gridy = 1;     
        p.add(lblPassword, con);
         
        con.gridx = 1;
        p.add(txtPassword, con);
        
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.CENTER;
        p.add(login, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));
        
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals(login.getText())){
            b = (JButton)e.getSource();
            this.username = txtUsername.getText();
            this.password = txtPassword.getText();
        }
        //System.out.println("Username: " + username);
        //System.out.println("Password: " + password);
    }
    
    public static void main(String[] args) {
        LoginGUI a = new LoginGUI();
    }
    
    /*
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("LoginGUI");
     
    public LoginGUI() {
        super("JPanel Demo Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
         
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "LoginGUI Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
    */
}