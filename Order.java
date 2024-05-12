/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Order implements Payable{

    private int tableNumber;
    private double totalPrice;
    private List<MenuItems> items;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItems item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    
    // Method to calculate the total price of the order
    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0;

        // Calculate price for each item in the order
        for (MenuItems item : items) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }
    //
    public double calculateItemPrice(MenuItems item){
        return item.getPrice();
    }
    
    private double getAppetizersPriceIfAlone() {
        double totalPrice = 0;
        try {
        for (MenuItems item : items) {
            if (item instanceof Appetizers) {
                totalPrice += ((Appetizers) item).calculatePrice(true);
            }
        }
    } catch (Exception e) {
        // Handle the exception here
        System.err.println("An error occurred while calculating appetizer prices: " + e.getMessage());
        // You can log the exception, display an error message, or take other appropriate actions
    }
    return totalPrice;
    }
    
    // Method to calculate the total price of all drinks in the order
    private double getDrinksPriceIfAlone() {
        double totalPrice = 0;
        try {
        for (MenuItems item : items) {
            if (item instanceof Drinks) {
                totalPrice += ((Drinks) item).calculatePrice(true);
            }
        }
    } catch (Exception e) {
        // Handle the exception here
        System.err.println("An error occurred while calculating appetizer prices: " + e.getMessage());
        // You can log the exception, display an error message, or take other appropriate actions
    }
    return totalPrice;
    }
    
    

     @Override
    public void processPayment() {
        double totalPrice = calculateTotalPrice();
        double amountPaid = 0;

        // Prompt the user for payment amount
        Scanner scanner = new Scanner(System.in);
        while (amountPaid < totalPrice) {
            System.out.println("Total Price: " + totalPrice);
            System.out.print("Enter payment amount: ");
            

           try {
            double payment = scanner.nextDouble();

            if (payment <= 0) {
                throw new IllegalArgumentException("Payment amount must be positive.");
            }

            amountPaid += payment;

            if (amountPaid >= totalPrice) {
                // Payment is sufficient
                System.out.println("Payment successful. Thank you for your order!");
                // Update order status or perform any other necessary actions
                break;
            } else {
                // Payment is insufficient
                double remainingBalance = totalPrice - amountPaid;
                System.out.println("Insufficient payment. Remaining balance: " + remainingBalance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid numeric value.");
            scanner.next(); // Clear the input buffer
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{")
        .append("tableNumber=").append(tableNumber)
        .append(", totalPrice=").append(Math.ceil(totalPrice))
        .append(", items=[");
    
    for (int i = 0; i < items.size(); i++) {
        if (i > 0) {
            sb.append(", ");
        }
        sb.append(items.get(i).getName());
    }
    
    sb.append("]}");
    
    return sb.toString();
    }
    
    
}
    
    
    
    
    
    
    
    
    



/*
    public double calculateItemPrice(MenuItems item) {
    if (item instanceof MainDishes || item instanceof Desserts) {
        return item.getPrice();
    } else if (item instanceof Appetizers || item instanceof Drinks) {
        // For appetizers and drinks, apply a 10% surcharge
        return item.getPrice() * 1.10;
    } else {
        return 0; // Return 0 if the item type is unknown or not supported
    }
    }
    */
    
    /*
    
    
    
    
    public double calculateTotalPrice() {
        double totalPrice = 0;

        // Calculate price for main dishes
        for (MenuItems mainDish : mainDishes) {
            totalPrice += mainDish.getPrice();
        }

        // Calculate price for desserts
        for (MenuItems dessert : desserts) {
            totalPrice += dessert.getPrice();
        }

        // Check if there are more appetizers than main dishes
        if (appetizers.size() > mainDishes.size()) {
            for (MenuItems appetizer : appetizers) {
                totalPrice += calculateExtraPrice(appetizer);
            }
        }

        // Check if there are more drinks than main dishes
        if (drinks.size() > mainDishes.size()) {
            for (MenuItems drink : drinks) {
                totalPrice += calculateExtraPrice(drink);
            }
        }

        return totalPrice;
    }

    // Method to calculate extra price based on the item's type
    private double calculateExtraPrice(MenuItem item) {
        if (item instanceof Appetizer) {
            return ((Appetizer) item).calculatePrice(true);
        } else if (item instanceof Drink) {
            return ((Drink) item).calculatePrice(true);
        } else {
            return item.getPrice(); // No extra price for other items
        }
    }
    
    
    /*
    
    // Method to calculate the total price of the order
    public void calculateTotalPrice() {
        double totalPrice = 0;
        for (MenuItems mainDish : mainDishes) {
            totalPrice += mainDish.getPrice();
        }
        for (MenuItems dessert : desserts) {
            totalPrice += dessert.getPrice();
        }
        if (appetizers != null) {
            totalPrice += getAppetizerPrice();
        }
        if (drink != null) {
            totalPrice += getDrinkPrice();
        }
        this.totalPrice = totalPrice;
    }

    

    // Method to check if the appetizer is added alone
    private boolean appetizerAddedAlone() {
        return (appetizer != null && drink == null && mainDishes.isEmpty() && desserts.isEmpty());
    }

    // Method to check if the drink is added alone
    private boolean drinkAddedAlone() {
        return (drink != null && appetizer == null && mainDishes.isEmpty() && desserts.isEmpty());
    }


    // Method to offer a discount on the appetizer price
    public void offerOnAppetizer(Appetizers appetizer, int offer_percent) {
        if (appetizer instanceof Appetizers) {
            ((Appetizers) appetizer).offer(offer_percent);
        }
    }

    // Method to offer a discount on the drink price
    public void offerOnDrink(Drinks drink, int offer_percent) {
        if (drink instanceof Drinks) {
            ((Drinks) drink).offer(offer_percent);
        }
    }
    

    */

