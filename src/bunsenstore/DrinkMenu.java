package bunsenstore;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author georgedias
 */
class DrinkMenu { // Array of drink items available in the menu
    private static String[] drinkItems = {
        "Coke",
        "7up",
        "Fanta",
        "Coke zero",
        "Diet coke"    
    };
    // Array of drink prices corresponding to each item in the menu
    private static double[] drinkPrices = {
        2.50,
        2.50,
        2.50,
        2.50,
        2.50
    };

    public static void DrinkMenu(Bunsenstore bunsenshop) {
        System.out.println("---------- Drink Menu ----------"); // Display the list of drink items and their prices
        for (int i = 0; i < drinkItems.length; i++) {
            System.out.println((i + 1) + ". " + drinkItems[i] + " - $" + drinkPrices[i]);
        }
        // Display the option to return to the main menu
        System.out.println((drinkItems.length + 1) + ". Return to Main Menu"); 

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Continue looping until the user chooses to return to the main menu
        while (choice != drinkItems.length + 1) {
            System.out.print("Please enter your choice (1-" + (drinkItems.length + 1) + "): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= drinkItems.length) {
                // User has selected a valid drink item
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                // Calculate the total price for the selected quantity of the item
                double totalPrice = drinkPrices[choice - 1] * quantity;
                bunsenshop.setToTotalSpent(totalPrice);

                // Create a string representation of the item and quantity
                String item = quantity + " " + drinkItems[choice - 1];
                bunsenshop.addToPurchasedItems(item); // Add the item to the list of purchased items

                System.out.println(item + " added to your order."); // Display a confirmation message for the added item
            } else if (choice == drinkItems.length + 1) {
                return; // User chose to return to the main menu
            } else { // User entered an invalid choice
                
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

