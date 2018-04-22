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
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author donch
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String userId,userPass,userName,userKana;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserKana() {
        return userKana;
    }

    public void setUserKana(String userKana) {
        this.userKana = userKana;
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
        wUser.setUserName(userName);
        users.add(wUser);
        return nextPage;
    }
    
    public List<User> userAll(){
        return users;
    }
    
    public String findUser(String wId){
        String nextPage=null;
        User wUser = null;
        for(User findUser:users){
            if(findUser.getUserId().equals(wId))
            {
                wUser = findUser;
                userPass= wUser.getUserPassword();
                userName = wUser.getUserName();
                userKana = wUser.getUserKana();
                nextPage="user";
            }
        }
        return nextPage;
    }
}
