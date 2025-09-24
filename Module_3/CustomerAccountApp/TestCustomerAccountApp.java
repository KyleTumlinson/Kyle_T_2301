package CustomerAccountApp;
/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCustomerAccountApp {
    public static void main(String[] args)
    {
        boolean cont; // boolean for if the customer wants to continue
        int customerID; // integer for the customer id
        double balance; // double fpr balance of the account
        String transactionOption; // string for the transaction option
        Customer customer = new Customer(); // customer, set to default in case try fails
        Account testAccount = new Account(); // account to be used for testing
        Scanner scanner = new Scanner(System.in); // scanner for user input
        // welcome the customer
        System.out.println("  Welcome to the Customer Account App");
        // try to get the customer id
        try
        {
            System.out.println("\n  Enter a customer ID:");
            System.out.print("\tex: 1007, 1008, 1009>: ");
            customerID = scanner.nextInt();
            scanner.nextLine();
            customer = CustomerDB.getCustomer(customerID);
        }
        catch(InputMismatchException e)
        {
            System.out.println("  Error: Invalid Option");
        }
        // we want the menu to pop up at least one time
        do
        {
            testAccount.displayMenu(); // display the menu
            transactionOption = scanner.nextLine().toUpperCase(); // get the transaction option using the scanner and setting to upper case
            testAccount.handleTransaction(transactionOption, scanner); // use the handleTransaction method to handle the requested transaction
            cont = checkContinue(scanner); // see if the user wants to continue or not
        } while(cont);
        System.out.println("\n  --Customer Details--");
        System.out.println(customer.toString()); // output the customer data
        balance = testAccount.getBalance(); // get the balance of the account
        System.out.printf("\n  Balance as of %s is $%,6.2f", testAccount.getTransactionDate(), balance); // output the balance in the given format
        System.out.println("\n  End of line...");

        // always close scanners
        scanner.close();
    }

    public static boolean checkContinue(Scanner scanner)
    {
        String cont;
        // we want this to happen at least once as well
        do
        {
            // ask the user if they want to continue
            System.out.print("\n  Continue? (y/n): ");
            // get the response and set to lower case
            cont = scanner.nextLine().toLowerCase();
            // if the cont string is not y or n let the user know they did something wrong
            if(!cont.equals("y") && !cont.equals("n"))
            {
                System.out.println("  Error: Invalid Option");
            }
        } while(!cont.equals("y") && !cont.equals("n"));
        
        // return true if y
        if(cont.equals("y"))
        {
            return true;
        }
        // return false if n
        return false;
    }
}
