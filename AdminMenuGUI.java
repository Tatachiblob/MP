import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenuGUI extends JFrame implements ActionListener{
    
    private JComboBox<String> comboOptions;
    private JButton select;
    private String option;
    
    public AdminMenuGUI(){
        super("Machine Project");
        
        this.comboOptions = new JComboBox<>();
        this.select = new JButton("Select");
        select.addActionListener(this);
        select.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        initScreen();
        setSize(400,200);
        setVisible(true);
    }
    
    
    public void initScreen(){
        comboOptions.addItem("Register Student Account");
        comboOptions.addItem("Edit Student Account");
        comboOptions.addItem("Add Course");
        comboOptions.addItem("Open Section");
        comboOptions.addItem("View Class List");
        comboOptions.addItem("Log Out");
        
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        JPanel p = new JPanel(new FlowLayout());
        p.add(comboOptions);
        p.add(select);
        
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ADMIN Panel"));
        
        add(p, con);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton b;
        if(e.getActionCommand().equals(select.getText())){
            this.option = comboOptions.getSelectedItem().toString();
        }
    }
    
    /*
    public void initScreen(){
        JButton register = new JButton("Register Student");
        register.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton edit = new JButton("Edit Student");
        edit.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton add = new JButton("Add Course");
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton open = new JButton("Open Section");
        open.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton view = new JButton("View Class List");
        view.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel contents = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.CENTER;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        contents.add(register, con);
        
        con.gridy = 1;
        contents.add(edit,con);
    
        con.gridy = 2;
        contents.add(add, con);
    
        con.gridy = 3;
        contents.add(open, con);
    
        con.gridy = 4;
        contents.add(view, con);
    
        add(contents);
    
    }
    */
    
    public static void main(String[] args) {
        AdminMenuGUI a = new AdminMenuGUI();
    }
}
