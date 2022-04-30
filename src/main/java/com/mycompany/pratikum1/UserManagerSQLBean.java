/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.pratikum1;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import javax.faces.context.SessionMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cano
 */
@Named(value = "userManagerSQLBean")
@SessionScoped
public class UserManagerSQLBean {
    private static final Logger LOGGER = Logger.getLogger(UserManagerBean.class.getCanonicalName());

    /**
     * Creates a new instance of UserManagerSQLBean
     */
    public UserManagerSQLBean() {
    }
    
    public List<User> getUsers() throws ClassNotFoundException, SQLException {
        Connection connect = null;
        String url = "jdbc:mysql://localhost:3306/kosmetikstudio";
        
        String username = "cano";
        String password = ".,mn12!$!YAMAN";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, username);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        List<User> userList = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select * from USERS");
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            User user = new User();
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setSalutation(rs.getString("salutation"));
            user.setPhone(rs.getString("phone"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            
            userList.add(user);
        }
        rs.close();
        pstmt.close();
        connect.close();
        
        return userList;
        
    }
    
    
}
