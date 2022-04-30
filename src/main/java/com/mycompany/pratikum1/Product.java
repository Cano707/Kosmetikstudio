/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pratikum1;

/**
 *
 * @author cano
 */
public class Product {
    private String name;
    private String description;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public Product(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
