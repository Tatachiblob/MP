import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RemoveEnlistGUI extends JFrame implements ActionListener{
    
    private EnrollmentSystem es;
    private JLabel lblSection;
    private JComboBox<Section> sectionList;
    private JTextArea txtInformation;
    private JButton bRemove, bSelecct, bCancel;
    
    public RemoveEnlistGUI(EnrollmentSystem es){
        super("Machine Project");
        
        this.es = es;
        this.lblSection = new JLabel("Section: ");
        this.sectionList = new JComboBox<>(es.getCurrentStudent().getEnlistedSectionsVector());
        this.txtInformation = new JTextArea();
        this.bRemove = new JButton("Remove Enlistment!");
        bRemove.addActionListener(this);
        this.bSelecct = new JButton("Select!");
        bSelecct.addActionListener(this);
        this.bCancel = new JButton("Cancel Action");
        bCancel.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initScreen();
        setSize(400,350);
        setVisible(true);
    }
    
    public void initScreen(){
        JPanel p = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());
        JPanel whole = new JPanel(new BorderLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(10, 10, 10, 10);
        
        con.gridx = 0;
        con.gridy = 0;
        p.add(lblSection, con);
        con.gridx = 1;
        p.add(sectionList, con);
        con.gridx = 2;
        p.add(bSelecct, con);
        
        whole.add(p, BorderLayout.NORTH);
        
        //information about the Section selected
        con.gridx = 0;
        con.gridy = 1;
        p2.add(txtInformation, con);
        whole.add(p2, BorderLayout.CENTER);
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Infromation Panel"));
        
        whole.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Remove Enlistment Panel"));
        
        con.gridx = 0;
        con.gridy = 0;
        p3.add(bRemove, con);
        con.gridx = 1;
        p3.add(bCancel, con);
        
        whole.add(p3, BorderLayout.SOUTH);
        add(whole);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Select!")){
            Section s = (Section)sectionList.getSelectedItem();
            txtInformation.setText(s.getInfo());
            System.out.println(s.getInfo());
        }
        if(e.getActionCommand().equals("Remove Enlistment!")){
            Course c;
            Section s;
            s = (Section)sectionList.getSelectedItem();
            es.removeEnlistment(s);
            
        }
        if(e.getActionCommand().equals("Cancel")){
            this.dispose();
        }
    }
    
    public static void main(String[] argss){
        EnrollmentSystem e = new EnrollmentSystem();
        Student s = new Student("11512709", "MyPassword!", "Inoue", "Yuta", 10, 30);
        Student s2 = new Student("1112342", "0317", "Gabriel", "Santa", 10, 30);
        Student s3 = new Student("11421329", "YourMom", "Salva", "Trisha", 10, 30);
        Student s4 = new Student("11249237", "Happy", "Pilapil", "Ela", 10, 30);
        Student s5 = new Student("11723164", "Kevin", "Uy", "Alec", 10, 30);
        
        Course c = new Course("INTPRG2", "Programming 2", 2);
        Course c2 = new Course("ENGLCOM", "English Communication", 3);
        Course c3 = new Course("ITMATH3", "Math for IT", 2);
        Course c4 = new Course("ARCH-OS", "Computer Architecture", 4);
        Course c5 = new Course("FTDANCE", "Danceing PE", 4);
        Section sec = new Section("S12", "Shirely Chu", "MW", "9:00", "10:45", 12);
        Section sec2 = new Section("S13", "Shirely Chu", "MW", "11:00", "12:30", 12);
        Section sec3 = new Section("A23", "Joanna Go", "TH", "7:30", "9:30", 12);
        Section sec4 = new Section("A24", "Joanna Go", "MW", "10:00", "12:00", 12);
        Section sec5 = new Section("S12", "Alcantara Harlod", "MW", "1:00", "2:45", 12);
        Section sec6 = new Section("S13", "Alcantara Harlod", "TH", "3:00", "4:45", 12);
        Section sec7 = new Section("S14", "Roger Uy", "MW", "2:00", "3:45", 12);
        Section sec8 = new Section("S12", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec9 = new Section("S16", "Roger Uy", "MW", "4:00", "5:45", 12);
        Section sec10 = new Section("EQ1", "Sir? Valdez", "TH", "4:00", "5:45", 12);
        Account as = new Account("admin", "DLSU");
        
        e.login(as);
        e.RegisterStudentAccount(s);
        e.addCourse(c);
        e.addCourse(c2);
        e.addCourse(c3);
        e.addCourse(c4);
        e.addCourse(c5);
        e.openSection(c, sec);
        e.openSection(c, sec2);
        e.openSection(c2, sec3);
        e.openSection(c2, sec4);
        e.openSection(c3, sec5);
        e.openSection(c3, sec6);
        e.openSection(c4, sec7);
        e.openSection(c4, sec8);
        e.openSection(c5, sec9);
        e.openSection(c5, sec10);
        
        e.logout();
        as = new Account("11512709", "MyPassword!");
        e.login(as);
        e.enlistSection(c, sec);
        e.enlistSection(c2, sec3);
        e.enlistSection(c3, sec5);
        e.enlistSection(c4, sec7);
        e.enlistSection(c5, sec9);
        RemoveEnlistGUI a = new RemoveEnlistGUI(e);
    }
}
