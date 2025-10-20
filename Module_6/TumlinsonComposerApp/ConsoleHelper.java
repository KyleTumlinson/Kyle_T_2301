/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_6.TumlinsonComposerApp;

import java.util.Scanner;

public final class ConsoleHelper {

    // display the given message
    public static void displayMessage(String message)
    {
        System.out.println(message);
    }

    // set menu options
    public static String menuOptions()
    {
        return ("    1. View Composers\n    2. Find Composer\n    3. Add Composer\n    4. Exit\n\n  Please choose an option: ");
    }

    // process integers that are sent in through the scanner and make sure they are integers
    public static int processInt(Scanner scanner, String prompt)
    {
        int input = 0;
        boolean isValid = false;
        do
        {
            System.out.print(prompt);
            if(scanner.hasNextInt())
            {
                input = scanner.nextInt();
                isValid = true;
            }
            else
            {
                displayMessage("Error: invalid integer input");
            }
            scanner.nextLine();
        }while (!isValid);
        return input;
    }

    // same as above but for strings
    public static String processString(Scanner scanner, String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
