/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_5.ExpenseTracker;

public class Transaction {
    private String date;
    private String description;
    private double amount;

    // the constructors for Transaction are below

    // no arg constructor for default
    Transaction()
    {
        this.date = "MM-dd-yyyy";
        this.description = "";
        this.amount = 0;
    }

    // constructor that takes all data fields
    Transaction(String date, String description, double amount)
    {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // the getters and setters for Transaction are below
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate()
    {
        return this.date;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return this.description;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return this.amount;
    }
}
