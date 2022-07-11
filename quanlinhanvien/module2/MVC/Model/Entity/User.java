package quanlinhanvien.module2.MVC.Model.Entity;

public class User {
    private String userName;
    private String password;
    
    public User(){
        
    }

    public User(String userName, String password) {
//        super();
        this.userName = userName;
        this.password = password;
    }
//  ----------------------setter and getter-------------------------------------
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//  ----------------------------------------------------------------------------
}
