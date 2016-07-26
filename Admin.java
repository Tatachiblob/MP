//Inoue, Yuta   Salva, Trisha
public class Admin extends Account {
    
    private boolean isLogIn;
    
    public Admin(){
        super("admin", "dlsu");
        this.isLogIn = false;
    }
    
    public boolean getIsLogIn(){return isLogIn;}
    public void setIsLogIn(boolean b){
        this.isLogIn = b;
    }
}
