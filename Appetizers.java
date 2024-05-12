/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author mac
 */
public class Appetizers extends MenuItems implements Supplement{
    

    public Appetizers(String name,double price, String description) {
        super(name, price, description);
    }

    
    
    @Override
    public String getName() {
        return super.getName(); // Calling the superclass method
    }

    @Override
    public void setName(String name) {
        super.setName(name); // Calling the superclass method
    }

    @Override
    public double getPrice() {
        return super.getPrice(); // Calling the superclass method
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price); // Calling the superclass method
    }

    @Override
    public String getDiscription() {
        return super.getDiscription(); // Calling the superclass method
    }

    @Override
    public void setDiscription(String discription) {
        super.setDiscription(discription); // Calling the superclass method
    }

    
    @Override
    public double calculatePrice(boolean alone) {
        if (alone) {
            double newPrice = getPrice() * 1.10; // Increase price by 10%
            setPrice(newPrice); // Update the price using the setter method
            return newPrice; // Return the new price
        } else {
            return getPrice(); // If not alone, return the current price
        }
    }

    @Override
    public void offer(int offer_percent) {
        double discountedPrice = getPrice() * (1 - (offer_percent / 100.0)); // Calculate discounted price
        setPrice(discountedPrice); // Update the price using the setter method
    }
    
}
