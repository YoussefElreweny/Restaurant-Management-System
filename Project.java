/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Project {

    public static void main(String[] args) {
        MainDishes burger = new MainDishes("Burger", 9.99, "Classic beef burger");
        MainDishes aurger = new MainDishes("Aurger", 9.99, "Classic beef burger");
        MainDishes pasta = new MainDishes("Pasta", 12.99, "Spaghetti with marinara sauce");
        Desserts cake = new Desserts("Cake", 6.99, "Chocolate cake");
        Desserts iceCream = new Desserts("Ice Cream", 4.99, "Vanilla ice cream");
        Drinks coke = new Drinks("Coke", 2.49, "Classic Coca-Cola");
        Drinks coffee = new Drinks("Coffee", 3.49, "Black coffee");
        Appetizers fries = new Appetizers("Fries", 4.99, "Crispy potato fries");
        Appetizers salad = new Appetizers("Salad", 7.99, "Fresh garden salad");

        // Create menu
        Menu menu = new Menu();
        menu.addItem(burger);
        menu.addItem(aurger);
        menu.addItem(pasta);
        menu.addItem(cake);
        menu.addItem(iceCream);
        menu.addItem(coke);
        menu.addItem(coffee);
        menu.addItem(fries);
        menu.addItem(salad);
        
        
        // Create offers
        List<MenuItems> offerItems1 = new ArrayList<>();
        offerItems1.add(burger);
        offerItems1.add(coke);
        Offer offer1 = new Offer(offerItems1, 15, "Combo Deal 1");
        List<MenuItems> offerItems2 = new ArrayList<>();
        offerItems2.add(pasta);
        offerItems2.add(coffee);
        Offer offer2 = new Offer(offerItems2, 10, "Combo Deal 2");

        // Add offers to the menu
        menu.addOffer(offer1);
        menu.addOffer(offer2);

        // Display menu and offers
        menu.displayMenu();
        menu.displayOffers();

        // Create orders
        Order order1 = new Order(1);
        order1.addItem(burger);
        order1.addItem(coke);
        Order order2 = new Order(2);
        order2.addItem(pasta);
        order2.addItem(coffee);

        // Assign orders to tables
        Tables table1 = new Tables(1);
        table1.assignOrder(order1);
        Tables table2 = new Tables(2);
        table2.assignOrder(order2);

        // Display orders assigned to tables
        System.out.println("Orders assigned to tables:");
        System.out.println(order1.toString());
        System.out.println(order2.toString());

        // Process payments
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount paid for order 1: ");
        double amountPaid1 = scanner.nextDouble();
        Payment payment1 = new Payment(order1.getTableNumber(), order1, amountPaid1);
        payment1.processPayment();

        System.out.print("Enter amount paid for order 2: ");
        double amountPaid2 = scanner.nextDouble();
        Payment payment2 = new Payment(order2.getTableNumber(), order2, amountPaid2);
        payment2.processPayment();
        
    }
}
