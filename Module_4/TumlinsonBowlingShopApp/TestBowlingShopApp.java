package Module_4.TumlinsonBowlingShopApp;

import java.util.Scanner;

public class TestBowlingShopApp {
    public static void main(String[] args)
    {
        // create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        // create an empty product generic queue
        GenericQueue<Product> productList = new GenericQueue<>();
        // always want to go at least once
        do {
            displayMenu();
            // get the user input
            userChoice = scanner.nextLine();
            // make the productList have actual products
            productList = ProductDB.getProducts(userChoice);
            if(productList.size() > 0)
            {
                System.out.println("\n  --Product Listing--");
                while(productList.size() > 0)
                {
                    System.out.println(productList.deQueue().toString() + "\n");
                }
            }
            else if(!userChoice.equalsIgnoreCase("x"))
            {
                System.out.println("  Invalid entry'" + userChoice + "' please select a different option");
            }
        } while(!userChoice.equalsIgnoreCase("x"));


        System.out.println("  End of Line");
        scanner.close();
    }

    public static void displayMenu()
    {
        System.out.println("  Menu Options");
        System.out.println("  1. <b> Bowling Balls");
        System.out.println("  2. <a> Bowling Bags");
        System.out.println("  3. <s> Bowling Shoes");
        System.out.println("  4. <x> To Exit");
        System.out.print("\n  Please choose an option: ");
    }
    
}
