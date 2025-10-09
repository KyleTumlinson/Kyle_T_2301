/* Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_5.ExpenseTracker;

import java.util.Scanner;

public class ValidatorIO {

    // validate input for an expected integer
    public static int getInt(Scanner sc, String prompt)
    {
        int input = 0;
        boolean isValid = false;
        
        while (!isValid)
        {
            System.out.print(prompt);

            if(sc.hasNextInt())
            {
                input = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        }
        return input;
    }

    // validate input for an expected double
    public static double getDouble(Scanner sc, String prompt)
    {
        double input = 0;
        boolean isValid = false;

        while(!isValid)
        {
            System.out.print(prompt);

            if(sc.hasNextDouble())
            {
                input = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        }
        return input;
    }

    // validate a string input
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
