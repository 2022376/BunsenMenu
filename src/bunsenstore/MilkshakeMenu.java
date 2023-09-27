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
class MilkshakeMenu { // Array of milkshake items available in the menu
    private static String[] milkshakeItems = {
        "Chocolate",
        "Vanila",
        "Strowberry",
        "Saltcaramel"
    };
    // Array of milkshake prices corresponding to each item in the menu
    private static double[] milkshakePrices = {
        5.80,
        5.80,
        5.80,
        5.80
    };

    public static void MilkshakeMenu(Bunsenstore bunsenstore) {
        System.out.println("---------- Milkshake Menu ----------"); // Display the list of milkshake items and their prices
        for (int i = 0; i < milkshakeItems.length; i++) {
            System.out.println((i + 1) + ". " + milkshakeItems[i] + " - $" + milkshakePrices[i]);
        }
        // Display the option to return to the main menu
        System.out.println((milkshakeItems.length + 1) + ". Return to Main Menu"); 

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Continue looping until the user chooses to return to the main menu
        while (choice != milkshakeItems.length + 1) {
            System.out.print("Please enter your choice (1-" + (milkshakeItems.length + 1) + "): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= milkshakeItems.length) {
                // User has selected a valid milkshake item
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                // Calculate the total price for the selected quantity of the item
                double totalPrice = milkshakePrices[choice - 1] * quantity;
                bunsenstore.setToTotalSpent(totalPrice);

                // Create a string representation of the item and quantity
                String item = quantity + " " + milkshakeItems[choice - 1];
                bunsenstore.addToPurchasedItems(item); // Add the item to the list of purchased items

                System.out.println(item + " added to your order."); // Display a confirmation message for the added item
            } else if (choice == milkshakeItems.length + 1) {
                return; // User chose to return to the main menu
            } else { // User entered an invalid choice
                
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

