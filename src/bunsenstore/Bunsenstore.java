package bunsenstore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author georgedias
 */

public class Bunsenstore {
    private double totalSpent;
    private List<String> purchasedItems;

    public Bunsenstore() {
        purchasedItems = new ArrayList<>(); //Initialize the list store purchased items
    }

    public void displayMenu() { // Display the main menu options
        System.out.println("---------- Main Menu -s---------");
        System.out.println("1. Burger");
        System.out.println("2. Fries");
        System.out.println("3. Milkshake");
        System.out.println("4. Drink");
        System.out.println("5. Finish your order");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;


        while (choice != 5) {
            System.out.print("Please enter your choice (1-5): ");
            choice = scanner.nextInt();
            
            // Use switch-case to handle user's menu choice
            switch (choice) {
                case 1 -> {
                    BurgerMenu.BurgerMenu(this);
                    System.out.println();
                    break;
                }
                case 2 -> {
                    FriesMenu.FriesMenu(this);
                    System.out.println();
                    break;
                }
                case 3 -> {
                    MilkshakeMenu.MilkshakeMenu(this);
                    System.out.println();
                    break;
                }
                case 4 -> {
                    DrinkMenu.DrinkMenu(this);
                    System.out.println();
                    break;
                }
                case 5 -> finishOrder();
                default -> System.out.println("Invalid choice. Please try again.");
               
            }
        }
    }

    public void finishOrder() { // Method to finalize the order and display the receipt
        System.out.println("Thank you for your shop in Bunsen. Your total spent: $" + totalSpent);
        System.out.println("Items purchased:");
        for (String item : purchasedItems) {
            System.out.println(item);
        }
        System.out.println("Thank you, Have a good day!");
        purchasedItems.clear(); // Clear the purchased items after finishing the order
        totalSpent = 0; // Reset the total spent
    }

    public void setToTotalSpent(double amount) { // Method to add the given amount to the total spent
        totalSpent += amount;
    }

    public void addToPurchasedItems(String item) { // Method to add the purchased item to the list 
        purchasedItems.add(item);
    }

    private double getItemPrice(String item) { // Method to get the price of the item from its formatted string representation
        String[] parts = item.split(" - \\$");// Assuming the items in the bag have the format "quantity item - $price"
        return Double.parseDouble(parts[1]);
    }

    public static void main(String[] args) {
        Bunsenstore bunsenShop = new Bunsenstore();
       
        
        bunsenShop.displayMenu(); // Start the display menu to take the customer's order 
            
        
    }
}