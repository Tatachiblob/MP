//Inoue, Yuta   Salva Trisha
public class Student extends Account {
    
    private String first_name;
    private String last_name;
    
    public Student(String user_name, String password, String last_name, String first_name){
        super(user_name, password);
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    
    public boolean isEqual(Student s){//return true if equal, else not equal
        String myID = this.getUserName();
        String otherID = s.getUserName();
        return myID.equals(otherID);
    }
    
    //for checking
    public void display(){
        System.out.println("ID: " + this.getUserName());
        System.out.println("First Name: " + first_name);
        System.out.println("Last Name: " + last_name);
    }
    
}
