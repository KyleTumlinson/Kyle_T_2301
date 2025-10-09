/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_5.ExpenseTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    // insert an arraylist of transactions into the expenses.txt file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException
    {
        PrintWriter output = null;

        if(file.exists())
        {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else
        {
            output = new PrintWriter(FILE_NAME);
        }

        for(Transaction trans : transactions)
        {
            output.print(trans.getDate() + " ");
            output.print(trans.getDescription() + " ");
            output.println(trans.getAmount());
        }

        output.close();
    }

    // get all of the transactions from a text file
    public static ArrayList<Transaction> findAll() throws IOException
    {
        Scanner fileInput = new Scanner(file);
        ArrayList<Transaction> transactions = new ArrayList<>();
        while(fileInput.hasNext())
        {
            Transaction addedTransaction = new Transaction();
            addedTransaction.setDate(fileInput.next());
            addedTransaction.setDescription(fileInput.next());
            addedTransaction.setAmount(fileInput.nextDouble());
            transactions.add(addedTransaction);
        }
        fileInput.close();
        return transactions;
    }
}
