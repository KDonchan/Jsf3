/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.User;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author donch
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String userId,userPass,userName,userKana;
    boolean editFlg;
    //private List<User> users;
    private String errMsg;//エラーメッセージ
    @Inject private Jsf3Bean jsf3Bean;
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        editFlg = false;
    }
    
    public boolean isEditFlg() {
        return editFlg;
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

    public String getErrMsg() {
        return errMsg;
    }
    

 
    public String loginNext(){
        String nextPage="user";
        return nextPage;
    }

    private void userAllClear(){
        userClear2();
        userId = null;
    }
    
    private void userClear2(){
        userKana = userName = userPass = null;
    }
    
    public String userAdd(){
        String nextPage="userAdd";
        User wUser = new  User();
        wUser.setUserId(userId);
        wUser.setUserPassword(userPass);
        wUser.setUserName(userName);
        wUser.setUserKana(userKana);
        jsf3Bean.userAdd(wUser);
        userAllClear();
        editFlg=false;
        return nextPage;
    }
    
    public List<User> userAll(){
        return jsf3Bean.getUsers();
    }

    //メンバー変数userIDに重複検索するIDをセットしてコール
    //userIdが登録済みの場合はリターン値：true
    private boolean userIdFind(){
        boolean flg=false;
        for(User findUser : jsf3Bean.getUsers())
            if(findUser.getUserId().equals(userId))
                flg = true;
        return flg;
    }
    
    //検索したいuserIdをメンバー変数userIdにセットしてコール
    //ユーザが登録されていた場合はメンバー変数に見つかったユーザ情報をセットする。
    private boolean userFind(){
        boolean flg=false;
        for(User findUser : jsf3Bean.getUsers())
            if(findUser.getUserId().equals(userId)){
                flg= true;
                userName = findUser.getUserName();
                userPass = findUser.getUserPassword();
                userKana = findUser.getUserKana();
            }
        return flg;
    }
    
    public String userFindNext(){
        String nextPage=null;
        User wUser = null;
        errMsg=null;
        if(userFind())
            nextPage="user";
        else //5月14日　IDが見つからない時の処理追加
            errMsg=userId + "は見つかりませんでした";
        return nextPage;
    }
    
    public void idDupCheck(){
        errMsg="";
        if(userIdFind()){
            editFlg = false;
            errMsg += "登録済みIDです";         
        }else{
            editFlg=true;
        }
    }
}
