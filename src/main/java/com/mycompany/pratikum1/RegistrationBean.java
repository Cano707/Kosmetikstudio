/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
/**
 *
 * @author cano
 */
@Named(value = "registrationBean")
@SessionScoped
public class RegistrationBean implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger(RegistrationBean.class.getName());
    // Alles unnötig - Klasse User benutzen
    private List<User> userList;

    private String salutation;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
    
    @Inject
    private UserManagerBean userMng;
    
    @Inject
    private PasswordHashConverter phc;
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: RegisterBean");
        userList = userMng.getUserList();
    }
    
    public void register(){

        FacesContext cxt = FacesContext.getCurrentInstance();
        User user = new User(UserManagerBean.getUid(), salutation, name, surname, email, phone, username, phc.getPwdHash(password));
        if(userMng.getUserList().isEmpty()) {
            userMng.addUser(user);
        } else {
            boolean ok = true;
            for(User u : userList){
                
                if(u.getUsername().equals(username) || u.getEmail().equals(email)) {
                    ok = false;
                    FacesMessage fm = new FacesMessage("Benutzer existiert bereits!");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage("sticky-key", fm);
                }
            }
            
            if(ok) {
                userList.add(user);
                userMng.setUserList(userList);
                FacesMessage fm = new FacesMessage("Benutzer registriert!");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                cxt.addMessage("registration-form:registration-button", fm);
                LOGGER.info("User signed up");
            }
            
        }
        
    }   
    
 

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
