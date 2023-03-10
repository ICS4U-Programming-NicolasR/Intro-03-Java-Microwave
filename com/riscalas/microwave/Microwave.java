package com.riscalas.microwave;
import java.util.Scanner;
/**
* Calculates the time needed in a microwave.
*
* @author  riscalas
* @version 1.0
* @since   2023-02-22
*/

public final class Microwave {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     *
     */
    public static void main(final String[] args) {
        // Create the constants
        final int pizzaTime = 45;
        final int subTime = 60;
        final int soupTime = 105;
        final double one = 1;
        final double two = 2;
        final int maxFood = 4;
        final int minFood = 0;
        final double secInMin = 60;
        final String sub = "SUB";
        final String pizza = "PIZZA";
        final String soup = "SOUP";
        double time = 0.0;
        // Created a scanner object
        final Scanner inputScan = new Scanner(System.in);
        // Ask the user for the type of food
        System.out.println("What is the type of food you'd like to heat up?"
                            + "(soup, sub, pizza)");
        final String food = inputScan.nextLine().toUpperCase();
        if (sub.equals(food) || pizza.equals(food) || soup.equals(food)) {
            // Ask the user for quantity of food
            System.out.println("What is the quantity of the food you'd like to"
                    + " heat?");
            // Error catching
            try {
                // get the quantity as a number
                final double quantity = inputScan.nextInt();
                if (quantity > minFood && quantity < maxFood) {
                    final double timeMod = ((quantity - one) / two) + one;
                    if (pizza.equals(food)) {
                        time = pizzaTime;
                    } else if (sub.equals(food)) {
                        time = subTime;
                    } else {
                        time = soupTime;
                    }
                    final double totalSec = timeMod * time;
                    final double timeSec = totalSec % secInMin;
                    final double timeMin = totalSec / secInMin;
                    System.out.format("The time you need to enter is %d:%02d\n",
                            (int) timeMin, (int) timeSec);
                } else {
                    System.out.println("You've entered an invalid quantity "
                        + "Must be more than 0 and less than 4");
                }
                // catch the error
            } catch (java.util.InputMismatchException error) {
                System.out.println("You may have entered an invalid input "
                        + "You must enter an integer number\n"
                        + error);
            }
        } else {
            System.out.println("You have entered an invalid input."
                    + " The only possible options are sub, pizza or soup");
        }
        inputScan.close();
    }
}
