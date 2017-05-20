package djj.login.bean;

import sun.rmi.runtime.Log;

/**
 * Created by mesmers on 2017/4/16.
 */
public class Login {

    private int id;
    private String userName;
    private String password;

    public Login(){

    }

    public Login(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
