/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: : A driver class that utilizes the BevShop class to run a console application, handling user inputs for creating and managing beverage orders.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/

import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Your Total Order for now is 0.0");

            System.out.println("Would you please enter your name:");
            String customerName = scanner.nextLine();

            System.out.println("Would you please enter your age:");
            int customerAge = Integer.parseInt(scanner.nextLine());

            if (customerAge >= BevShopInterface.MIN_AGE_FOR_ALCOHOL) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }

            // Starting a new order with dummy values for time and day.
            bevShop.startNewOrder(10, Day.MONDAY, customerName, customerAge);

            String beverageType;
            do {
                System.out.println("Would you please add a drink:");
                beverageType = scanner.nextLine().toUpperCase();

                if ("COFFEE".equals(beverageType) || "SMOOTHIE".equals(beverageType) || "ALCOHOL".equals(beverageType)) {
                    System.out.println("Please enter the beverage size (SMALL, MEDIUM, LARGE):");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    switch (beverageType) {
                        case "COFFEE":
                            bevShop.processCoffeeOrder("Coffee", size, false, false);
                            break;
                        case "SMOOTHIE":
                            if (!bevShop.isMaxFruit(5)) {
                                bevShop.processSmoothieOrder("Smoothie", size, 5, false);
                            } else {
                                System.out.println("You reached a Maximum number of fruits");
                            }
                            break;
                        case "ALCOHOL":
                            if (bevShop.isValidAge(customerAge) && bevShop.isEligibleForMore()) {
                                bevShop.processAlcoholOrder("Alcohol", size);
                            }
                            break;
                    }
                    System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                }
            } while (!"STOP".equals(beverageType));

            System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getBeverages().size());
            System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

            System.out.println("#------------------------------------#");

            // Checking if user wants to continue for another order
            System.out.println("Would you like to start another order? (yes/no)");
            String continueOrder = scanner.nextLine();

            if (!"yes".equalsIgnoreCase(continueOrder)) {
                break;
            }
        }

        System.out.println("Total price for all Orders: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}
