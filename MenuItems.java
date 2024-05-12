/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author mac
 */
abstract public class MenuItems implements Comparable<MenuItems> {
    private String name;
    private double price;
    private String discription;
    //private String type;
    
    
    MenuItems(String name,/*String type,*/ double price, String discription){
        this.name=name;
        this.price=price;
        this.discription=discription;
        //this.type=type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Math.ceil(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    /*
    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    */
    // Method for offering a discount
    public abstract void offer(int offer_percent);

    @Override
    public int compareTo(MenuItems other) {
        return this.name.compareTo(other.name);
    }
    
}
