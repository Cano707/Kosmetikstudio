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
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cano
 */
@Named(value = "userManagerBean")
@SessionScoped
public class UserManagerBean implements Serializable {

    private List<User> userList;
    private static int uid = 0;
    
    @Inject
    private PasswordHashConverter phc;
    
    public UserManagerBean() {
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    @PostConstruct
    public void init() {
        // Will be moved to the DB
        userList = new ArrayList<>();
        User admin = new User(getUid(), "", "", "", "admin@mail.com", "" ,"admin", phc.getPwdHash("secret"));
        User user = new User(getUid() ,"", "", "", "admin@mail.com", "" ,"cano", phc.getPwdHash("secret"));
        userList.add(admin);
        userList.add(user);
    }
    
    public Map getUser(String username) {
        Map<String, Object> map = new HashMap();
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                for(Field field : User.class.getDeclaredFields()){
                    if(!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    try {
                        map.put(field.getName(), field.get(u));
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(UserManagerBean.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(UserManagerBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
        return map;
    }
    
    public void addUser(User u) {
        userList.add(u);
    }
    
    public List getUserList() {
        return this.userList;
    }
    
    public static int getUid() {
        return ++uid;
    }

    public static void setUid(int uid) {
        UserManagerBean.uid = uid;
    }
    
}
