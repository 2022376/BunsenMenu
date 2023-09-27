package bunsenstore;

import java.util.Scanner;

/**
 *
 * @author georgedias
 */


class BurgerMenu { //// Array of food items available in the menu
    private static String[] burgerItems = {
        "Cheeseburger",
        "Hamburger",
        "DoubleCheeseburger",
        "Doublehamburger"
    };

    // Array of burger prices corresponding to each item in the menu
    private static double[] burgerPrices = {
        9.50,
        8.50,
        11.50,
        11.00
    };

    public static void BurgerMenu(Bunsenstore bunsenstore) {
        System.out.println("---------- Burger Menu ----------");
      
        // Display the list of burger items and their prices
        for (int i = 0; i < burgerItems.length; i++) {
            System.out.println((i + 1) + ". " + burgerItems[i] + " - $" + burgerPrices[i]);
        }
        // Display the option to return to the main menu
        System.out.println((burgerItems.length + 1) + ". Return to Main Menu");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Continue looping until the user chooses to return to the main menu
        while (choice != burgerItems.length + 1) {
            System.out.print("Please enter your choice (1-" + (burgerItems.length + 1) + "): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= burgerItems.length) {
                // User has selected a valid food item
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                // Calculate the total price for the selected quantity of the item
                double totalPrice = burgerPrices[choice - 1] * quantity;
                bunsenstore.setToTotalSpent(totalPrice);

                // Create a string representation of the item and quantity
                String item = quantity + " " + burgerItems[choice - 1];
                // Add the item to the list of purchased items
                bunsenstore.addToPurchasedItems(item);

                // Display a confirmation message for the added item
                System.out.println(item + " added to your order.");
            } else if (choice == burgerItems.length + 1) {
                // User chose to return to the main menu
                return;
            } else {
                // User entered an invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

