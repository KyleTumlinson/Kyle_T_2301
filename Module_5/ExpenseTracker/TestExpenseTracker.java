/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

/*
    https://stackoverflow.com/questions/59285466/how-to-get-todays-date-in-java-in-the-following-pattern-dd-mm-yyyy
 */

package Module_5.ExpenseTracker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    public static void main(String[] args)
    {
        // create a scanner for user input and a string set to empty for the continue string
        Scanner userInput = new Scanner(System.in);
        String cont = "";
        // we always want the menu at least once
        do
        {
            int input = ValidatorIO.getInt(userInput, displayMenu());
            System.out.println();
            switch(input)
            {
                // if the user selects to display their transactions
                case 1:
                {
                    displayTransactions();
                    break;
                }
                // if the user selects to add transaction(s)
                case 2:
                {
                    addTransaction(userInput);
                    break;
                }
                // if the user selects to view their monthly expenses
                case 3:
                {
                    viewExpense();
                    break;
                }
            }

            // check if the user wants to continue or not
            cont = ValidatorIO.getString(userInput, "\n  Continue? (y/n): ");
        } while(!cont.equalsIgnoreCase("n"));

        System.out.println("\n  Program terminated by user");
    }

    // create the menu
    public static String displayMenu()
    {
        return "\n  MENU OPTIONS" + "\n    1. View Transactions" + "\n    2. Add Transactions" + "\n    3. View Expense" + "\n  Please choose an option: ";
    }

    public static void displayTransactions()
    {
        // due to findall reading from a text file use a try in case of failure
        try{
            System.out.println("  MONTHLY EXPENSES\n");
            ArrayList<Transaction> transactions = TransactionIO.findAll();
            for(Transaction trans : transactions)
            {
                System.out.println("  Date: " + trans.getDate());
                System.out.println("  Description: " + trans.getDescription());
                System.out.printf("  Amount: $%,6.2f\n", trans.getAmount());
            }
        }
        catch(IOException e)
        {
            System.out.println("\n  Exception: " + e.getMessage());
        }
    }

    public static void addTransaction(Scanner userInput)
    {
        String cont = "";
        ArrayList<Transaction> transactions = new ArrayList<>();
        // we want this to also happen at least once
        do
        {
            Transaction newTrans = new Transaction();
            // format the date for the transaction
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            newTrans.setDate(format.format(localDate));

            // get the description for the new transaction
            newTrans.setDescription(ValidatorIO.getString(userInput, "  Enter the description: "));
            System.out.println();

            // get the amount for the new transaction
            newTrans.setAmount(ValidatorIO.getDouble(userInput, "  Enter the amount: "));
            System.out.println();

            // add the transaction to the list of transactions
            transactions.add(newTrans);

            cont = ValidatorIO.getString(userInput, "  Add another transaction? (y/n): ");
        } while(!cont.equalsIgnoreCase("n"));

        try
        {
            TransactionIO.bulkInsert(transactions);
        }
        catch(IOException e)
        {
            System.out.println("\n  Exception: " + e.getMessage());
        }


    }

    public static void viewExpense()
    {
        double total = 0;
        try
        {
            ArrayList<Transaction> transactions = TransactionIO.findAll();
            for(Transaction trans : transactions)
            {
                total += trans.getAmount();
            }

            System.out.printf("  Your total monthly expense is $%,6.2f\n", total);
        }
        catch(IOException e)
        {
            System.out.println("\n  Exception: " + e.getMessage() + "\n");
        }

    }
}
