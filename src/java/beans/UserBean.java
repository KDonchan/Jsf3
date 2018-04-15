/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author donch
 */
@Named(value = "userBean")
@RequestScoped
public class UserBean {
    private String userId;
    private String userPass;
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
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
}
