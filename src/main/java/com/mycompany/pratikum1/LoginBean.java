/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author cano
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
    private List<User> userList;
    private String username;
    private String password;
    
    @Inject
    private UserManagerBean userMng;

    @Inject
    private SessionBean session;
    
    @Inject
    private PasswordHashConverter phc;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: LoginBean");
        userList = userMng.getUserList();
    }
    
    public void login() {
        FacesContext cxt = FacesContext.getCurrentInstance();
        for(User u : userList) {
            if(u.getUsername().equals(username) && u.getPassword().equals(phc.getPwdHash(password))) {
                session.setLoggedIn(true);
                try {
                    cxt.getExternalContext().redirect("index.xhtml");
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void logout() {
        FacesContext cxt = FacesContext.getCurrentInstance();
        session.setLoggedIn(false);
        try{
            cxt.getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
