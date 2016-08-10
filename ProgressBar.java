import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ProgressBar extends JFrame{
    
    private JProgressBar progress;
    private int min;
    
    public ProgressBar(){
        super("Machine Projectasdksadm");
        
        progress = new JProgressBar(0, 100);
        progress.setBounds(40, 40, 200, 30);
        progress.setValue(min);
        progress.setStringPainted(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(270, 150);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        p.add(progress);
        add(p);
    }
    
    public void progression(){
        for(min = 0; min <= 100; min++){
            progress.setValue(min);
            
            try{Thread.sleep(150);}catch(Exception e){}
        }
    }
    
    public int getMinimum(){return min;}
}