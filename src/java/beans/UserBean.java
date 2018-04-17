/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author donch
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String userId;
    private String userPass;
    private List<User> users;
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
 
    public String loginNext(){
        String nextPage="user";
        return nextPage;
    }
    
    public String userAdd(){
        String nextPage="index";
        User wUser = new  User();
        wUser.setUserId(userId);
        wUser.setUserPassword(userPass);
        users.add(wUser);
        return nextPage;
    }
    
    public List<User> userAll(){
        return users;
    }
}
