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
class FriesMenu { // Array of fries items available in the menu
    private static String[] friesItems = {
        "Shoestring",
        "Hand cut",
        "Sweet potato"
    };
    // Array of fries prices corresponding to each item in the menu
    private static double[] friesPrices = {
        4.00,
        4.00,
        5.50
    };

    public static void FriesMenu(Bunsenstore bunsenshop) {
        System.out.println("---------- Fries Menu ----------"); // Display the list of fries items and their prices
        for (int i = 0; i < friesItems.length; i++) {
            System.out.println((i + 1) + ". " + friesItems[i] + " - $" + friesPrices[i]);
        }
        // Display the option to return to the main menu
        System.out.println((friesItems.length + 1) + ". Return to Main Menu"); 

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Continue looping until the user chooses to return to the main menu
        while (choice != friesItems.length + 1) {
            System.out.print("Please enter your choice (1-" + (friesItems.length + 1) + "): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= friesItems.length) {
                // User has selected a valid fries item
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                // Calculate the total price for the selected quantity of the item
                double totalPrice = friesPrices[choice - 1] * quantity;
                bunsenshop.setToTotalSpent(totalPrice);

                // Create a string representation of the item and quantity
                String item = quantity + " " + friesItems[choice - 1];
                bunsenshop.addToPurchasedItems(item); // Add the item to the list of purchased items

                System.out.println(item + " added to your order."); // Display a confirmation message for the added item
            } else if (choice == friesItems.length + 1) {
                return; // User chose to return to the main menu
            } else { // User entered an invalid choice
                
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

