/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_6.TumlinsonComposerApp;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    public static void main(String[] args)
    {
        int userOption;
        ConsoleHelper.displayMessage("  Welcome to the Composer App\n");
        MemComposerDao memComp = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);

        // we always want the menu at least once
        do
        {
            // pass all console to ConsoleHelper
            userOption = ConsoleHelper.processInt(scanner, ConsoleHelper.menuOptions());
            // handle the customer input in the function below
            handleOption(scanner, userOption, memComp);
        }while(userOption != 4);
    }

    public static void handleOption(Scanner scanner, int selected, MemComposerDao memComp)
    {
        switch(selected)
        {
            // if the user wants to display all composers
            case 1:
            {
                ConsoleHelper.displayMessage("  --DISPLAYING COMPOSERS--");
                List<Composer> composers = memComp.findAll();
                for(Composer composer : composers)
                {
                    ConsoleHelper.displayMessage("  " + composer.toString());
                }
                ConsoleHelper.displayMessage("\n");
                break;
            }
            // if the user wants to display a specific composer
            case 2:
            {
                int key = ConsoleHelper.processInt(scanner, "Enter an id: ");
                
                Composer composer = memComp.findBy(key);
                if(composer.getId() != 0)
                {
                    ConsoleHelper.displayMessage("  --DISPLAYING COMPOSER--");
                    ConsoleHelper.displayMessage(composer.toString());
                }
                else
                {
                    ConsoleHelper.displayMessage("The given key does not exist\n");
                }
                break;
            }
            
            case 3:
            {
                Composer tempComposer = new Composer();
                tempComposer.setId(ConsoleHelper.processInt(scanner, "  Enter an id: "));
                tempComposer.setName(ConsoleHelper.processString(scanner, "  Enter a name: "));
                tempComposer.setGenre(ConsoleHelper.processString(scanner, "  Enter a genre: "));
                memComp.insert(tempComposer);
                break;
            }
            case 4:
            {
                ConsoleHelper.displayMessage("\n  Process ended by user");
                break;
            }
            default:
            {
                ConsoleHelper.displayMessage("  Error: Invalid option");
            }
        }
    }
}
