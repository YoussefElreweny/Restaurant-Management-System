/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author mac
 */
public class Tables {
    
    private int tableNumber;
    private boolean isOccupied;
    private Order currentOrder;

    public Tables(int tableNumber) {
        try {
            if (tableNumber <= 0) {
                throw new IllegalArgumentException("Table number must be a positive integer.");
            }
            this.tableNumber = tableNumber;
            this.isOccupied = false;
            this.currentOrder = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    // Getter and setter methods for tableNumber and isOccupied

    public int getTableNumber() {
        return tableNumber;
    }

     public void setTableNumber(int tableNumber) {
        try {
            if (tableNumber <= 0) {
                throw new IllegalArgumentException("Table number must be a positive integer.");
            }
            this.tableNumber = tableNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting table number: " + e.getMessage());
        }
    }
     
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    
    
    // Method to assign an order to the table
    public void assignOrder(Order order) {
        try {
            if (order == null) {
                throw new IllegalArgumentException("Order cannot be null.");
            }
            if (isOccupied) {
                throw new IllegalStateException("Table " + tableNumber + " is already occupied.");
            }
            
            this.currentOrder = order;
            this.isOccupied = true;
            System.out.println("Order assigned to table " + tableNumber);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error assigning order to table: " + e.getMessage());
        }
    }
    // Method to assign an order to the table
    /*public void assignOrder(Order order) {
        if (!isOccupied) {
            this.currentOrder = order;
            this.isOccupied = true;
            System.out.println("Order assigned to table " + tableNumber);
        } else {
            System.out.println("Table " + tableNumber + " is already occupied.");
        }
    }*/

    
    public void clearTable() {
        try {
            if (!isOccupied) {
                throw new IllegalStateException("Table " + tableNumber + " is already vacant.");
            }
            
            this.currentOrder = null;
            this.isOccupied = false;
            System.out.println("Table " + tableNumber + " cleared.");
        } catch (IllegalStateException e) {
            System.out.println("Error clearing table: " + e.getMessage());
        }
    }
    
    /*
    // Method to clear the table after the order is completed
    public void clearTable() {
        if (isOccupied) {
            this.currentOrder = null;
            this.isOccupied = false;
            System.out.println("Table " + tableNumber + " cleared.");
        } else {
            System.out.println("Table " + tableNumber + " is already vacant.");
        }
    }*/

}
