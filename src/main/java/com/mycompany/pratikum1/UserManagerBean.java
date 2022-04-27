/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import com.mycompany.pratikum1.User;
import javax.annotation.PostConstruct;

/**
 *
 * @author cano
 */
@Named(value = "userManagerBean")
@SessionScoped
public class UserManagerBean implements Serializable {

    private ArrayList<User> userList;
    
    // Will be moved to the DB
    User admin = new User("admin", "secret");
    
    
    public UserManagerBean() {
    }
    
    @PostConstruct
    public void init() {
        userList.add(admin);
    }
    
    public User getUser(String username) {
        for (User u : userList) {
            if (u.getSurname().equals(username)) {
                return u;
            }
        }
        return new User();
    }
    
    public boolean addUser() {
        
    }
    
}
