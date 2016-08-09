import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnrollGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JButton ok;
    private JButton cancel;
    
    public EnrollGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.ok = new JButton("Enroll!!");
        this.cancel = new JButton("Cancel");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(300,200);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridy = 1;
        p.add(ok, con);
        con.gridx = 1;
        p.add(cancel, con);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enroll Panel"));
        add(p);
    }
    
    public void enrollScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(new JLabel("Success in Enrolling"));
        add(p);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals("Enroll!!")){
            b = (JButton)e.getSource();
            if(es.enroll()){
                //I want a success Frame
            }
            else{
                //I want a error Frame
            }
        }
    }
    
    public static void main(String[] args){
        EnrollmentSystem es = new EnrollmentSystem();
        EnrollGUI a = new EnrollGUI(es);
    }
}
