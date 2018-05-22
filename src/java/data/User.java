/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author donch
 */
public class User {
    private String userId,userPassword,userName,userKana;
    private boolean editFlg;

    public User() {
        editFlg=false;
    }

    public boolean isEditFlg() {
        return editFlg;
    }

    public void setEditFlg(boolean editFlg) {
        this.editFlg = editFlg;
    }
    
   

    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    
 
}
