import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SuccessMSG extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel error;
    private JButton ok;
    
    public SuccessMSG(EnrollmentSystem es){
        JFrame p = new JFrame();
        JOptionPane.showMessageDialog(p,
        "Success!!",
        "Machine Project",
        JOptionPane.INFORMATION_MESSAGE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.ok = new JButton("OK");
        ok.addActionListener(this);
    }
    /*
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(error, con);
        con.gridx = 1;
        p.add(ok, con);
        
        add(p);
    }*/
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals("OK")){
            this.dispose();
        }
    }
    
}
