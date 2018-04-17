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
 * @author donch
 */
@Named(value = "jsfBeans")
@ApplicationScoped
public class JsfBeans {
    private List<User> usersList;
    /**
     * Creates a new instance of JsfBeans
     */
    public JsfBeans() {
        usersList = new ArrayList<>();
    }
    
    public void userAdd(User user){
        usersList.add(user);
    }
}
