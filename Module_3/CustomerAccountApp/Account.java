package CustomerAccountApp;
/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

/*
Walia, A. S., & Kumar, P. (2024, December 20). Master Java Date Formatting: SimpleDateFormat & DateFormat Guide. 
https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Account {
    // balance of the account
    private double balance = 200;
    
    // getters for the account will be below
    public double getBalance()
    {
        return this.balance;
    }

    // deposit the amount given to the account
    public void deposit(double amt)
    {
        balance += amt;
    }

    // if the account will not be overdrawn withdraw the amount given
    public void withdraw(double amt)
    {
        if(balance >= amt)
        {
            balance -= amt;
        }
        else
        {
            System.out.println("Unable to withdraw more than you have in the account");
        }
    }

    // display the main menu
    public void displayMenu()
    {
        System.out.println("\n  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("    Enter option: ");
    }

    // handle the given transaction(string), scanner is passed in to handle user input
    public void handleTransaction(String transactionOption, Scanner scanner)
    {
        switch(transactionOption)
        {
            // handle deposit
            case "D":
            {
                System.out.print("  Enter deposit amount: ");
                try
                {
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    deposit(amount);
                }
                catch(Exception e)
                {
                    System.out.println("  Error: Invalid Option");
                }
                break;
            }
            // handle withdraw
            case "W":
            {
                System.out.print("  Enter withdraw amount: ");
                try
                {
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    withdraw(amount);
                }
                catch(Exception e)
                {
                    System.out.println("  Error: Invalid Option");
                }
                break;
            }
            // handle balance
            case "B":
            {
                System.out.printf("  Account balance: $%,6.2f\n", getBalance());
                break;
            }
            // default(error)
            default:
            {
                System.out.println("  Error: Invalid Option");
            }
        }
    }

    // get the transaction date in the format MM-dd-yyyy
    public String getTransactionDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String date = format.format(new Date());
        return date;
    }
}
