import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnrollGUI extends JFrame implements ActionListener{
    
    private JButton ok;
    private JButton cancel;
    
    public EnrollGUI(){
        super("Machine Project");
        
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
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public static void main(String[] args){
        EnrollGUI a = new EnrollGUI();
    }
}
