/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mac
 */
public class Offer {
    
    private List<MenuItems> items;
    private int discountPercent;
    private String description;

    public Offer(List<MenuItems> items, int discountPercent, String description) {
        this.items = items;
        this.discountPercent = discountPercent;
        this.description = description;
    }

    
    /*
    public void addItem(MenuItems item){
        this.items.add(item);
    }*/
    
    public List<MenuItems> getItems() {
        return items;
    }

    public void setItems(List<MenuItems> items) {
        this.items = items;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Method to offer a discount on a specific item
    public void offerOnItem(MenuItems item, int offer_percent) {
        item.offer(offer_percent);
    }
    
    
    // offer of a bundle as 3 burgers 2 sodas and prints the total price
    public void printOfferBundle(List<MenuItems> items, int offer_percent) {
        // Apply the offer percentage to each item
        for (MenuItems item : items) {
            item.offer(offer_percent);
        }
        
        // Calculate the total price of the bundle
        double totalPrice = calculateTotalPrice(items);
        
        // Print the details of each item
        System.out.println("Offer Bundle:");
        for (MenuItems item : items) {
            System.out.println("- " + item.getName() + " (Price after offer: $" + item.getPrice() + ")");
        }
        
        // Print the total price after applying the offer
        System.out.println("Total Price after Offer: $" + totalPrice);
    }
    
    
    private double calculateTotalPrice(List<MenuItems> items) {
        double totalPrice = 0;
        for (MenuItems item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}







/*
    private double price_after_offer(){
        double totalPrice = 0;
        for (MenuItems item : items) {
            item.offer(discountPercent);
            totalPrice += item.getPrice();
        }
        double discountAmount = totalPrice * (discountPercent / 100.0);
        return totalPrice - discountAmount;
    }*/

 // Method to offer a discount on a specific category of items
    

    // Helper method to apply offer to a list of items
    /*private void applyOfferToCategory(List<MenuItems> categoryItems, int offer_percent) {
        for (MenuItems item : categoryItems) {
            item.offer(offer_percent);
        }
    }*/
 /*public void offerOnCategory(String category, int offer_percent) {
        switch (category.toLowerCase()) {
            case "main dishes":
                applyOfferToCategory(items, offer_percent);
                break;
            case "desserts":
                applyOfferToCategory(items, offer_percent);
                break;
            case "drinks":
                applyOfferToCategory(items, offer_percent);
                break;
            case "appetizers":
                applyOfferToCategory(items, offer_percent);
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }*/
    /*public void applyOffer() {
        for (MenuItems item : items) {
            item.offer(discountPercent);
        }
    }*/
    
    /*
    @Override
    public void offer(int offer_percent) {
        setPrice(getPrice() - offer_percent);
    }
    */
