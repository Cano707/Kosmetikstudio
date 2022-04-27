/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import com.mycompany.pratikum1.User;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author cano
 */
@ManagedBean(name = "userManagerBean", eager=true)
@SessionScoped
public class UserManagerBean implements Serializable {

    private ArrayList<User> userList;
    
    
    public UserManagerBean() {
    }
    
    @PostConstruct
    public void init() {
        // Will be moved to the DB
        userList = new ArrayList<>();
        User admin = new User("admin", "secret");
        userList.add(admin);
    }
    
    public User getUser(String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return new User();
    }
    
    public void addUser(User u) {
        userList.add(u);
    }
    
}
