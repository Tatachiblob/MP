//Inoue, Yuta   Salva, Trisha
public class Account {
    
    private String userName;
    private String password;
    
    public Account(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName(){return userName;}
    public boolean equal(Account a){
        return this.userName.equals(a.userName) && this.password.equals(a.password);
    }
    
}//Base of Student account and Admin account
