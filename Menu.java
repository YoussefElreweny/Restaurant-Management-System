/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Collections;

/**
 *
 * @author mac
 */
public class Menu {
    private List<MenuItems> menuItems;
    private List<Offer> offers;
    
    public Menu() {
        this.menuItems = new ArrayList<>();
        this.offers = new ArrayList<>();
    }

    public void addItem(MenuItems item) {
        menuItems.add(item);
    }
    
    public void removeItem(MenuItems item) {
        menuItems.remove(item);
    }
    
    public void addOffer(Offer offer) {
        offers.add(offer);
    }
    
    public void removeOffer(Offer offer) {
        offers.remove(offer);
    }
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
    
    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("\n");
        displaySection("Main Dishes");
        System.out.println("\n");
        displaySection("Desserts");
        System.out.println("\n");
        displaySection("Drinks");
        System.out.println("\n");
        displaySection("Appetizers");
        System.out.println("\n");
    }
    
    
    private void displaySection(String section) {
    // Remove spaces from the section name
    String sectionWithoutSpaces = section.replaceAll("\\s+", "");
    
    System.out.println(section + ":");
    
    // Filter menu items based on the provided section name
    List<MenuItems> sectionItems = new ArrayList<>();
    for (MenuItems item : menuItems) {
        // Remove spaces from the class name before comparison
        String classNameWithoutSpaces = item.getClass().getSimpleName().replaceAll("\\s+", "");
        
        if (classNameWithoutSpaces.equalsIgnoreCase(sectionWithoutSpaces)) {
            sectionItems.add(item);
        }
    }
    
    Collections.sort(sectionItems);
    
    // Print the sorted items for that section
    for (MenuItems item : sectionItems) {
        System.out.println(item.getName() + " - $" + item.getPrice() + " - " + item.getDiscription());
    }
}
    
    /*
    private void displaySection(String section) {
        System.out.println(section + ":");
        for (MenuItems item : menuItems) {
            if ((item.getClass().getSimpleName().equalsIgnoreCase(section))) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            }
        }
    }*/
    
    
    public void applyOffer(Offer offer) {
        for (MenuItems item : offer.getItems()) {
            for (MenuItems menuItem : menuItems) {
                if (menuItem.getName().equals(item.getName())) {
                    menuItem.offer(offer.getDiscountPercent());
                }
            }
        }
    }
    
    public void displayOffers() {
    if (offers.isEmpty()) {
        System.out.println("No offers available.");
    } else {
        DecimalFormat df = new DecimalFormat("#.##"); // Format prices to two decimal places
        System.out.println("Today's Offers:");
        for (Offer offer : offers) {
            double totalPrice = 0;
            for (MenuItems item : offer.getItems()) {
                totalPrice += item.getPrice();
            }
            double discountedPrice = totalPrice * (1 - (offer.getDiscountPercent() / 100.0)); // Calculate discounted price
            System.out.println("- " + offer.getDescription() + " (Total Price: $" + df.format(discountedPrice) + ", Offer Percent: " + offer.getDiscountPercent() + "%)");
            System.out.println("  Items:");
            for (MenuItems item : offer.getItems()) {
                System.out.println("  - " + item.getName() + " (Price: $" + df.format(item.getPrice()) + ")");
            }
        }
    }
}
    
    
    
    
    
    
    /*


    public void displayOffers() {
    if (offers.isEmpty()) {
        System.out.println("No offers available.");
    } else {
        System.out.println("Today's Offers:");
        for (Offer offer : offers) {
            System.out.println("- " + offer.getDescription() + " (Discount Percent: " + offer.getDiscountPercent() + "%)");
            System.out.println("  Items:");
            for (MenuItems item : offer.getItems()) {
                double discountedPrice = item.getPrice() * (1 - (double) offer.getDiscountPercent() / 100);
                double discountAmount = item.getPrice() - discountedPrice;
                System.out.println("  - " + item.getName() + " (Original Price: $" + item.getPrice() + ", Discounted Price: $" + discountedPrice + ", Discount Amount: $" + discountAmount + ")");
            }
        }
    }
}
    

    public void displayOffers() {
        if (offers.isEmpty()) {
            System.out.println("No offers available.");
        } else {
            System.out.println("Today's Offers:");
            for (Offer offer : offers) {
                System.out.println("- " + offer.getDescription());
                System.out.println("  Items:");
                for (MenuItems item : offer.getItems()) {
                    System.out.println("  - " + item.getName() + " (Price: $" + item.getPrice() + ")");
                }
            }
        }
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*private List<MenuItems> mainDishes;
    private List<MenuItems> desserts;
    private List<MenuItems> drinks;
    private List<MenuItems> appetizers;
    private List<Offer> offers;
    
    public Menu() {
        this.mainDishes = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.appetizers = new ArrayList<>();
        this.offers = new ArrayList<>();
    }

    public void addItem(MenuItems item, String section) {
        switch (section.toLowerCase()) {
            case "main dishes":
                mainDishes.add(item);
                break;
            case "desserts":
                desserts.add(item);
                break;
            case "drinks":
                drinks.add(item);
                break;
            case "appetizers":
                appetizers.add(item);
                break;
            default:
                throw new IllegalArgumentException("Invalid section: " + section);
        }
    }
    
    
    
    private void displaySection(String section) {
    // Remove spaces from the section name
    String sectionWithoutSpaces = section.replaceAll("\\s+", "");
    
    System.out.println(section + ":");
    for (MenuItems item : menuItems) {
        // Remove spaces from the class name before comparison
        String classNameWithoutSpaces = item.getClass().getSimpleName().replaceAll("\\s+", "");
        
        if (classNameWithoutSpaces.equalsIgnoreCase(sectionWithoutSpaces)) {
            System.out.println(item.getName() + " - $" + item.getPrice() + " - " + item.getDiscription());
        }
    }
    
    public void addOffer(Offer offer) {
        offers.add(offer);
    }
    

    public void displayMenu() {
        System.out.println("Main Dishes:");
        displaySection(mainDishes);
        
        System.out.println("\nDesserts:");
        displaySection(desserts);
        
        System.out.println("\nDrinks:");
        displaySection(drinks);
        
        System.out.println("\nAppetizers:");
        displaySection(appetizers);
        
    }
    
    public void removeItem(MenuItems item, String section) {
        switch (section.toLowerCase()) {
            case "main dishes":
                mainDishes.remove(item);
                break;
            case "desserts":
                desserts.remove(item);
                break;
            case "drinks":
                drinks.remove(item);
                break;
            // Add more cases for additional sections
            default:
                throw new IllegalArgumentException("Invalid section: " + section);
        }
    }

    private void displaySection(List<MenuItems> section) {
        for (MenuItems item : section) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
    
    public void displayOffers() {
    if (offers.isEmpty()) {
        System.out.println("No offers available.");
    } else {
        System.out.println("Today's Offers:");
        for (Offer offer : offers) {  // Check capitalization here
            System.out.println("- " + offer.getDescription());
            System.out.println("  Items:");
            for (MenuItems item : offer.getItems()) {  // Check capitalization here
                System.out.println("  - " + item.getName() + " (Price: $" + item.getPrice() + ")");
            }
        }
    }

}*/
     
}
