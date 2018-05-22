/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author j-knakagami2
 */
@Named(value = "jsf3Bean")
@ApplicationScoped
public class Jsf3Bean {
    private List<User> users;
    /**
     * Creates a new instance of Jsf3Bean
     */
    public Jsf3Bean() {
        users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return users;
    }
    
    public boolean userAdd(User wUser){
        boolean flg = true;
        users.add(wUser);
        return flg;
    }
   public void editEnd(User aUser){
       boolean flg = !aUser.isEditFlg();
        aUser.setEditFlg(flg);
    }    
    
}
