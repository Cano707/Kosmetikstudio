/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cano
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean {
    
    
    // Alles unnötig - Klasse User benutzen

    private String salutation;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String repeatedPassword;
    
    public void register(){
        // Benutzerdaten in die Datenbank schreiben
    }
    

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
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
