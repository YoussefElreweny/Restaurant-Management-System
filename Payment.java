/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Payment extends Order implements Payable{
    
    private double amountPaid;
    private Date paymentDate;
    private static double totalProfit;
    private Order order;

    public Payment(int tableNumber, Order order, double amountPaid) {
        super(tableNumber);
        this.order = order;
        this.amountPaid = amountPaid;
        this.paymentDate = new Date(); // Payment date is set to the current date and time
    }

    // Getters and setters for tableNumber, order, amountPaid, and paymentDate
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        try {
            if (amountPaid < 0) {
                throw new IllegalArgumentException("Amount paid cannot be negative.");
            }
            this.amountPaid = amountPaid;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public double getRemainingBalance() {
        return  Math.ceil(amountPaid - getTotalPrice());
    }
    
    public double getTotalPrice(){
        return order.calculateTotalPrice();
    }
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    // Method to calculate the total amount to be paid for the order
    public double calculateTotalAmount(Order order) {
        return order.calculateTotalPrice();
    }


    // Method to process the payment
     public void processPayment() {
        while (amountPaid < getTotalPrice()) {
        System.out.println("Amount paid is less than the total price. Please enter a valid amount.");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the correct payment amount: ");
            double newAmountPaid = scanner.nextDouble();
            if (newAmountPaid < 0) {
                throw new IllegalArgumentException("Amount paid cannot be negative.");
            }
            amountPaid = newAmountPaid;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid numeric value.");
            scanner.next(); // Clear the input buffer
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    totalProfit += calculateTotalPrice(); // Add the total price to total profit
    System.out.println("Payment processed for table " + getTableNumber() + " on " + paymentDate);
    System.out.println("Change: " + getRemainingBalance());
    }

    // Method to get the total profit of the day
    public static double getTotalProfit() {
        return totalProfit;
    }

    
}
