//Inoue, Yuta   Salva, Trisha
public class Student extends Account {
    
    private String firstName;
    private String lastName;
    
    public Student(String userName, String password, String lastName, String firstName){
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lasName){
        this.lastName = lasName;
    }
    
    public boolean isEqual(Student s){//return true if equal, else not equal
        String myID = this.getUserName();
        String otherID = s.getUserName();
        return myID.equals(otherID);
    }
    
    //for checking
    public void display(){
        System.out.println("ID: " + this.getUserName());
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }
    
}