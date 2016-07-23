public class Account {
    
    private String user_name;
    private String password;
    
    public Account(String user_name, String password){
        this.user_name = user_name;
        this.password = password;
    }
    
    public String getUserName(){return user_name;}
    
}//Base of Student account and Admin account
