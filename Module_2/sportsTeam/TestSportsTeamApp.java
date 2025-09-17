/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */
package Module_2.sportsTeam;

import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); // scanner to take in user input
        String[] playerArray = new String[20];
        String players;
        String cont; // string for if the user wants to continue
        System.out.println("  Welcome to the Sports Team App");
        // make sure that the menu pops up at least once with a do while loop
        do{
            players = new String("");
            // get the team name and make a new team with it
            System.out.print("\n  Enter a team name: ");
            Team team1 = new Team(scanner.nextLine());
            
            // get the team members by splitting the user input
            System.out.print("\n  Enter the player names:\n hint: use commas for multiple players; no spaces>: ");
            playerArray = scanner.nextLine().split(",");
            for (String player : playerArray) {
                // if the team is less than 20 players add the player with the current player name
                if(team1.getPlayerCount() < 20)
                {
                    team1.AddPlayer(player);
                }
            }
            // output the team summary
            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team: " + team1.getPlayerCount()); // output the number of players using a call to getPlayerCount
            System.out.print("  Players on team: ");
            // make sure that there are players on the team
            if(team1.getPlayerCount() > 0)
            {
                // if there are players on the team get the array of players from the team
                String[] playersInTeam = team1.getPlayers();
                // loop through the array of players
                for (int playerIndex = 0; playerIndex < team1.getPlayerCount(); playerIndex++) {
                    // if this is the last player no need for comma, add new line instead
                    if(playerIndex == (team1.getPlayerCount() - 1))
                    {
                        // add the player from the playersInTeam array to the string of players
                        players += playersInTeam[playerIndex] + "\n";
                    }
                    else
                    {
                        // if this is not the last player add a comma to separate from other players
                        // add the player from the playersInTeam array to the string of players
                        players += playersInTeam[playerIndex] + ",";
                    }
                }
                System.out.print("  " + players);
            }
            // check if user wants to continue AFTER verifying that the input is either y or n
            System.out.print("\n  Continue? (y/n)");
            // check the users input with the checkValidInput function passing in the line from continue and the scanner
            cont = checkValidInput(scanner.nextLine(), scanner);
            
        } while(cont.toLowerCase().equals("y"));
        // when the user is done exit the program and close the scanner
        System.out.println("  End of line...");
        scanner.close();
    }

    // this function will check if the user input y or n in the continue input
    static String checkValidInput(String cont, Scanner scanner)
    {
        // if the user input is not a y or a n loop until they put in a y or a n
        while(!cont.toLowerCase().equals("y") && !cont.toLowerCase().equals("n"))
        {
            System.out.print("\n  Invalid input Continue? (y/n): ");
            cont = scanner.nextLine();
        }
        return cont;
    }
    
}
